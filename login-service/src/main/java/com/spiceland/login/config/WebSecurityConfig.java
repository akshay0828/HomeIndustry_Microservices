package com.spiceland.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.spiceland.login.service.UserDetailsServiceImpl;

//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserDetailsServiceImpl();
//	}
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//      http.cors().and().csrf().disable().
//         authorizeRequests()
//            .antMatchers("/api/public").permitAll()
//            .anyRequest().authenticated()
//            .and()
//         .addFilter(new JWTAuthenticationFilter(authenticationManager()))
////            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//   }
//
//   @Override
//   public void configure(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
//   }
//
//   @Bean
//   CorsConfigurationSource corsConfigurationSource() {
//      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//      return source;
//   }
//
//   @Bean
//   public BCryptPasswordEncoder bCryptPasswordEncoder() {
//      return new BCryptPasswordEncoder();
//   }
//}


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/**", "/signup").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable()
            .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//		http.authorizeRequests().antMatchers("/user/**").hasAnyAuthority("USER").antMatchers("/admin/**")
//				.hasAnyAuthority("ADMIN").antMatchers("/delivery/**").hasAnyAuthority("DELIVERY");
//				//.antMatchers("/register", "/login", "/logout", "/index", "/forgotpassword", "/changepassword/**")
//			//	.permitAll();
//
////		http.authorizeRequests().and().formLogin().loginProcessingUrl("/login").loginPage("/login")
////				.successForwardUrl("/login").failureForwardUrl("/login").usernameParameter("username")
////				.passwordParameter("pass").permitAll().and().logout().permitAll().and().exceptionHandling()
////				.accessDeniedPage("/403");
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**");
		web.ignoring().antMatchers("/images/**");
		web.ignoring().antMatchers("/js/**");
	}

}
