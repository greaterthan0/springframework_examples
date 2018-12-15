package user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
	@RequestMapping("/homepage")
	public @ResponseBody String welcomeUser() {
			return "Welcome to Spring Security Demo";
			
	}
	@RequestMapping("/admin")
	public @ResponseBody String asdfd() {
		return "Welcome to aaaaaaaaaaaaaaaaaaaaaa Demo";
		
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getlogin() {
		return "login.jsp";
	}

}
