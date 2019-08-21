package com.example.springmvcboot.configure;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//	url /user/	----> user
//	// /admin	---> admin user

// @Autowired
// @Inject

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
		//auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("LIBRARIAN");
	}

	
	
	 @Bean(name = "passwordEncoder") public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder(); }
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests()
		.antMatchers("/registration").permitAll()
		.antMatchers("/subjectDetails/**","/subjectRegistration/**","/login","/home").hasAuthority("LIBRARIAN")
		.antMatchers("/bookDetails/**","/bookRegistration/**","/login","/home").hasAuthority("PRINCIPAL")
		.anyRequest().authenticated()
		.and()
		.formLogin().successForwardUrl("/home")
		.permitAll().and().logout().permitAll()
		;
		
	}
	
	

	}
