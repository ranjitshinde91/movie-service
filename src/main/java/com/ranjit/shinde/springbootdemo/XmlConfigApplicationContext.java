package com.ranjit.shinde.springbootdemo;

import com.ranjit.shinde.springbootdemo.model.Movie;
import org.springframework.boot.web.servlet.context.XmlServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.parsers.DocumentBuilder;
import java.text.NumberFormat;

public class XmlConfigApplicationContext {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Movie ddlj = context.getBean("ddlj", Movie.class);
        System.out.println(ddlj.getName() + "-" + ddlj.getReleaseDate());

        NumberFormat cf = context.getBean("cf", NumberFormat.class);
        System.out.println(cf.format(123));

        DocumentBuilder docBuilder = context.getBean("docBuilder", DocumentBuilder.class);
        System.out.println(docBuilder);


        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
