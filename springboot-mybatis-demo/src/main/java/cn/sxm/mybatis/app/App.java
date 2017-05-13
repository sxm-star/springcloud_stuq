package cn.sxm.mybatis.app;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * 在这里指定是个springboot程序
 * @author: sxm
 * @date: 16/4/18 23:55
 * @version: v1.0.0
 */
@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@MapperScan("cn.sxm.**.mapper")//这里和以往不一样的地方就是MapperScan的注解，这个是会扫描该包下的接口
@EnableCaching
public class App extends WebMvcConfigurerAdapter{


    /**
     * 复写该方法使得支持 fastjson
     * 1.需要先定义一个convert转换器对象;
     * 2.添加fastjson的配置信息,比如是否要格式化返回的json数据;
     * 3.在convert中添加fastjson配置信息
     * 4.将convert添加到 converters中
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(new String[]{"swagger-ui.html"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/"});
//        registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"});
//    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sxm.thymeleaf.app"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot结合Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关例子请关注：https://github.com/SongXuanMing/springcloud_stuq")
                .termsOfServiceUrl("https://github.com/SongXuanMing/springcloud_stuq")
                .contact("xuanming song")
                .version("V1.0")
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
