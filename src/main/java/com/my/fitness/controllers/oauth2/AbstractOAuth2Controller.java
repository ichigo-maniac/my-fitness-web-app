package com.my.fitness.controllers.oauth2;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.dto.AccountEntityDto;
import com.my.fitness.enums.SocialNetworkType;
import com.my.fitness.facades.UserFacade;
import com.my.fitness.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.stereotype.Controller;

/**
 * Abstract oauth2 controller
 */
@Controller
public class AbstractOAuth2Controller {

    /**
     * Oauth connection repository
     */
    @Autowired
    protected ConnectionFactoryRegistry connectionRepository;

    /**
     * Account service
     */
    @Autowired
    private AccountService accountService;

    /**
     * User facade
     */
    @Autowired
    private UserFacade userFacade;

    /**
     * Authorize the user or create a new one
     * @param socialNetworkType Social network type
     * @param socialNetworkId Social network id
     * @param name User name
     * @param email User email
     * @return Redirect path
     */
    protected String authorizeUser(SocialNetworkType socialNetworkType, String socialNetworkId, String name, String email) {
        if (!userFacade.isCurrentUserAnonymous()) {
            return FitnessWebAppConstants.REDIRECT.DASHBOARD;
        }
        AccountEntityDto account = accountService.getOrCreateAccount(socialNetworkId, socialNetworkType, name);
        if (account != null) {
            userFacade.logInUser(account);
            return FitnessWebAppConstants.REDIRECT.DASHBOARD;
        }
        return FitnessWebAppConstants.REDIRECT.HOME;
    }

}
