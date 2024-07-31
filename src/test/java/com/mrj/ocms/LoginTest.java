package com.mrj.ocms;

// import static org.junit.jupiter.api.Assertions.*;

// import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
// import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;


class LoginTest {

	WebDriver driver;
	String url = "http://localhost:3000";

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	@Order(1)
	void validLogin() {
		driver.get(url + "/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mr.j");
		driver.findElement(By.xpath("//input[@id='pswd']")).sendKeys("jeeva@123");
		driver.findElement(By.id("login-btn")).click();
	}

	@Test
	@Order(2)
	void inValidLogin() {
		driver.get(url + "/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jeeva");
		driver.findElement(By.xpath("//input[@id='pswd']")).sendKeys("jeeva@123");
		driver.findElement(By.id("login-btn")).click();
//		assertEquals("Invalid Credentials",driver.switchTo().alert().getText());
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		String txt = alert.getText();
//		alert.accept();
//		System.out.println(txt);
//		assertEquals("Invalid Credentials", txt);
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}
	
	

}
