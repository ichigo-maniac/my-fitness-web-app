package com.my.fitness.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.social.vkontakte.connect.VKontakteConnectionFactory;

/**
 * OAuth2 configuration
 */
@Configuration
public class OAuthConfiguration {

    /**
     * Properties
     */
    @Value("${my.fitness.web.facebook.client.id}")
    private String facebookClientId;
    @Value("${my.fitness.web.facebook.secret}")
    private String facebookSecret;
    @Value("${my.fitness.web.vk.com.clientId}")
    private String vkClientId;
    @Value("${my.fitness.web.com.clientSecret}")
    private String vkSecret;
    @Value("${my.fitness.web.twitter.clientId}")
    private String twitterClientId;
    @Value("${my.fitness.web.twitter.clientSecret}")
    private String twitterSecret;

    /**
     * Connection factory registry bean
     * @return Connection factory registry
     */
    @Bean
    public ConnectionFactoryRegistry connectionFactoryRegistry() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        /** Facebook */
        registry.addConnectionFactory(new FacebookConnectionFactory(
                facebookClientId, facebookSecret
        ));
        /** VK.COM */
        registry.addConnectionFactory(new VKontakteConnectionFactory(
                vkClientId, vkSecret
        ));
        /** Twitter */
        registry.addConnectionFactory(new TwitterConnectionFactory(
                twitterClientId, twitterSecret
        ));
        return registry;
    }
}
