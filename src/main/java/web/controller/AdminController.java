package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userService.readUserById(id));
//        return "show";
//    }

    @GetMapping("/admin/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/admin")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/index";
    }

    @GetMapping("admin/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.readUserById(id));
        return "edit";
    }

    @PatchMapping("/admin/{id}")                                   //check after
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/index";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/index";
    }

}
