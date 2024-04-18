package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	@Test
	public void validLoginTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualHeader = driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}

	@Test(dataProvider = "invalidLoginData",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		String actualError = driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}
}