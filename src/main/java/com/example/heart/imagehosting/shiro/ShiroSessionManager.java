package com.example.heart.imagehosting.shiro;

import com.example.heart.imagehosting.utils.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @ClassName: ShiroSessionManager
 * @Description: 因为要使用redis进行存储session, 所以不使用默认的shiro默认的SessionManager, 而是重写SessionManager自定义会话管理器
 * @Author: jayhe
 * @Date: 2020/1/22 9:13
 * @Version: v1.0
 */
public class ShiroSessionManager extends DefaultWebSessionManager {

    private static final Logger logger = LoggerFactory.getLogger(ShiroSessionManager.class);

    public ShiroSessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        logger.info("ShiroSessionManager.getSessionId() start...");
        String authorization = WebUtils.toHttp(request).getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            logger.info("Web request header contains Authorization? NO");
            logger.info("ShiroSessionManager.getSessionId() over.");
            return super.getSessionId(request, response);
        } else {
            logger.info("Web request header contains Authorization? YES[{}]", authorization);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, authorization);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            logger.info("ShiroSessionManager.getSessionId() over.");
            return authorization;
        }
    }
}
