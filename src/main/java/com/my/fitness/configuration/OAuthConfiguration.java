package com.my.fitness.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

/**
 * OAuth2 configuration
 */
@Configuration
public class OAuthConfiguration {

    /**
     * Properties
     */
    @Value("${my.fitness.web.facebook.client.id}")
    private String faceBookClientId;
    @Value("${my.fitness.web.facebook.secret}")
    private String faceBookSecret;

    /**
     * Connection factory registry bean
     * @return Connection factory registry
     */
    @Bean
    public ConnectionFactoryRegistry connectionFactoryRegistry() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        /** Facebook */
        registry.addConnectionFactory(new FacebookConnectionFactory(
                faceBookClientId, faceBookSecret
        ));
        return registry;
    }
}
