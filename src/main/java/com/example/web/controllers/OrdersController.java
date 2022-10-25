package com.example.web.controllers;

import com.example.web.entities.Book;
import com.example.web.entities.BookOrder;
import com.example.web.entities.Usr;
import com.example.web.repos.OrderRepo;
import com.example.web.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class OrdersController {

    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    public OrdersController(UserRepo userRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/cart")
    public String cart(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/signin";

        List<Book> cart = (List<Book>) session.getAttribute("cart");
        Integer price = 0;
        for ( Book book : cart) {
            price += book.getPrice();
        }
        model.put("session", session);
        model.put("price", price);

        return "profile/cart";
    }

    @PostMapping("/cart")
    public String makeOrder(Map<String, Object> model, HttpSession session) {
        String name = (String) session.getAttribute("name");
        Optional<Usr> user = userRepo.findByFirstname(name);

        if (user.isPresent()) {
            List<Book> cart = (ArrayList<Book>) session.getAttribute("cart");
            Usr usr = user.get();
            BookOrder order = new BookOrder(usr, cart, DateParser(LocalDateTime.now()));
            orderRepo.save(order);
            Set<BookOrder> set;
            if (usr.getOrders() == null) {
                set = new HashSet<BookOrder>();
            }
            else {
                set = usr.getOrders();
            }
            set.add(order);
            usr.setOrders(set);
            userRepo.save(usr);
            session.setAttribute("cart", new ArrayList<Book>());
        }

        model.put("session", session);

        return "profile/success";
    }

    @GetMapping("/orders")
    public String orders(Map<String, Object> model, HttpSession session) {
        if (session.getAttribute("role") == null)
            return "redirect:/signin";

        String name = (String) session.getAttribute("name");
        Usr usr = userRepo.findByFirstname(name).get();

        model.put("session", session);
        model.put("orders", usr.getOrders());

        return "profile/orders";
    }

    public String DateParser(LocalDateTime dateTime) {
        String date = dateTime.toString();

        return date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4) + "   " + date.substring(11,16);
    }
}