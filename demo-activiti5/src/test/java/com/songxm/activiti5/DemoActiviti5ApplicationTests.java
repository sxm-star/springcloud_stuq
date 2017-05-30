package com.songxm.activiti5;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DemoActiviti5ApplicationTests {

    @Test
    public void contextLoads() {
    }

    /**
     * 测试生成activiti的25张表
     */
    @Test
    public void testCreateTable() {
        //获取流程引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver"); //配置驱动
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/db_activiti"); //配置连接地址
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");

        //配置模式 true自动创建和更新表
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        //获取流程引擎对象
        ProcessEngine pe  =  pec.buildProcessEngine();
    }

}
