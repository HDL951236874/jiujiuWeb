package com.jiujiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "1234".equals(password)) {
            System.out.println("here is ok");
            session.setAttribute("loginUser", username);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "the username or the password is incorrect!");
            return "index";
        }

    }
}
