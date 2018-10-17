package com.basic.learn08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class IndexController {
    @RequestMapping(value = "/login_v",method = RequestMethod.GET)
    public String login_v(){
        return "login";
    }

    @RequestMapping(value = "/index_v",method = RequestMethod.GET)
    public String index_v(){
        return "index";
    }
}
