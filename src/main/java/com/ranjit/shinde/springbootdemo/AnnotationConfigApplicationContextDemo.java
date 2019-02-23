package com.ranjit.shinde.springbootdemo;

import com.ranjit.shinde.springbootdemo.config.AppConfig;
import com.ranjit.shinde.springbootdemo.model.Movie;
import com.ranjit.shinde.springbootdemo.service.MovieService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import org.springframework.context.annotation.Import;

public class AnnotationConfigApplicationContextDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Movie movie1 = context.getBean("ddlj", Movie.class);
        movie1.setName("d");
        System.out.println(movie1);

        Movie movie2 = context.getBean("ddlj", Movie.class);
        System.out.println(movie2);

        for(String beanName:context.getBeanDefinitionNames()){
            System.out.println(beanName);
        }


    }
}
