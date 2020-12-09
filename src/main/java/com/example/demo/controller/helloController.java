package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.ognl.JavaSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.pool.PreparedStatementPool.MethodType;
import com.alibaba.druid.stat.TableStat.Mode;
import com.example.demo.Service.StudentInfoService;
import com.example.demo.enity.CouSelect;
import com.example.demo.enity.UserRole;
import com.example.demo.enity.StudentInfo;

@Controller
@SessionAttributes(value = {"msg"})
public class helloController {

	@Autowired
	StudentInfoService studentInfoService;
	
	/**
	 * 
	 * 返回自定义登录页
	 * @return
	 */
	@GetMapping("/login")
    public String login() {
		
        return "login";
    }
    /**
     * 返回注册页面
     * @return
     */
	@GetMapping("/GoToRegister")
    public String GoToRegister() {
		
        return "register";
    }
	/**
	 * 用户注册
	 * @param seudentinfo
	 * @return
	 */
	@RequestMapping(value="/register" ,method = RequestMethod.POST)
	@ResponseBody
    public Integer register(@RequestBody StudentInfo seudentinfo )  {
	
		//判断用户是否存在
		if(studentInfoService.selectByPrimaryKey(seudentinfo.getUserid())!=null)
		{
			return 200;
		}else {
			
			
			UserRole userRole =new UserRole();
			userRole.setRid(1);
			userRole.setUid(seudentinfo.getUserid());
			studentInfoService.insert(seudentinfo);
			studentInfoService.insertUserRole(userRole);
			return 100;
		}
			

    }
	
/**
 * 首页
 * @param model
 * @return
 */
	@RequestMapping(value = "/user/info")
	public String getUser(){
	   return "stuInfo";
	}
	/**
	 * 选课页，显示剩余未选的课程
	 * @return
	 */
	@RequestMapping("/user/select")
	public String  select(Model model) {
		StudentInfo principal =(StudentInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		int userid=principal.getUserid();
		model.addAttribute("course", studentInfoService.selectAllRestUserCourseByUid(userid));
		return "select";
		
	}
	/**
	 * 选课
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/success")
	@ResponseBody
	public String  Success(@RequestParam Integer[] checkID) {
		StudentInfo principal =(StudentInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		int userid=principal.getUserid();
		for(Integer cid:checkID)
		{
			
			studentInfoService.insertUserCourse(userid, cid);
		}
		return "选课成功";
		
	}
	/**
	 * 选课成功页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/selectinfo")
	public String  Success(Model model) {
		StudentInfo principal =(StudentInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
		int userid=principal.getUserid();
		model.addAttribute("course", studentInfoService.selectSelectedCourse(userid));
		return "success";
		
	}
	
}
