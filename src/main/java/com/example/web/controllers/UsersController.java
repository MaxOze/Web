package com.example.web.controllers;

import com.example.web.entities.User;
import com.example.web.repos.RoleRepo;
import com.example.web.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public UsersController(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @GetMapping("/signin")
    public String signInForm(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/shop?page=1";

        model.put("session", session);

        return "user/signin";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String login,
                         @RequestParam String password,
                         HttpSession session, Map<String, Object> model) {
        Optional<User> result = userRepo.findByLogin(login);
        if (result.isPresent()) {
            User user = result.get();
            if (user.getPassword().equals(password)) {
                  session.setMaxInactiveInterval(900);
                  session.setAttribute("name", user.getFirstname());
                  session.setAttribute("role", user.getRoleName());

                return "redirect:/shop?page=1";
            }
        }

        model.put("session", session);

        return "user/signin";
    }

    @GetMapping("/signup")
    public String signUpForm(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/shop?page=1";

        User user = new User();
        user.setFirstname("");
        user.setEmail("");
        model.put("user", user);
        model.put("session", session);

        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String firstname,
                         @RequestParam String email,
                         @RequestParam String login,
                         @RequestParam String password,
                         Map<String, Object> model, HttpSession session) {
        Optional<User> result = userRepo.findByLogin(login);
        if (result.isPresent()) {
            model.put("session", session);
            return "user/signup";
        }

        User user = new User(firstname, email, login, password, roleRepo.findById(1).get());
        userRepo.save(user);

        return "redirect:/signin";
    }

    @GetMapping("/logout")
    public String signOut(HttpSession session) {
        if (session.getAttribute("role") != null)
            session.invalidate();

        return "redirect:/signin";
    }
}
