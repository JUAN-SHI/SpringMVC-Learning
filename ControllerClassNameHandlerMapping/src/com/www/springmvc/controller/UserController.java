package com.www.springmvc.controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shijuan on 2017/12/29.
 */
public class UserController extends MultiActionController {

    //SpringMVC多动作控制器
//    public ModelAndView home(HttpServletRequest request, HttpServletResponse response)throws Exception{
//        ModelAndView model =new ModelAndView("home");
//        model.addObject("message","Home");
//        return model;
//    }
//
//
//    public ModelAndView add(HttpServletRequest request,HttpServletResponse response)throws Exception {
//        ModelAndView model=new ModelAndView("add");
//        model.addObject("message","add");
//        return model;
//    }
//
//    public ModelAndView remove(HttpServletRequest request,HttpServletResponse response)throws Exception{
//        ModelAndView model=new ModelAndView("remove");
//        model.addObject("message","remove");
//        return model;
//    }

    //springmvc 属性方法名称解析器
        public ModelAndView home(HttpServletRequest request, HttpServletResponse response)throws Exception{
        ModelAndView model =new ModelAndView("user");
        model.addObject("message","home(主页面方法)");
        return model;
    }


    public ModelAndView add(HttpServletRequest request,HttpServletResponse response)throws Exception {
        ModelAndView model=new ModelAndView("user");
        model.addObject("message","add(添加方法)");
        return model;
    }

    public ModelAndView remove(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ModelAndView model=new ModelAndView("user");
        model.addObject("message","remove(移除方法)");
        return model;
   }

}
