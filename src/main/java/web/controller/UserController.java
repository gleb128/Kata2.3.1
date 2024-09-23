package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {

    private final UserService   userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String ShowUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("Users", users);
        return "ShowUsers";
    }

    @GetMapping("/{id}")
    public String ShowOne(@PathVariable int id, Model model) {
        model.addAttribute("User", userService.findUser((byte) id));
        return "ShowOne";
    }


}
