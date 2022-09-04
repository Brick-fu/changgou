package com.changgou.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class BaseController {

    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/goods/{page}")
    public String toGoodsPage(@PathVariable String page){
        return "goods/" + page;
    }

    @RequestMapping("/investment/{page}")
    public String toInvestmentPage(@PathVariable String page){
        return "investment/" + page;
    }

    @RequestMapping("/pay/{page}")
    public String toPayPage(@PathVariable String page){
        return "pay/" + page;
    }

    @RequestMapping("/seckill/{page}")
    public String toSeckillPage(@PathVariable String page){
        return "seckill/" + page;
    }

    @RequestMapping("/user/{page}")
    public String toUserPage(@PathVariable String page){
        return "user/" + page;
    }

}
