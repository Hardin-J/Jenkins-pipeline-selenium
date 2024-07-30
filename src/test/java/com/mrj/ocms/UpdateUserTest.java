package com.mrj.ocms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class UpdateUserTest {
	
	WebDriver driver;
	String url = "http://localhost:3001";

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}
	
	@AfterEach
	void tearDown() {
		driver.quit();
	}
	
	@Test
	void updateUserValid() throws InterruptedException {
		driver.get(url+"/updateUser/1");
		WebElement age =  driver.findElement(By.xpath("//input[@placeholder='Enter your Age']"));
		age.clear();
		age.sendKeys("25");
		
		WebElement qual = driver.findElement(By.xpath("//input[@placeholder='Enter your Qualification']"));
		qual.clear();
		qual.sendKeys("B.E");
		{
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='selectedId']"));
			dropdown.findElement(By.xpath("//option[@value='3']")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(1000);
		assertEquals("Data added Successfully", driver.switchTo().alert().getText());
		
	}

}
