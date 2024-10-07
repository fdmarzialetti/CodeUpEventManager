package com.mindhub.event_manager.configurations;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@EnableWebSecurity
@Configuration
public class FilterSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests( path -> {
                    path.requestMatchers("/index.html", "/v3/api-docs/**", "/swagger-ui/**","/h2-console/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/events").hasAnyAuthority("ADMIN", "MANAGER")
                            .requestMatchers(HttpMethod.POST,"/api/organizers").hasAuthority("ADMIN")
                            .requestMatchers("/api/events").permitAll()
                            .anyRequest().denyAll();
                } )
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
                        frameOptionsConfig -> frameOptionsConfig.disable()))
                .formLogin( formLogin -> {
                    formLogin.loginPage("/index.html")
                            .loginProcessingUrl("/api/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .permitAll()
                            .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
                            .failureHandler((request, response, exception) -> response.sendError(401, "Invalid user or password"));
                })
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/api/logout")
                                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                                .deleteCookies("JSESSIONID"))
                .rememberMe(Customizer.withDefaults());
        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }
}
