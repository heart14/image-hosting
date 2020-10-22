package com.example.heart.imagehosting.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.heart.imagehosting.common.SysConstants;
import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.common.SysProperties;
import com.example.heart.imagehosting.exception.AppBizException;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: JwtUtils
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/6/28 14:10
 * @Version: v1.0
 */
@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * 由私钥生成加密密钥
     *
     * @return
     */
    private static SecretKey generalKey() {
        String stringKey = SysConstants.JWT_TOKEN_SECRET;
        // 本地的密码解码
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 创建jwt
     *
     * @param id
     * @param issuer
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String issueJwt(String id, String issuer, String subject, long ttlMillis) throws Exception {
        // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成签名的时候使用的秘钥secret，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。
        // 一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        SecretKey key = generalKey();

        // 生成JWT的时间
        long currentTimeMillis = System.currentTimeMillis();
        Date issueTime = new Date(currentTimeMillis);

        // 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>(3);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("system", "SysProperties.SYSTEM_NAME");
        jsonObject.put("developer", "heart");
        jsonObject.put("timestamp", System.currentTimeMillis());
        claims.put("private", jsonObject.toJSONString());

        // 下面就是在为payload添加各种标准声明和私有声明了
        // 这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(id)
                // iat: jwt的签发时间
                .setIssuedAt(issueTime)
                // issuer：jwt签发人
                .setIssuer(issuer)
                // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roleid之类的，作为什么用户的唯一标志。
                .setSubject(subject)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, key);

        // 设置过期时间
        if (ttlMillis >= 0) {
            long expMillis = currentTimeMillis + ttlMillis;
            Date expireTime = new Date(expMillis);
            builder.setExpiration(expireTime);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJwt(String jwt) throws AppBizException {
        Claims claims = null;
        try {
            //签名秘钥，和生成的签名的秘钥一模一样
            SecretKey key = generalKey();
            //得到DefaultJwtParser
            claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(key)
                    //设置需要解析的jwt
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            logger.error("解密jwt异常 :{}", e.getMessage(), e);
            throw new AppBizException(SysErrorCode.ServiceException.getCode(), SysErrorCode.ServiceException.getMsg());
        }
        return claims;
    }

    /**
     * 解析token，获取用户信息
     *
     * @param token
     * @throws AppBizException
     */
    public static String parseToken(String token) throws AppBizException {
        if (StringUtils.isBlank(token)) {
            throw new AppBizException(SysErrorCode.UnknownParamException.getCode(), SysErrorCode.UnknownParamException.getMsg());
        }
        byte[] decode = java.util.Base64.getDecoder().decode(token.split("\\.")[1]);
        String s = new String(decode);
        logger.info("Jwt token playload :{}", s);
        JSONObject playload = JSONObject.parseObject(s);
        JSONObject subject = playload.getJSONObject("sub");
        return subject.getString("userId");
    }

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject(3);
        jsonObject.put("userId", "94213");
        jsonObject.put("userName", "heart");
        jsonObject.put("userRole", "admin");

        String subject = jsonObject.toJSONString();
        String jwtId = UUID.randomUUID().toString().toUpperCase();

        try {
            String jwt = JwtUtils.issueJwt(jwtId, "H", subject, SysConstants.JWT_TOKEN_TTL);
            System.out.println("jwt :" + jwt);

            System.out.println("\n解密\n");

            Claims c = JwtUtils.parseJwt(jwt);
            System.out.println("jwt id :"+c.getId());
            System.out.println("jwt issuedAt :"+c.getIssuedAt());
            System.out.println("jwt subject :"+c.getSubject());
            System.out.println("jwt issuer :"+c.getIssuer());
            System.out.println("jwt expiration :"+c.getExpiration());
            System.out.println(c.get("private", String.class));
            JwtUtils.parseToken(jwt);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
