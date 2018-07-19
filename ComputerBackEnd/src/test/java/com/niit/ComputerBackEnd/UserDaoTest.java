package com.niit.ComputerBackEnd;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ComputerBackEnd.Dao.UserDAO;
import com.niit.ComputerBackEnd.Model.UserDetail;

public class UserDaoTest {
	
	static UserDAO userDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void addProductTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("kishok");
		user.setEmailId("kishok2554@gmail.com");
		user.setMobileNo("7200912126");
		user.setAddress("chennai");
		user.setCustomerName("kishokreddy");
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		user.setPassword("kishok123");
		
		assertTrue("Problem in Adding Category",userDAO.registerUser(user));
		System.out.println("----Successfully register----");
	}

}
