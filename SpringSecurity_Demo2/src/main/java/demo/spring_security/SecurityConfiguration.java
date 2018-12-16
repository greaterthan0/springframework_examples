package demo.spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	        http
	        	.authorizeRequests()
	            .antMatchers("/resources/**", "/login").permitAll()
	            .anyRequest().authenticated()
	            .and().formLogin().loginPage("/login");
	}
}