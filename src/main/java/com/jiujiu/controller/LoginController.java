package com.jiujiu.controller;

import com.jiujiu.dao.UserMapper;
import com.jiujiu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        List<User> userList = userMapper.queryUserList();
        for(User user:userList){
            System.out.println(user.getName());
            System.out.println(user.getPwd());
            System.out.println(username);
            System.out.println(password);
            if (user.getPwd().equals(password)&&user.getName().equals(username)){
                session.setAttribute("loginUser",username);
                return "redirect:/index.html";
            }
        }
        model.addAttribute("msg","用户名和密码错误！");
        return "welcome";
        //        if (!StringUtils.isEmpty(username) && "1234".equals(password)) {
//            session.setAttribute("loginUser", username);
//            return "redirect:/index.html";
//        } else {
//            model.addAttribute("msg", "用户名或密码错误！");
//            return "welcome";
//        }

    }
}
