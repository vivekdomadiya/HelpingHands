package com.helpingHands.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class websecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http   
		.authorizeRequests()
		.antMatchers("/donor/*").hasRole("DONOR")
		.antMatchers("/receiver/*").hasRole("RECEIVER")
		.antMatchers("/admin/*").hasRole("ADMIN")
		.antMatchers("/change-password","/edit-profile").authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.usernameParameter("username")
        .passwordParameter("password")
        .successHandler(successHandler())
        .failureHandler(failureHandler())
        .and()
        
        .logout()
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        
        .and()
        .rememberMe().key("uniqueAndSecret")
        
        .and().csrf().disable();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected AuthenticationSuccessHandler successHandler() {
		return new CustomAuthenticationSuccessHandler();
	}

	@Bean
	protected AuthenticationFailureHandler failureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	 	 
}

