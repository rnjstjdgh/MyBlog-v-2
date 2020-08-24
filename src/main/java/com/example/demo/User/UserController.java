package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 로그인 페이지
    @RequestMapping(value = "/User/Login")
    public String dispLogin(HttpServletRequest request ,Model model) {
        String error = request.getParameter("error");
        if(error != null) {//로그인 실패 상황
            model.addAttribute("loginFailureError", "잘못된 회원정보 입니다");
        }
        return "/Users/Login";
    }

    // 접근 거부 페이지
    @GetMapping("/User/Denied")
    public String dispDenied() {
        return "/Denied";
    }


}
