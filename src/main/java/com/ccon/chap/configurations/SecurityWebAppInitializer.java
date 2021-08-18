package com.ccon.chap.configurations;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebAppInitializer() {
        super(WebSecurityConfig.class);
    }
}
