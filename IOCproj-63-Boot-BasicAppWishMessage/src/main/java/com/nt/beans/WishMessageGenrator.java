package com.nt.beans;

import java.time.LocalDateTime;
import java.util.concurrent.Flow.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("Wish")

public class WishMessageGenrator {
@Autowired
	private LocalDateTime sysDateTime;
public WishMessageGenrator() {
System.out.println("WishMessageGenrator::0-Param Constructor");
}

public String showMessage(String user) {
int hour=sysDateTime.getHour()+1;

if(hour<12) {
	return "Good Morning"+user;
}else if(hour<16) {
	return "Good AfterNoon"+user;
}else if (hour<19) {
	return "Good Evening"+user;
}else {
	return "Good Night"+user;
}
}

}
