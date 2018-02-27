package com.my.fitness.services;

import javax.servlet.http.HttpSession;

/**
 * Session service interface
 */
public interface SessionService {

    /**
     * Get current http-session
     * @return Http-session
     */
    HttpSession getCurrentSession();

    /**
     * Set session attribute
     * @param name Session attribute name
     * @param value Session attribute value
     */
    void setSessionAttribute(String name, Object value);

    /**
     * Get session attribute
     * @param name Session attribute name
     * @return Session attribute
     */
    Object getSessionAttribute(String name);

}
