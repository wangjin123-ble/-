package com.example.demo.config;

import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class SchedulerConfig {
//    @Autowired
//    private CustomerJobFactory jobFactory;
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setOverwriteExistingJobs(true);
//        // 延时启动
//        factory.setStartupDelay(20);
//
//        // 加载quartz数据源配置
//        factory.setQuartzProperties(quartzProperties());
//
//        // 自定义Job Factory，用于Spring注入
//        factory.setJobFactory(jobFactory);
//        return factory;
//    }
//
//    @Bean
//    public Properties quartzProperties() throws IOException {
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
//        // 在quartz.properties中的属性被读取并注入后再初始化对象
//        propertiesFactoryBean.afterPropertiesSet();
//        return propertiesFactoryBean.getObject();
//    }
//
//    /*
//     * quartz初始化监听器
//     */
//    @Bean
//    public QuartzInitializerListener executorListener() {
//        return new QuartzInitializerListener();
//    }
//
//    /*
//     * 通过SchedulerFactoryBean获取Scheduler的实例
//     */
//    @Bean(name = "scheduler")
//    public Scheduler scheduler() throws Exception {
//        return schedulerFactoryBean().getScheduler();
//    }
//

}
