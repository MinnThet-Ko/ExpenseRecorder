package com.er;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CompositeFilter;

import com.er.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserService userRepoService;
	
	//Create security filter chain
	@Bean
	public SecurityFilterChain createFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((auth) -> auth.requestMatchers("/user/register").permitAll().anyRequest().authenticated())
			.formLogin(form -> form.loginPage("/user/login").permitAll());
		return http.build();
		
	}

    @Bean
    PasswordEncoder generatePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(this.userRepoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
    } 
	

}
