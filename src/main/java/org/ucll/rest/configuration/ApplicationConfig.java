package org.ucll.rest.configuration;

import domain.facade.VideoBeheer;
import domain.factory.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by filip on 5/16/2016.
 */
/*
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.ucll.rest")
public class ApplicationConfig {

    @Bean
    public VideoBeheer service(){
        return new VideoBeheer(DatabaseType.RELATIONAL);
    }

}
*/