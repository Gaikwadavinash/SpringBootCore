package com.nt;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class IoCproj66BootConfigurationPropertiesYmlApplication {

	public static void main(String[] args) {
		//SpringApplication application= new SpringApplication();
		//application.setBannerMode(Mode.OFF);
ApplicationContext ctx=SpringApplication.run(IoCproj66BootConfigurationPropertiesYmlApplication.class, args);
	
Person per=ctx.getBean("perSon",Person.class);
System.out.println(per+" ");
	}

}
