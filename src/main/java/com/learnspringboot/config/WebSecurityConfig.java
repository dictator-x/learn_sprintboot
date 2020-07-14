package com.learnspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll();
//        http.authorizeRequests()
//                .antMatchers("/").hasRole("VIP1");
        // use /login
        //http.formLogin().loginPage("yourpage");
        http.formLogin();
        // use /logout
        http.logout().logoutSuccessUrl("/");
        // rememeber me.
        http.rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().withUser("admin").password("{noop}adminAb1").roles("VIP1")
                .and().withUser("client").password("{noop}adminAb1").roles("VIP1", "VIP2")
                .and().withUser("client2").password("{noop}adminAb1").roles("VIP2");
    }
}
