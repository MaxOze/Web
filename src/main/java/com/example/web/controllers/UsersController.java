package com.example.web.controllers;

import com.example.web.entities.Book;
import com.example.web.entities.Cart;
import com.example.web.entities.Usr;
import com.example.web.repos.CartRepo;
import com.example.web.repos.RoleRepo;
import com.example.web.repos.UserRepo;
import com.example.web.util.Input;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final CartRepo cartRepo;

    public UsersController(UserRepo userRepo, RoleRepo roleRepo, CartRepo cartRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.cartRepo = cartRepo;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signInForm(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") != null)
            return "redirect:/shop?page=1";

        model.put("session", session);

        return "user/signin";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String login,
                         @RequestParam String password,
                         HttpSession session, Map<String, Object> model) {
        Optional<Usr> result = userRepo.findByLogin(login);
        if (result.isPresent()) {
            Usr usr = result.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(password, usr.getPassword())) {
                session.setMaxInactiveInterval(900);
                session.setAttribute("name", usr.getFirstname());
                session.setAttribute("role", usr.getRoleName());

                Optional<Cart> cart = cartRepo.findByUserName(usr.getFirstname());
                if (cart.isPresent())
                    session.setAttribute("cart", new ArrayList<Book>(cart.get().getBooks_id()));
                else
                    session.setAttribute("cart", new ArrayList<Book>());

                return "redirect:/shop?page=1";
            }
        }

        model.put("session", session);

        return "redirect:/signin";
    }

    @GetMapping("/signup")
    public String signUpForm(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") != null)
            return "redirect:/shop?page=1";

        Usr usr = new Usr();
        usr.setFirstname("");
        usr.setEmail("");
        model.put("usr", usr);
        model.put("session", session);

        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String firstname,
                         @RequestParam String email,
                         @RequestParam String login,
                         @RequestParam String password,
                         Map<String, Object> model, HttpSession session) {
        Optional<Usr> result = userRepo.findByLogin(login);
        if (result.isPresent()) {
            Usr usr = new Usr();
            usr.setFirstname("");
            usr.setEmail("");
            model.put("usr", usr);
            model.put("session", session);
            return "user/signup";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Usr usr = new Usr(firstname, email, login, encoder.encode(password), roleRepo.findById(1).get());
        userRepo.save(usr);

        return "redirect:/signin";
    }

    @PostMapping("/signup/check")
    public ResponseEntity<Usr> getUser(@RequestBody Input loginInput) {
        Optional<Usr> usr = userRepo.findByLogin(loginInput.getInput());

        if(usr.isPresent())
            return new ResponseEntity<>(usr.get(), HttpStatus.OK);

        throw new RuntimeException("No user available for the given user name");
    }

    @GetMapping("/logoutuser")
    public String signOut(HttpSession session) {
        if (session.getAttribute("role") != null) {
            String name = (String) session.getAttribute("name");
            Optional<Cart> cart = cartRepo.findByUserName(name);

            if (cart.isPresent()) {
                Cart editCart = cart.get();
                editCart.setBooks_id((List<Book>) session.getAttribute("cart"));
                cartRepo.save(editCart);
            }
            else {
                Cart newCart = new Cart(name, (List<Book>) session.getAttribute("cart"));
                cartRepo.save(newCart);
            }

            session.invalidate();
        }

        return "redirect:/signin";
    }

    @GetMapping("/profile")
    public String profileForm(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/signin";

        String name = (String) session.getAttribute("name");
        Optional<Usr> user = userRepo.findByFirstname(name);

        model.put("session", session);
        model.put("usr", user.get());
        model.put("message", "");

        return "profile/profile";
    }

    @PostMapping("/profile")
    public String profile(@RequestParam String firstname,
                          @RequestParam String email,
                          Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/signin";

        String name = (String) session.getAttribute("name");
        Optional<Usr> user = userRepo.findByFirstname(name);
        Usr usr = user.get();
        usr.setFirstname(firstname);
        usr.setEmail(email);
        userRepo.save(usr);
        session.setAttribute("name", firstname);

        model.put("session", session);
        model.put("usr", usr);
        model.put("message", "Changes saved!");

        return "profile/profile";
    }
}
