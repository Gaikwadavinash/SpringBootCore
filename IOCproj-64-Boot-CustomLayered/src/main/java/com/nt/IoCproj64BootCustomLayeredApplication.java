package com.nt;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.BankController;
import com.nt.vo.CustmerVO;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")

public class IoCproj64BootCustomLayeredApplication {
/*
	@Autowired
	private Environment env;
	@Bean(name="c3pODS")
	public   DataSource createC3PODS() throws Exception{
		ComboPooledDataSource ds=new ComboPooledDataSource();
		ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return ds;
	}
	*/

	

	public static void main(String[] args) {
ApplicationContext ctx=	SpringApplication.run(IoCproj64BootCustomLayeredApplication.class, args);
	try {	
BankController controller= ctx.getBean("controller",BankController.class);

CustmerVO vo=new CustmerVO();
vo.setCName("raja");
vo.setCAddrs("Mumbai");
vo.setPAmt("150.0f");
vo.setRate("10.0f");
vo.setTime("5.00");

String Result=controller.processCustmer(vo);
System.out.println(Result);
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

}
