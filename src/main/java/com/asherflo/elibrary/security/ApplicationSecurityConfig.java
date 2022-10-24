package com.asherflo.elibrary.security;

import com.asherflo.elibrary.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity

public class ApplicationSecurityConfig {

    private  final UnAuthorizedEntryPoint unAuthorizedEntryPoint;
    private SessionCreationPolicy sessionCreationPolicy;

    public ApplicationSecurityConfig(UnAuthorizedEntryPoint unAuthorizedEntryPoint) {
        this.unAuthorizedEntryPoint = unAuthorizedEntryPoint;
    }


    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeHttpRequests(authorize -> {
                    try{
                        authorize.antMatchers("/**/auth/**").permitAll()
                                .antMatchers("/customeError").permitAll()
                                .antMatchers("/access-denied").permitAll()

                                .anyRequest().authenticated()
                                .and()
                                .exceptionHandling().authenticationEntryPoint(unAuthorizedEntryPoint)
                                .accessDeniedHandler(accessDeniedException())
                                .and()
                                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
//        http.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
//        http.addFilterAfter(exceptionHandlerFilterBean(),UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }



    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilterBean() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public AccessDeniedHandler accessDeniedException() {
        return new CustomAccessDeniedHandler();
    }
    @Bean
    public ExceptionHandlerFilter exceptionHandlerFilterBean(){
        return  new ExceptionHandlerFilter();
    }


}
