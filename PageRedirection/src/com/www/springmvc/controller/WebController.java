package com.www.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shijuan on 2017/12/11.
 */
@Controller
public class WebController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public  String  redirect(){
        return  "redirect:finalPage";

    }

    @RequestMapping(value = "/finalPage",method = RequestMethod.GET)
    public String  finalPage(){
        return "final";
    }

}
