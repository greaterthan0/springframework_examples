package demo.spring_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	@RequestMapping("/")
	public @ResponseBody String welcome() {
		return "Welcome to Spring MVC example.";
	}
	
	@RequestMapping("/hi")
	public @ResponseBody String hi() {
		return "Hi Message";
	}
}