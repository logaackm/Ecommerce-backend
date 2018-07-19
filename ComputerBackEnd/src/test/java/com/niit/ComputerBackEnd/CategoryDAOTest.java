package com.niit.ComputerBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ComputerBackEnd.Dao.CategoryDAO;
import com.niit.ComputerBackEnd.Model.Category;



public class CategoryDAOTest 
{
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Laptop");
		category.setCateogryDesc("Laptop with All Brands");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
		System.out.println("----Successfully register----");
	}
	/*@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryName("Samsung-Galaxy");
		assertTrue("Problem in Updating",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting:",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("Problem in Retrieving:",listCategories);
	}*/
	
}
