package com.ex.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ex.dto.StudentDto;

/**
 * @RunWith(SpringRunner.class)
 * junit4测试使用  注解的意义在于Test测试类要使用注入的类，比如@Autowired注入的类，
 * 有了@RunWith(SpringRunner.class)这些类才能实例化到spring容器中，自动注入才能生效，
 * 不然直接一个NullPointerExecption
 * @WebAppConfiguration 
 * 由于是Web项目，Junit需要模拟ServletContext，
 * 因此我们需要给我们的测试类加上@WebAppConfiguration。
 * @author majj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	private StudentDto studentDto ;
	
	@Test
	public void contextLoads() {
		System.out.println(studentDto);
	}

}
