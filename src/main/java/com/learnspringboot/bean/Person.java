package com.learnspringboot.bean;

// import org.hibernate.validator.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
// @ConfigurationProperties(prefix = "person")
// batch inject
// fuzzy inject
// support @Validated, JSR303
// @Validated
// @Value do not work for some reference type like: map
// @PropertySource(value = {"classpath:person.properties"}) // read property from a file
public class Person {
	// @Value("${person.last-name}")
	// spEl support
	// @Value("${PATH}") // get property from env
	// @Email: TODO: import dependency
	private String lastName;
	// @Value("#{11*2}")
	private Integer age;
	// @Value("true")
	private Boolean boss;
	private Date birth;

	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;
}
