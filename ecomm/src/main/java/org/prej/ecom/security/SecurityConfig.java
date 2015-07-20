/*package org.prej.ecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebMvcSecurity
@EnableScheduling
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	CustomAuthenticationEntryPoint customEntryPoint;
	
	@Autowired
	public void setCustomEntryPoint(CustomAuthenticationEntryPoint customEntryPoint) {
		this.customEntryPoint = customEntryPoint;
	}
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER");
	    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.
	            csrf().disable().
	            sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
	            and().
	            authorizeRequests().
	           // antMatchers(actuatorEndpoints()).hasRole(backendAdminRole).
	            anyRequest().authenticated().
	            and().
	            anonymous().disable().
	            exceptionHandling().authenticationEntryPoint(customEntryPoint);

	    http.addFilterBefore(new AuthenticationTokenProcessingFilter(authenticationManager()), BasicAuthenticationFilter.class).
	            addFilterBefore(new ManagementEndpointAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class);
	}


}
*/