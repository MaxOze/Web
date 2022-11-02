package com.example.web;

import com.example.web.entities.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void authorization() throws Exception {
        this.mockMvc.perform(post("/signin")
                        .param("login", "adminMax")
                        .param("password", "adminMax"))
                        .andExpect(redirectedUrl("/shop?page=1"));
    }

    @Test
    void authorizationWrong() throws Exception {
        this.mockMvc.perform(post("/signin")
                        .param("login", "admin")
                        .param("password", "admin"))
                        .andExpect(redirectedUrl("/signin"));
    }

    @Test
    void unauthorizedAdd() throws Exception {
        Assertions.assertThatThrownBy(
                        () -> this.mockMvc.perform(post("/create")
                        .param("name", "testName")
                        .param("author", "testAuthor")
                        .param("price", "100")))
                                    .hasCauseInstanceOf(RuntimeException.class);
    }

    @Test
    void toCart() throws Exception {
        HttpSession session = new MockHttpSession();
        session.setAttribute("name", "admin");
        session.setAttribute("role", "superuser");
        session.setAttribute("cart", new ArrayList<Book>());

        this.mockMvc.perform(post("/shop")
                        .param("name", "Оно")
                        .param("page", "1")
                        .session((MockHttpSession) session))
                        .andExpect(redirectedUrl("/shop?page=1"));
    }
}
