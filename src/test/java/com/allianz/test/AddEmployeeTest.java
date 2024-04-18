package com.allianz.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class AddEmployeeTest extends AutomationWrapper {
	
	@Test
	public void uploadInvalidDisplayPictureTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Automation Session\\automation_workspace\\HealthManagementAutomation\\pom.xml");
		
		String actualError = driver.findElement(By.xpath("//span[contains(normalize-space(),'File type')]")).getText();
		Assert.assertTrue(actualError.contains("File type not allowed"));
				
		//click on PIM menu
		//click on add employee
		//upload the pdf file instead of image
		//Assert the error - File type not allowed
	}

}