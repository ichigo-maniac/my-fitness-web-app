package com.my.fitness.facades;

import javax.servlet.ServletException;
import com.my.fitness.dto.AccountEntityDto;

/**
 * User facade interface
 */
public interface UserFacade {

    /**
     * Log in user
     * @param accountDto User account data transfer object
     * @return Log in result
     */
    boolean logInUser(AccountEntityDto accountDto);

    /**
     * Is current user anonymous
     * @return Check result - Is current user anonymous
     */
    boolean isCurrentUserAnonymous();

    /**
     * Get current user account
     * @return Current user account
     */
    AccountEntityDto getCurrentUser();

    /**
     * Logout current user
     */
    void logOutCurrentUser() throws ServletException;
}
