package com.profile;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringDocConfig {
    @Bean
    GroupedOpenApi api() {
        return GroupedOpenApi.builder().group("*").pathsToMatch("/*/**").build();
    }
}
