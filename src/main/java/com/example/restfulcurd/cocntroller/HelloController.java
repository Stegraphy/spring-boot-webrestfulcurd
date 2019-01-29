package com.example.restfulcurd.cocntroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

/*    @RequestMapping({"/","login.html"})
    public String login(){
        return "login";
    }*/

    @RequestMapping("/success")
    public String hello() {
        return "success";
    }
}
