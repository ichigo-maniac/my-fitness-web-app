package com.my.fitness.services.impl;

import javax.servlet.http.HttpSession;
import com.my.fitness.services.SessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Session service
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {

    /**
     * Get current http-session
     * @return Http-session
     */
    public HttpSession getCurrentSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(false);
    }

    /**
     * Set session attribute
     * @param name  Session attribute name
     * @param value Session attribute value
     */
    public void setSessionAttribute(String name, Object value) {
        getCurrentSession().setAttribute(name, value);
    }


    /**
     * Get session attribute
     * @param name Session attribute name
     * @return Session attribute
     */
    public Object getSessionAttribute(String name) {
        return getCurrentSession().getAttribute(name);
    }

}
