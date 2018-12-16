package demo.spring_security;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	@PostConstruct
	public void printEncodedCredentials() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Encoded Password: "+encoder.encode("password"));
	}
	
	@RequestMapping("/")
	public @ResponseBody String welcome() {
		return "Welcome to Spring MVC example.";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}