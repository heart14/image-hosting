package com.example.heart.imagehosting.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;

/**
 * @ClassName: ShiroRedisSessionDAO
 * @Description: 自定义SessionDAO，实现redis中session的CURD
 * @Author: lwf14
 * @Date: 2020/2/21 18:40
 * @Version: v1.0
 */
public class ShiroRedisSessionDAO extends AbstractSessionDAO {
    @Override
    protected Serializable doCreate(Session session) {
        return null;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {

    }

    @Override
    public void delete(Session session) {

    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }
}
