package com.www.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shijuan on 2017/12/28.
 */
@Controller
public class HelloController extends AbstractController{


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
       ModelAndView model=new ModelAndView("helloWorld");
       model.addObject("message","helloController");
        return  model;

    }
}
