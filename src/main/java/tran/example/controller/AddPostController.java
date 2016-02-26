package tran.example.controller;

import java.security.Principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tran.example.model.DAO.BlogDAO;

@Controller
public class AddPostController {

	@RequestMapping(value="/addPost", method=RequestMethod.GET)
	public String displayAddForm(Principal principal, ModelMap model) {
		if(principal != null) {
			String userName = principal.getName();
			if(userName != null) {
				model.addAttribute("loggedInName", userName);
				return "addPost";
			}
			else {
				model.addAttribute("error", "You must be logged in before viewing this page.");
		    	return "signin";
			}
		}
		else {
			model.addAttribute("error", "You must be logged in before viewing this page.");
	    	return "signin";
		}
	}
	
	@RequestMapping(value = "/processAddPost", method = RequestMethod.POST)
	public String processAddForm(@RequestParam(value = "title", required = false) String title, 
			@RequestParam(value = "content", required = false) String content, Principal principal, ModelMap model) {
		if(principal != null) {
			String userName = principal.getName();
			if(userName != null) {
				ApplicationContext appContext =  new ClassPathXmlApplicationContext("spring/database/Datasource.xml");
				BlogDAO getPosts = (BlogDAO)appContext.getBean("BlogDS");
				int createPostMessage = getPosts.addBlog(title, content, userName);
				((ConfigurableApplicationContext)appContext).close();
				return "redirect:showSinglePost?blogID=" + createPostMessage;
			}
			else {
				model.addAttribute("error", "You must be logged in before creating a post.");
		    	return "signin";
			}
		}
		else {
			model.addAttribute("error", "You must be logged in before creating a post.");
	    	return "signin";
		}
	}
}
