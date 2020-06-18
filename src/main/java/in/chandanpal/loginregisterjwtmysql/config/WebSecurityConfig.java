package in.chandanpal.loginregisterjwtmysql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// Disable CSRF (cross site request forgery) because not using cookies
		httpSecurity.csrf().disable();
		
		//disable session because using JWT authorization
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//access denied page
		//httpSecurity.exceptionHandling().accessDeniedPage("/login");
		
		// Entry points
		httpSecurity.authorizeRequests()
				.antMatchers("/register").permitAll()//permit api authentication to everyone
				.anyRequest().authenticated();// everything else to authenticated users
	}
	
}
