package com.my.fitness.facades.impl;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.facades.UserFacade;
import com.my.fitness.secutiry.AccountUserDetails;
import com.my.fitness.services.AccountService;
import com.my.fitness.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;

/**
 * User facade
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    /**
     * Account service
     */
    @Autowired
    private AccountService accountService;

    /**
     * Session service
     */
    @Autowired
    private SessionService sessionService;

    /**
     * Log in user
     * @param accountDto User account data transfer object
     * @return Log in result
     */
    @Override
    public boolean logInUser(AccountEntityDto accountDto) {
        AccountEntityDto currentUser = accountService.getAccountByUUID(accountDto.getUuid());
        if (currentUser == null) {
            return false;
        }
        AccountUserDetails accountUserDetails = new AccountUserDetails(accountDto);
        Authentication authentication = new UsernamePasswordAuthenticationToken(accountUserDetails, accountUserDetails.getPassword(), accountUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        sessionService.setSessionAttribute(FitnessWebAppConstants.SESSION_ATTRIBUTES.CURRENT_USER, currentUser);
        return true;
    }

    /**
     * Is current user anonymous
     * @return Check result - Is current user anonymous
     */
    @Override
    public boolean isCurrentUserAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return true;
        }
        if ((authentication.getPrincipal() instanceof AccountUserDetails)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Get current user account
     * @return Current user account
     */
    @Override
    public AccountEntityDto getCurrentUser() {
        AccountEntityDto sessionUser = (AccountEntityDto) sessionService.getSessionAttribute(FitnessWebAppConstants.SESSION_ATTRIBUTES.CURRENT_USER);
        if (sessionUser != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                if (authentication.getPrincipal() instanceof AccountUserDetails) {
                    AccountUserDetails userDetails = (AccountUserDetails) authentication.getPrincipal();
                    return sessionUser.getUuid().equals(userDetails.getUsername()) ? sessionUser : null;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Logout current user
     */
    @Override
    public void logOutCurrentUser() throws ServletException {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        attr.getRequest().logout();
    }
}
