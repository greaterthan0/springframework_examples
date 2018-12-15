package demo1.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	@RequestMapping("/home")
	public @ResponseBody String welcome() {
		return "Welcome to Spring MVC. This is example without using xml based configurations";
	}
}