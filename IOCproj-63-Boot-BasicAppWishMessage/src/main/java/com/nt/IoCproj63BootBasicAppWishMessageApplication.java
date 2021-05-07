package com.nt;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenrator;

@SpringBootApplication
public class IoCproj63BootBasicAppWishMessageApplication {
@Bean(name ="dt")
	public LocalDateTime createDateTime() {
		System.out.println("IoCproj63BootBasicAppWishMessageApplication.createDateTime()");
return LocalDateTime.now();
	}
	
	
	public static void main(String[] args) {
ApplicationContext ctx=SpringApplication.run(IoCproj63BootBasicAppWishMessageApplication.class, args);
	
//targetClas Objetc
		
		WishMessageGenrator genrator=ctx.getBean("Wish", WishMessageGenrator.class);
	System.out.println("Message:"+genrator.showMessage("raja"));
	((ConfigurableApplicationContext) ctx).close();
	}

}
