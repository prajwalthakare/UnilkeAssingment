package com.java.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.java.entity.Corporate1;

import com.java.entity.User;
import com.java.ser.service;

@ComponentScan("com.java")
@Controller
@EnableWebMvc

public class controller {
	@Autowired
	 service mvcser;
 // User login......
	@RequestMapping("/loginpage")
	public String openloginpage() {
		
		return "login";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView checkloging(@ModelAttribute User user){
		ModelAndView mv=new ModelAndView();
		
		boolean result=mvcser.checklogin(user);
	
		
		if(result){
			System.out.println(user.getUsername());
			
			mv.setViewName("redirect:/home");
		}
		else{
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping("/home")
	public  ModelAndView openhomepage(){
	
		ModelAndView mv=new ModelAndView();
		List<Corporate1> listcor=mvcser.getcor();
		if(!listcor.isEmpty()){
			mv.addObject("list",listcor);
			mv.setViewName("home");
		}
		else{
			
			mv.addObject("list",listcor);
			mv.setViewName("login");
		}
	
		return mv;
		
	}
	
	@RequestMapping("/addcor")
	public String openAdduser()
	{
		return "addcor";
	}
	
	
	@RequestMapping("/addpage")
	public ModelAndView addcor(@ModelAttribute Corporate1 cor)
	{
		ModelAndView mv=new ModelAndView();
		if(mvcser.addcor(cor))
		{
			 List<Corporate1> listcor=mvcser.getcor();
			 mv.addObject("list", listcor);
			 mv.setViewName("redirect:/home");
		}
		else
		{
			mv.addObject("msg", "something Went Wrong!");
		}
		return mv;
	}
	
	@RequestMapping("/deletecorp")
	public ModelAndView delete(@RequestParam("SrNo") String SrNo){
		
		ModelAndView mv=new ModelAndView();
		int stid=Integer.parseInt(SrNo);
	
		
		if(mvcser.deletecor(stid)){
	
			List<Corporate1> listcor=mvcser.getcor();
			mv.addObject("list",listcor);
			mv.setViewName("home");
			
		
		}
		else{
			mv.addObject("msg", "something wnt wrong");
		}
		
		
		return mv;
		
		
	}
	
	
	///projects list ____gridcamp
		@RequestMapping("/update")
		public ModelAndView getprj(@RequestParam("SrNo") String SrNo)
		{
			System.out.println("up1");
			ModelAndView mv=new ModelAndView();
			int idprj=Integer.parseInt(SrNo);
			
			List<Corporate1>lists=mvcser.getproj(idprj);
			System.out.println("j2");
		if(!lists.isEmpty())
			{
			System.out.println("up2");
				mv.addObject("list", lists);
				
				mv.setViewName("update");
				
			}
			else
			{
				mv.addObject("msg", "Something went wrong!");
				mv.setViewName("home");
			}
			return mv;
		}
		
		//update project gridcamp
		@RequestMapping("/updateparticularpro")
		public ModelAndView update(@ModelAttribute Corporate1 proj)
		{
			ModelAndView mv=new ModelAndView();
		
			if(mvcser.updateproj(proj))
			{
				
				 List<Corporate1> listprj=mvcser.getcor();
				
				 mv.addObject("list", listprj);
				 mv.setViewName("home");
			}
			else
			{
				mv.addObject("msg", "something Went Wrong!");
			}
			return mv;
		}


}
