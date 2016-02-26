package tran.example.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tran.example.model.User;
import tran.example.model.DAO.UserDAO;

@Controller
public class RegisterFormController {

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String displayRegistration(ModelMap model) {
    	return "register";
	}
	
	@RequestMapping(value="/processRegistration", method=RequestMethod.POST)
	public String processRegistration(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "validatePassword", required = false) String validatePassword, ModelMap model) {
		if(userName != null && password != null && validatePassword != null) {
			User newUser = new User(userName, password, validatePassword);
			if(newUser.validate()) {
				// attempt to create the user.
				newUser.setUserRole("ROLE_USER");
				newUser.setEnabled(true);
				ApplicationContext appContext =  new ClassPathXmlApplicationContext("spring/database/Datasource.xml");
				UserDAO createUser = (UserDAO)appContext.getBean("userDS");
				String createUserReturnCode = createUser.create(userName, newUser.encryptUserPassword(), newUser.getEnabled(), newUser.getUserRole());
				((ConfigurableApplicationContext)appContext).close();
				model.addAttribute("error", createUserReturnCode);
				return "register";
			}
			else { // failed validation, notify the user of the error
				String errorDescription = newUser.getMessage();
				if(!errorDescription.equals(""))
					model.addAttribute("error", errorDescription);
				return "register";
			}
		}
		else {
			// specific error where the fields could not be processed..
			model.addAttribute("error", "An error has occured, please try again");
			return "register";
		}
	}
	
}
