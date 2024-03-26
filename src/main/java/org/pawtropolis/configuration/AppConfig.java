package org.pawtropolis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
@ComponentScan(basePackages = {"org.pawtropolis.animal.entity", "org.pawtropolis.game.entity"})
public class AppConfig {

    @Bean
    public String defaultString() {
        return "";
    }

    @Bean
    public int defaultInt() {
        return 0;
    }

    @Bean
    public LocalDate defaultLocalDate() {
        return LocalDate.now();
    }
    @Bean
    public float defaultFloat() {
        return 0;
    }





}
