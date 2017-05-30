package com.songxm.activiti5;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloProcess {

	/**
	 * 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
	 */
	private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**
	 * 部署流程定义
	 */
	@Test
	public void deploy(){
	Deployment deployment = 	processEngine.getRepositoryService()//获取部署相关Service
	    .createDeployment() //创建部署
	    .addClasspathResource("diagrams/Hello.bpmn")//加载资源文件
	    .addClasspathResource("diagrams/Hello.png") //加载资源文件
	    .name("Hello world")
	    .deploy(); //部署
	
	System.out.println("流程部署ID：" + deployment.getId());
	System.out.println("流程部署Name：" + deployment.getName());
	}
	
	
	/**
	 * 启动流程实例
	 */
	@Test
	public void startProcessInstance(){
	ProcessInstance pi = 	processEngine.getRuntimeService()  //获取运行时相关service
		.startProcessInstanceByKey("myFirstProcess"); //流程定义表里的key字段值
	    System.out.println("流程实例ID ：" + pi.getId());
	    System.out.println("流程定义ID：" + pi.getProcessDefinitionId());
	}
	/**
	 * 查看任务
	 */
	@Test
	public void findTask(){
	List<Task> taskList = 	processEngine.getTaskService() //获取任务相关service
		.createTaskQuery()       //创建任务查询
		.taskAssignee("songxm")  //指定查看某人
		.list();                //返回任务集合
		
		for (Task task : taskList) {
			System.out.println("任务ID：" + task.getId());
			System.out.println("任务名称:"+ task.getName());
			System.out.println("任务时间:"+ task.getCreateTime());
			System.out.println("任务委派人:"+ task.getAssignee());
			System.out.println("任务实例ID:"+ task.getProcessInstanceId());
		}
	}
	
	/**
	 * 完成任务
	 */
	@Test
	public void completeTask(){
		processEngine.getTaskService()
		.complete("10004");
	}
}
