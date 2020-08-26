package com.wordpress.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AutomationPage;

public class AutomationTest extends TestBase {

	AutomationPage Automation;

	public AutomationTest() {
		super(); /// perent class cha default constructor call
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		Automation = new AutomationPage();
	}

	@Test()
	public void Alert() throws Throwable {
		Automation.RadioBTN();

	}

	@Test()
	public void acti() throws Throwable {
		Automation.TextBox();

	}

	@Test()
	public void actip() throws Throwable {
		Automation.DropDown();
	}

	@Test()
	public void actikp() throws Throwable {
		Automation.CheckOption();
	}

	@AfterMethod()
	public void tearDown() {

		driver.quit();
	}

}
