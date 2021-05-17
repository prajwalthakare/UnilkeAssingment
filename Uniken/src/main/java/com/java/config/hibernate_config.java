package com.java.config;

import org.hibernate.usertype.UserType


;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.java.entity.Corporate1;
import com.java.entity.User;





public class hibernate_config {
	@Autowired
	ApplicationContext context;
	
@Bean
	public LocalSessionFactoryBean sessionfactory(){
	System.out.println("HibernateConfiguration---getBean()");
	LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
	factorybean.setConfigLocation(context.getResource("classpath:hibernate10.cfg.xml"));
	factorybean.setAnnotatedClasses(Corporate1.class,User.class);
	return factorybean;
	}
}
