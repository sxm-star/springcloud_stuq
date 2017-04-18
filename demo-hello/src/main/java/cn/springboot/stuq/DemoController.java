package cn.springboot.stuq;

import cn.springboot.stuq.dto.DemoDTO;
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

    @RequestMapping(value = "/date",method = RequestMethod.GET)
    @ApiOperation("date show")
    public Date date(){
        return new Date();
    }

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    @ApiOperation("test")
    public DemoDTO demo(@ModelAttribute DemoDTO demoDTO){
        log.info("input param :{}",demoDTO);
        if(demoDTO!=null && demoDTO.getName()!=null) return demoDTO;
        demoDTO = new DemoDTO();
        demoDTO.setAge(18);
        demoDTO.setName("xuanming song");
        demoDTO.setCreateTime(new Date());
        return demoDTO;
    }
}
