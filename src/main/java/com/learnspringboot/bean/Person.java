package com.learnspringboot.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
	private String lastName;
	private Integer age;
	private Boolean boss;
	private Date birth;

	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;
}
