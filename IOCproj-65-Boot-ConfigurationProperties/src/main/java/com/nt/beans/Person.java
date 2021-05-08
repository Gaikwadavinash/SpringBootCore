package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import lombok.Data;

@Data
@Component("per")
@ConfigurationProperties(prefix = "info.per")
public class Person {
	//@Value("${info.per.id}")
private int id;
	//@Value("${info.per.name}")
private String name;

//Collection and Array Type Property
private Integer marks[];
private List<String> nickName;
private Set<Long> phoneNo;


//Map Collection Properties
private Map<String,Long> idCards;
private Properties favFriuts;


//Has-a-Property
private Address addrs;
}
