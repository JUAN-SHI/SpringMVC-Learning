package com.www.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shijuan on 2018/1/11.
 */
@Controller
@RequestMapping("/generateJson")
public class UserController {
    @RequestMapping(value="{name}",method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable String name){
        User user=new User();
        user.setId(1);
        user.setName(name);
        return user ;
    }
}
