package com.example.heart.imagehosting.sdk.smms.utils;

import com.example.heart.imagehosting.common.SysErrorCode;
import com.example.heart.imagehosting.exception.AppBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: HttpUtils
 * @Description: sm.ms v2 api接口请求工具类
 * @Author: jayhe
 * @Date: 2020/1/8 17:30
 * @Version: v1.0
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(com.example.heart.imagehosting.utils.HttpUtils.class);

    /**
     * Http get请求
     *
     * @param apiUrl
     * @return
     */
    public static String doGet(String apiUrl, String token) throws AppBizException {
        logger.info("HTTP GET URL :{}", apiUrl);
        logger.info("HTTP GET TOKEN :{}", token);

        StringBuffer respContent = new StringBuffer();
        BufferedReader bufferedReader = null;

        try {
            //第一步：获取URL
            URL url = new URL(apiUrl);
            //第二步：使用URL获取URLConnection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //第三步：设置相应属性
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Connection", "close");
            //httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            httpURLConnection.setRequestProperty("Authorization", token);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            //第四步：获取响应报文
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                respContent.append(line);
            }
        } catch (Exception e) {
            logger.error("HTTP发送GET请求出现异常! {}", e.getMessage());
            throw new AppBizException(SysErrorCode.HttpException.getCode(), SysErrorCode.HttpException.getMsg());
        } finally {
            //第五步：关闭IO流
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.warn("关闭IO流异常 : {}", e.getMessage());
            }
        }
        logger.info("HTTP请求响应数据 : {}", respContent);
        return respContent.toString();
    }

    /**
     * Http post请求
     *
     * @param apiUrl
     * @param param
     * @return
     */
    public static String doPost(String apiUrl, String param, String token) {
        logger.info("HTTP POST URL :{}", apiUrl);
        logger.info("HTTP POST PARAMS :{}", param);
        logger.info("HTTP POST TOKEN :{}", token);

        StringBuffer respContent = new StringBuffer();
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        try {
            //第一步：获取URL
            URL url = new URL(apiUrl);
            //第二步：使用URL获取URLConnection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //第三步：设置相应属性
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "close");
            //httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");
            if (token != null && token.trim().length() != 0 && (!"null".equalsIgnoreCase(token))) {
                httpURLConnection.setRequestProperty("Authorization", token);
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            //httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            //httpURLConnection.setRequestProperty("Content-Length", String.valueOf(param.length()));
            /*
                Content-Type为application/json时，param参数形式为json字符串
                {"key":"value","key":"value"}
                如果不设置Content-Type为application/json，那在POST传参数的时候，参数该以什么样的形式传过来呢？
                key=value&key=value
             */

            //如果需要传输数据并接受返回数据，需要设置下面两项
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            //第四步：使用IO流将数据写出
            printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(param);
            printWriter.flush();
            //第五步：获取响应报文
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                respContent.append(line);
            }
        } catch (Exception e) {
            logger.error("HTTP发送POST请求出现异常! {}", e.getMessage());
            throw new AppBizException(SysErrorCode.HttpException.getCode(), SysErrorCode.HttpException.getMsg());
        } finally {
            //第六步：关闭IO流
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.warn("关闭IO流异常 : {}", e.getMessage());
            }
        }
        logger.info("HTTP请求响应数据 : {}", respContent);
        return respContent.toString();
    }

    /**
     * Http Post Image
     * SM.MS图床 图片上传工具类
     *
     * @param apiUrl
     * @param file
     * @return
     */
    public static String doPostImage(String apiUrl, File file, String token) {

        //构建分隔符
        String boundary = "----WebKitFormBoundaryxAOG84Q7owWpL7ZR";
        String prefix = "--";
        String suffix = "\r\n";

        //接收响应数据
        StringBuilder respContent = new StringBuilder();

        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;

        try {
            //创建URL连接
            URL url = new URL(apiUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            //设置为POST请求
            httpURLConnection.setRequestMethod("POST");

            //发送POST请求必须设置如下两行
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);

            //设置请求头参数
            httpURLConnection.setRequestProperty("Authorization", token);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            //上传文件

            //构建Http请求参数头
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(suffix);
            stringBuilder.append(suffix);
            stringBuilder.append(prefix);
            stringBuilder.append(boundary);
            stringBuilder.append(suffix);

            stringBuilder.append("Content-Disposition: form-data; name=\"smfile\"; filename=\"" + file.getName() + "\"");
            stringBuilder.append(suffix);
            stringBuilder.append("Content-Type: image/" + file.getName().substring(file.getName().lastIndexOf(".") + 1));
            stringBuilder.append(suffix);
            stringBuilder.append(suffix);


            outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            //将参数头的数据写入到输入流中
            outputStream.write(stringBuilder.toString().getBytes());

            //数据输入流，用于读取文件数据
            dataInputStream = new DataInputStream(new FileInputStream(file));
            byte[] bufferOut = new byte[1024];
            int bytes = 0;
            //每次读1kb数据，并将文件数据写入到输入流中
            while ((bytes = dataInputStream.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            //最后添加换行
            outputStream.write(suffix.getBytes());

            //定义最后数据分隔线，即--加上boundary加上--
            byte[] end_data = (prefix + boundary + prefix + suffix).getBytes();
            outputStream.write(end_data);

            outputStream.flush();

            //读取URL的响应
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                respContent.append(line);
            }

        } catch (Exception e) {
            logger.error("HTTP发送POST请求出现异常! {}", e.getMessage());
            throw new AppBizException(SysErrorCode.HttpException.getCode(), SysErrorCode.HttpException.getMsg());
        } finally {
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.warn("关闭IO流异常：{}", e.getMessage());
            }
        }

        logger.info("SM.MS上传结果 : {}", respContent);
        return respContent.toString();
    }
}
