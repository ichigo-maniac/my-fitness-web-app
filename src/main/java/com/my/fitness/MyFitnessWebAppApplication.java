package com.my.fitness;

import com.my.fitness.configuration.LocalizationConfiguration;
import com.my.fitness.configuration.OAuthConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * My fitness web application
 */
@SpringBootApplication(exclude = {SocialWebAutoConfiguration.class})
public class MyFitnessWebAppApplication extends SpringBootServletInitializer {

	/**
	 * Configure application
	 * @param application Application
	 * @return Application builder
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyFitnessWebAppApplication.class);
	}

	/**
	 * Main function
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyFitnessWebAppApplication.class, args);
	}
}
