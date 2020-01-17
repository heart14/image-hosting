package com.example.heart.imagehosting.filter;

import com.example.heart.imagehosting.utils.IpUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: SysFormAuthorizationFilter
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2020/1/17 17:33
 * @Version: v1.0
 */
@WebFilter(filterName = "optionsFilter", urlPatterns = "/*")
public class SysFormAuthorizationFilter extends FormAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(SysFormAuthorizationFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (HttpMethod.OPTIONS.toString().equalsIgnoreCase(httpServletRequest.getMethod())) {
            StringBuffer requestUrl = httpServletRequest.getRequestURL();
            String ipAddress = IpUtils.getIpAddr(httpServletRequest);
            logger.info("OPTIONS GO! [{}][{}]", ipAddress, requestUrl);
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
