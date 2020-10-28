package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

	@GetMapping("user")
	public String userLoginPage() {
		return "user";
	}

	@GetMapping("show")
	public String userPage(Model model, Principal principal) {
		User currentUser = userService.getUserByUserName(principal.getName());
		model.addAttribute("user", currentUser);
        return "show";
	}
}