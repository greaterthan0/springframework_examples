package user;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping("/")
	public String welcomeUser() {
		return "home.jsp";
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registrationOpen() {
		return "Registration.jsp";
	}
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody String registrationProcess(Contact contact ) {
		
		System.out.println(contact);
		sessionFactory.getCurrentSession().save(contact);
		
		return "You have registered successfuly.";
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
