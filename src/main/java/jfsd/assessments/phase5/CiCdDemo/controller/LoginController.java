package jfsd.assessments.phase5.CiCdDemo.controller;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jfsd.assessments.phase5.CiCdDemo.entity.User;

@Controller
public class LoginController {

	@GetMapping("/signin")
	public String signInUser(@RequestParam(required = false) String error,
			Map<String, String> map) {
		if (error != null && !error.equals(""))
			map.put("error", error);
		return "login";
	}

	@GetMapping("/congrats")
	public String sucessSignIn() {
		return "congrats";
	}

	@PostMapping("/login")
	public String loginUser(User user, Map<String, String> map, HttpSession session) {
		User dbUser = new User("rui.g", "Rui", "G", "rui@mail.com", "root");
		
		if(user.getUsername().equals(dbUser.getUsername())) {
			if (user.validateUser(dbUser)) {
				dbUser.setLast_login(new Date());
				if(session != null)
					session.setAttribute("user", dbUser);
				
				return "redirect:congrats";
			}
		}

		if(map != null)
			map.put("error", "Invalid Credentials");
		
		return "redirect:signin";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:signin";
	}

}
