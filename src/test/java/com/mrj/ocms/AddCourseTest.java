package com.mrj.ocms;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class AddCourseTest {
	WebDriver driver;
	String url = "http://localhost:3000";

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	void addCourseValid() {		
		driver.get(url+"/addCourse");
		driver.findElement(By.xpath("//input[@placeholder='Enter Course Name']")).sendKeys("C++");
		driver.findElement(By.xpath("//input[@placeholder='Enter Course Duration']")).sendKeys("120");
		driver.findElement(By.xpath("//input[@placeholder='Enter Course Cost']")).sendKeys("120");
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		alert.accept();
		assertEquals("Data added Successfully", txt);
	}
	
	@AfterEach
	void tearDown() {
		driver.quit();
	}


}
