package com.ranjit.shinde.springbootdemo;

import com.ranjit.shinde.springbootdemo.model.Movie;
import org.springframework.boot.web.servlet.context.XmlServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApplicationContext {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Movie ddlj = context.getBean("ddlj", Movie.class);
        System.out.println(ddlj.getName() + "-"+ddlj.getReleaseDate());

        for(String beanName:context.getBeanDefinitionNames()){
            System.out.println(beanName);
        }
    }
}
