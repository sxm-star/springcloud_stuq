package cn.springboot.stuq.devtools;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * The type Demo controller.
 */
@RestController
@Slf4j
@Api(value = "DEMO API",description = "demo")
public class DemoController {

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
    
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(String test){
        return "hello test" + test;
    }

    @RequestMapping(value = "/date",method = RequestMethod.GET)
    @ApiOperation("date show")
    public Date date(){
        return new Date();
    }

}
