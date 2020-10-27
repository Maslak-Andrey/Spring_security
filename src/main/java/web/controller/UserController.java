package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	private UserServiceImpl userService;

	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

	@GetMapping("user")
	public String userPage() {
		return "user";
	}

}