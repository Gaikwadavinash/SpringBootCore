package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@ConfigurationProperties(prefix = "info.per")
@Component("perSon")
public class Person {

	private int id;
	private String name;
	
	private int marks[];
	private List<String> nickName;
	private Set<Long> phoneNo;
	
	
	private Map<String, Long> idCard;
	
	private Properties favFruits;
	
	private Company company;
	
}
