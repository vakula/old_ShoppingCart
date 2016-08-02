package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
@RequestMapping("/")
public ModelAndView display(){
	ModelAndView m1=new ModelAndView("Home");
	return m1;
}
@RequestMapping("/login")
public ModelAndView display1(){
	ModelAndView m1=new ModelAndView("login");
	return m1;
}
@RequestMapping("/register")
public ModelAndView display2(){
	ModelAndView m1=new ModelAndView("register");
	return m1;
}
}

