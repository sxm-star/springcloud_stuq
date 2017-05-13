package cn.jsp.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String,Object> map){
		System.out.println("HelloController.helloJsp().hello=hello");
		map.put("hello", "sxm");
		return "hello";
	}
	
	@RequestMapping("/jsp")
	public ModelAndView hello_Jsp(Map<String,Object> map){
		ModelAndView mv = new ModelAndView("hello");
		map.put("hello", "sxm is here.");
		mv.addObject(map);
		return mv;
	}
}

