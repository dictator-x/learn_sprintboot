package com.learnspringboot;

import com.learnspringboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApplicationTests {

  @Autowired
  Person person;

  @Autowired
  ApplicationContext ioc;

  @Test
  public void contextLoads() {
    System.out.println(person);
  }

  @Test
  public void testHelloService() {
    boolean b = ioc.containsBean("helloService");
    System.out.println(b);
  }
}
