package com.ocr.clientui.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/**/*.js", "/**/*.css", "/img/**", "/**/*.scss" ).permitAll()
                .antMatchers( "/" ).permitAll()
                .antMatchers( "/login" ).permitAll()
                .antMatchers( "/books" ).permitAll()
                .antMatchers( "/customer/**" ).permitAll()
                .antMatchers( "/book/search-result" ).permitAll()
                .anyRequest().authenticated().and().csrf().disable().formLogin()
                .loginPage( "/login" ).failureUrl( "/login?error=true" )
                .defaultSuccessUrl( "/" ).usernameParameter( "email" )
                .passwordParameter( "password" ).and()
                .headers().frameOptions().disable().and().logout()
                .logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
                .logoutSuccessUrl( "/home" ).and().exceptionHandling()
                .accessDeniedPage( "/403" );
    }


    @Override
    public void configure( WebSecurity web ) throws Exception {
        web
                .ignoring()
                .antMatchers( "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**" );
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


}