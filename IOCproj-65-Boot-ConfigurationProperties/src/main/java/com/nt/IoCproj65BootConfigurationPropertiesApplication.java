package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.beans.Person;

@SpringBootApplication

public class IoCproj65BootConfigurationPropertiesApplication {

	public static void main(String[] args) {
ApplicationContext ctx	=SpringApplication.run(IoCproj65BootConfigurationPropertiesApplication.class, args);
Person per=ctx.getBean("per", Person.class);
System.out.println(per);
	}

}
