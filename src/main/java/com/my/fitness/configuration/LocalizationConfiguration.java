package com.my.fitness.configuration;

import com.my.fitness.localization.WildcardReloadableResourceBundleMessageSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * Localization configuration
 */
@Configuration
public class LocalizationConfiguration {

    /**
     * Reloadable message source bean
     * @return Message source
     */
    @Bean
    public MessageSource messageSource() {
        WildcardReloadableResourceBundleMessageSource messageSource = new WildcardReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
