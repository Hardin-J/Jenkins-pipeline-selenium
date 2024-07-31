package com.mrj.ocms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AddUserTest {
	WebDriver driver;
	String url = "http://localhost:3000";

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}
	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void addUserValid() throws InterruptedException {
		driver.get(url + "/addUser");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Name']")).sendKeys("Madhan");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Age']")).sendKeys("21");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Qualification']")).sendKeys("B.E");
		{
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='selectedId']"));
			dropdown.findElement(By.xpath("//option[.='2']")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(1000);
		assertEquals("Data added Successfully", driver.switchTo().alert().getText());
	}


}
