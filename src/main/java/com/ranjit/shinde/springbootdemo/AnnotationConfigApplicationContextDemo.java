package com.ranjit.shinde.springbootdemo;

import com.ranjit.shinde.springbootdemo.config.AppConfig;
import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.model.MyBean;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import org.springframework.context.annotation.Import;
import  javax.annotation.PostConstruct;

import java.text.NumberFormat;

public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Movie movie1 = context.getBean("ddlj", Movie.class);
        movie1.setName("d");
        System.out.println(movie1);

        Movie movie2 = context.getBean("ddlj", Movie.class);
        System.out.println(movie2);

        NumberFormat cf = context.getBean("cf", NumberFormat.class);
        System.out.println(cf.format(123));

        MyBean mb1 = context.getBean(MyBean.class);
        System.out.println(mb1.hashCode());

        MyBean mb2 = context.getBean(MyBean.class);
        System.out.println(mb2.hashCode());

        context.close();

        for(String beanName:context.getBeanDefinitionNames()){
         //   System.out.println(beanName);
        }


    }
}
