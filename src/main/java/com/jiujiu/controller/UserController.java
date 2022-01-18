package com.jiujiu.controller;

import com.jiujiu.dao.UserMapper;
import com.jiujiu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/users")
    public String showUserList(Model model){
        Collection<User> userList = userMapper.queryUserList();
        model.addAttribute("users",userList);
        return "user/list";
    }

    @GetMapping("/user")
    public String toAddPage(){
        return "user/add";
    }

    @PostMapping("/user")
    public String addUser(User user){
        System.out.println(user);
        userMapper.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/deluser/{id}")
    public String deleteUser(@PathVariable("id")Integer id){
        userMapper.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        User user= userMapper.queryUserById(id);
        model.addAttribute("user",user);
        return "user/update";
    }

    @PostMapping("/updateUser")
    public String updateEmp(User user){
        System.out.println(user);
        userMapper.updateUser(user);
        return "redirect:/users";
    }
}
