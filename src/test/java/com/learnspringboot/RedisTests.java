package com.learnspringboot;

import com.learnspringboot.bean.Department;
import com.learnspringboot.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RedisTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; // string

    @Autowired
    RedisTemplate redisTemplate; // key-value

    @Autowired
    RedisTemplate<Object, Department> deptRedisTemplate;

    //@Test
    public void test01() {
        stringRedisTemplate.opsForValue().append("msg", "redis. Hello");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
    }

    //@Test
    public void test02() {
        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
        System.out.println(stringRedisTemplate.opsForList().leftPop("mylist"));
    }

    //@Test
    public void test03() {
        Department department = new Department(1,"name");
        //redisTemplate.opsForValue().set("dept", department);
        deptRedisTemplate.opsForValue().set("dept", department);

    }
}
