测试Devtool方法

修改类--》保存,应用会热重启
修改配置文件--》保存,应用会热重启
修改页面--》保存,应用会重启,页面会刷新(原理是将spring.thymeleaf.cache设为false)

spring-boot-devtools 是一个为开发者服务的一个模块，其中最重要的功能就是自动应用代码更改到最新的App上面去。原理是在发现代码有更改之后，重新启动应用，但是速度比手动停止后再启动还要更快，更快指的不是节省出来的手工操作的时间。
其深层原理是使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为  restart ClassLoader
,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间（5秒以内）

使用介绍
1.添加依赖包： 
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
           <scope>true</scope>
</dependency>

2.添加spring-boot-maven-plugin：
<build>
		<plugins>
		    <plugin>
	            <groupId>org.springframework.boot</groupId>
	            <artifactId>spring-boot-maven-plugin</artifactId>
	            <configuration>
	          		<!--fork :  如果没有该项配置，肯呢个devtools不会起作用，即应用不会restart -->
	                <fork>true</fork>
	            </configuration>
	        </plugin>
		</plugins>
   </build>
3.1. devtools会监听classpath下的文件变动，并且会立即重启应用（发生在保存时机），注意：因为其采用的虚拟机机制，该项重启是很快的。
3.2. devtools可以实现页面热部署（即页面修改后会立即生效，这个可以直接在application.properties文件中配置spring.thymeleaf.cache=false来实现(这里注意不同的模板配置不一样)。

4.若出现不能使用
对应的spring-boot版本是否正确
是否加入plugin以及属性<fork>true</fork>
Eclipse Project 是否开启了Build Automatically（
如果设置SpringApplication.setRegisterShutdownHook(false)，则自动重启将不起作用。


