package com.cmcc.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//此注解=Configuration,EnableAutoConfiguration,ComponentScan
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
// @ComponentScan(basePackages = "com.cmcc.ms")
public class Bootstrap {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication app = new SpringApplication(Bootstrap.class);
        //不启动web服务
        //app.setWebEnvironment(false);
        app.run(args);
    }
}
