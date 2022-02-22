package com.upm.rh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
public class AppSecConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(autProvider());
	}

	@Bean
	public AuthenticationProvider autProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;

	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login", "/",
					"/js/**",
					"/css/**", 
					"/img/**",
					"/assets/**",
					"/vendor/**",
					"/scss/**").permitAll()
				//.antMatchers("/index").hasRole("ADMIN")
				.antMatchers("/index","/respo","/emp","/profile",
						     "/formations","/adminModifyrh","AdminModifyPr").hasAnyRole("ADMIN")
				.antMatchers("/rh","/rhgemp","/rhgpym","/rhgbull",
						"/rhgabs","/rhgcng","/rhgform","/rhprofile","/ajForm").hasAnyRole("RH")
				.antMatchers("/usr","/demandeconge","/usrVPaym","/usrgbull",
						"/usergabs","/usrdemandeform","/usrprofil").hasAnyRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").permitAll();
	}

}
