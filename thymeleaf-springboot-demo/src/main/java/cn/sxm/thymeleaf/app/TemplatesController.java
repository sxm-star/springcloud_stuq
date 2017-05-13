package cn.sxm.thymeleaf.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 注意： 1.在Thymeleaf 模板文件中，标签是需要闭合的，3.0之前是需要闭合的 2. thymeleaf 3.0+ 是可以不强制要求闭合的。
 * 
 * 3. 支持同时使用多个模板引擎，比如：thymeleaf和freemarker 可以并存。
 * 
 * 
 */
@Controller
@RequestMapping("/templates")
@Slf4j
public class TemplatesController {

	/**
	 * 映射地址是：/templates/hello
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello(Map<String, Object> map) {
		// 返回的是ModelAndView对象;
		ModelAndView mv = new ModelAndView("hello");
		map.put("name", "sxm");
		mv.addObject(map);
		return mv;

	}

	@RequestMapping(value = "/helloFtl", method = RequestMethod.GET)
	public ModelAndView helloFtl(Map<String, Object> map) {
		ModelAndView mv = new ModelAndView("helloFtl");
		map.put("name", "sxm");
		return mv;
	}

}
