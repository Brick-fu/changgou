package com.changgou.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/login")
@Controller
public class LoginController {

    @RequestMapping
    public String login(){
        return "login";
    }
}
