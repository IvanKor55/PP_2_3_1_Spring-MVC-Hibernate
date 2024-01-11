package web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.hibernate.model.User;
import web.hibernate.service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/allusers")
    public String getListUsers(ModelMap model) {
        model.addAttribute("users",userService.getListUsers());
        return "listusers";
    }

    @GetMapping(value = "/user")
    public String getUser(Model model, @RequestParam(value = "id", required = false) Integer id) {
        model.addAttribute("user",userService.getUser(id));
        return "user";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/allusers";
    }
    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id", required = false) Integer id,
                           @ModelAttribute("user") User user) {
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/allusers";
    }
    @GetMapping("/delete")
    public String deleteUser(Model model, @RequestParam(value = "id", required = false) Integer id,
                           @ModelAttribute("user") User user) {
        model.addAttribute("user",userService.getUser(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/allusers";
    }
}
