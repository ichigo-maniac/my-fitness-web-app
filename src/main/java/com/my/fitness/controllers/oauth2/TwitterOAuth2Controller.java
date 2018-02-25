package com.my.fitness.controllers.oauth2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.fitness.constants.FitnessWebAppConstants;
import com.my.fitness.enums.SocialNetworkType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.UserOperations;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Twitter oauth controller
 */
@Controller
public class TwitterOAuth2Controller extends AbstractOAuth2Controller {

    /**
     * Succeed redirect path
     */
    private static final String SUCCEED_REDIRECT_PATH = "/oauth/twitter_succeed_redirect";

    /**
     * Properties
     */
    @Value("${my.fitness.app.host}")
    private String appHost;

    /**
     * Connect to facebook to obtain attributes
     * @param response Http-response
     * @throws IOException Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/oauth/twitter")
    @ResponseBody
    public void connectToTwitter(HttpServletResponse response) throws IOException {
        /** Connect to twitter */
        TwitterConnectionFactory factory = (TwitterConnectionFactory) connectionRepository.getConnectionFactory(Twitter.class);
        OAuth1Operations oauthOperations = factory.getOAuthOperations();
        OAuthToken requestToken = oauthOperations.fetchRequestToken(appHost + SUCCEED_REDIRECT_PATH, null);
        String authorizeUrl = oauthOperations.buildAuthorizeUrl(requestToken.getValue(), OAuth1Parameters.NONE);
        response.sendRedirect(authorizeUrl);
    }

    /**
     * Facebook succeed redirect
     * @param request Http-request
     * @return Url redirect
     */
    @RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.GET, value = SUCCEED_REDIRECT_PATH)
    public String succeedRedirect(HttpServletRequest request) {
        /** Check oauth token and verifier */
        String oauthToken = request.getParameter("oauth_token");
        String oauthVerifier = request.getParameter("oauth_verifier");
        if (oauthToken == null || oauthVerifier == null) {
            return FitnessWebAppConstants.REDIRECT.HOME;
        }
        /** Create connection and load data */
        TwitterConnectionFactory factory = (TwitterConnectionFactory) connectionRepository.getConnectionFactory(Twitter.class);
        OAuth1Operations oauthOperations = factory.getOAuthOperations();
        OAuthToken token  = oauthOperations.exchangeForAccessToken(new AuthorizedRequestToken(
                new OAuthToken(oauthToken, null), oauthVerifier), null);

        Connection<Twitter> connection = factory.createConnection(token);
        Twitter twitter = connection.getApi();
        UserOperations userOperations =  twitter.userOperations();
        /** Load data */
        Long profileId = userOperations.getProfileId();
        String firstName = connection.fetchUserProfile().getFirstName();
        String lastName = connection.fetchUserProfile().getLastName();
        String email = connection.fetchUserProfile().getEmail();
        return authorizeUser(SocialNetworkType.TWITTER, profileId.toString(),
                firstName + " " + lastName, email);
    }
}
