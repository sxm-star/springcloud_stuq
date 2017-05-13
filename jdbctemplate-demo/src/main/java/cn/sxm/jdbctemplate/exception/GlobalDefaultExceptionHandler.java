package cn.sxm.jdbctemplate.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
		@ExceptionHandler(value = Exception.class)
		@ResponseBody
		public Object defaultErrorHandler(HttpServletRequest req, Exception e)  {
			Map<String,Object> map = new HashMap<>();
			map.put("errorCode", "500001");
			map.put("errorMsg", "系统错误:"+ e.getMessage());
			return map;
	}
}
