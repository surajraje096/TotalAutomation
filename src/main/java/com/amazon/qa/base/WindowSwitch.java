package com.amazon.qa.base;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowSwitch {

	@Test
	public void window() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\JARs\\chromeSelinium\\Chrome83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//*[@id=\"openwindow\"]")).click();

		// Count no. of frames on web page.
		System.out.println("Number of frames are available: " + driver.findElements(By.tagName("iframe")).size());

		// Switch frame using index.
		// driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(0));
		driver.switchTo().frame("iframe-name");

		Thread.sleep(5000);

		//driver.switchTo().frame(1);
		driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']/following-sibling::div[1]"))
				.click();
		Thread.sleep(5000);

		driver.switchTo().parentFrame();
		driver.close();

		/*
		 * Set<String>windids =driver.getWindowHandles(); Iterator<String>itrator
		 * =windids.iterator();
		 * 
		 * System.out.println(itrator.next());//First Window
		 */
		// driver.findElement(By.xpath("//*[@id=\"openwindow\"]")).click();

		/*
		 * windids =driver.getWindowHandles(); itrator =windids.iterator(); String
		 * Mainwindowid =itrator.next(); String Chiledwindowid =itrator.next();
		 * System.out.println(Mainwindowid); System.out.println(Chiledwindowid);
		 */

		/*
		 * driver.switchTo().frame(0); Thread.sleep(5000); driver.switchTo().frame(2);
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"homepage\"]/div[6]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]"
		 * )).click();
		 * 
		 */

		System.out.println("done");

		driver.close();

	}

}
