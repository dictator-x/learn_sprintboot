package com.learnspringboot.bean;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Employee {
	private Integer id;
	private String name;
	private Integer age;
}
