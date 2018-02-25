package com.my.fitness.controllers.oauth2;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.enums.SocialNetworkType;
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
     * Authorize the user or create a new one
     * @param socialNetworkType Social network type
     * @param socialNetworkId Social network id
     * @param name User name
     * @param email User email
     * @return Redirect path
     */
    protected String authorizeUser(SocialNetworkType socialNetworkType, String socialNetworkId, String name, String email) {
        return FitnessWebAppConstants.REDIRECT.HOME;
    }

}
