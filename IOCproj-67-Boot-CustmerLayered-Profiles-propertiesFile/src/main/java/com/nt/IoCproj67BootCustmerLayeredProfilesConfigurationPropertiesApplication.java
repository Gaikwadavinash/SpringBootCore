package com.nt;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.BankController;
import com.nt.vo.CustmerVO;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class IoCproj67BootCustmerLayeredProfilesConfigurationPropertiesApplication {
@Autowired
	private Environment env;
		
//Dev env..  (Apache DBCp2)
	@Bean("cpds1")
	@Profile("dev")
public DataSource createDataSource()throws Exception {
	//ComboPooledDataSource cpds= new ComboPooledDataSource();
BasicDataSource cpds= new BasicDataSource();
	cpds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
cpds.setUrl(env.getRequiredProperty("spring.datasource.url"));
cpds.setUsername(env.getRequiredProperty("spring.datasource.username"));
cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
return cpds;
	}
	//uat env.. (c3P0)
	@Bean("cdps2")
@Profile("uat")
	public DataSource createSource()throws Exception{
		ComboPooledDataSource cpds= new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return cpds;
	}
//apache tomcat
//test env
	@Bean("dpcs3")
@Profile("test")
	public DataSource cDataSource() {
		 org.apache.tomcat.jdbc.pool.	DataSource ds= new org.apache.tomcat.jdbc.pool.DataSource();
ds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
	ds.setUrl(env.getRequiredProperty("spring.datasource.url"));
			ds.setUsername(env.getRequiredProperty("spring.datasource.username"));
			ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
			return ds;
	}
	
	@Bean("cpds4")
@Profile("prod")
	public DataSource createSourceData()throws Exception {
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		hkds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
				hkds.setUsername(env.getRequiredProperty("spring.datasource.username"));
				hkds.setPassword(env.getRequiredProperty("spring.datasource.password"));
				return hkds;
	}
	public static void main(String[] args)  {
ApplicationContext ctx=SpringApplication.run(IoCproj67BootCustmerLayeredProfilesConfigurationPropertiesApplication.class, args);
try {
BankController controller=ctx.getBean("controller",BankController.class);

CustmerVO vo= new CustmerVO("manasi","Banglore", "20000", "10.0", "5.0");
String Result=controller.processCustmer(vo);
System.out.println(Result);
}catch (Exception e) {
	e.printStackTrace();
}
System.out.println("active profile is ::"+Arrays.toString(ctx.getEnvironment().getActiveProfiles()));

System.out.println();
	}

}
