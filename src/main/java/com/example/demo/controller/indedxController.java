package com.example.demo.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Service.courseService;
import com.example.demo.Service.selectService;
import com.example.demo.Service.stuService;
import com.example.demo.enity.course;
import com.example.demo.enity.couSelect;
import com.example.demo.enity.student;


@Controller
@SessionAttributes(value = "msg")
public class indedxController {

	@Autowired
	stuService stuService;
	@Autowired
	courseService couService;
	@Autowired
	selectService selectService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	//查询个人信息
	@RequestMapping("/stuinfo")
	public ModelAndView  register() {
		ModelAndView mv=new ModelAndView();
		mv.addObject( "stuinfo",stuService.findByXuehao(1725121014));
		mv.setViewName("stuInfo");
		System.out.println(stuService.findByXuehao(1725121014));
		return mv;
		
	}
	//点击选课时查询课程表，并返回数据会前台渲染视图
	@RequestMapping("/select")
	public ModelAndView  select() {
		ModelAndView mv=new ModelAndView();
		List<course> cou=couService.findAll();
		mv.addObject("course", cou);
		mv.setViewName("select");
		System.out.println(couService.findAll());
		return mv;
		
		
	}
	@RequestMapping("/success")
    @ResponseBody
	public String success(@RequestParam Integer[] checkID) {//获取前台数数组
		
		for(Integer str:checkID)
		{
			
			couSelect select=new couSelect();
			select.setCid(str);
			select.setSid(1725121014);
			selectService.saveSelect(select);
			
		}
		
		
		return "选课成功";
	}
	
	//选课成功后手动跳转
	@RequestMapping("/success1")
	public ModelAndView success1() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("student", stuService.findByXuehao(1725121014));
		List<couSelect> selects=selectService.findBySid(1725121014);
		List<course> courses=new ArrayList<>();
		List<Integer> cidsIntegers=new ArrayList<>();
		for(couSelect cc:selects)
		{
			System.out.println(cc);
			cidsIntegers.add(cc.getCid());
		}
		
		for(Integer cid:cidsIntegers)
		{
			courses.add(couService.findByCid(cid));
		}
		mv.addObject("cou", courses);
		mv.setViewName("success");
		return mv;
		
	}
	
	
}
