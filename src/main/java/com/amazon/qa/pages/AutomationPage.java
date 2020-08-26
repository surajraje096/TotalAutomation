package com.amazon.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class AutomationPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"radio-btn-example\"]/fieldset/label[1]/input")
	WebElement Radio;

	@FindBy(xpath = "//*[@id=\"autocomplete\"]")
	WebElement Text;

	@FindBy(id = "checkBoxOption1")
	WebElement option1;

	@FindBy(id = "openwindow") //
	WebElement window;

	@FindBy(id = "\"dropdown-class-example\"") //
	WebElement select;

	@FindBy(xpath = "//*[@id=\"homepage\"]/div[6]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")
	WebElement Popup;

	@FindBy(linkText = "Open Tab")
	WebElement NewTab;

	@FindBy(id = "name")
	WebElement AlertText;

	@FindBy(id = "alertbtn")
	WebElement AlertBtn;

	@FindBy(id = "displayed-text")
	WebElement HideText;
	
	@FindBy(id = "hide-textbox")
	WebElement HideBtn;

	@FindBy(id = "show-textbox")
	WebElement ShowBtn;
	
	@FindBy(xpath ="//*[@id=\"product\"]/tbody")
	WebElement Webtable;
	
	@FindBy(id ="mousehover")
	WebElement MouseMOve;
	
	@FindBy(linkText ="Top")
	WebElement MouseMOveTop;
	
	@FindBy(xpath ="(//a[@href='https://courses.rahulshettyacademy.com/courses'])[1]")
	WebElement course;
	
	@FindBy(name ="courses-iframe")
	WebElement Iframe;
	
	public AutomationPage() {
		PageFactory.initElements(driver, this);
	}

	public void RadioBTN() throws Throwable {
		// Action.isSelected(driver, Radio);
		//Action.click(driver, Radio);
		
		
	//	driver.findElement(By.xpath("//*[@id=\\\"radio-btn-example\\\"]/fieldset/label[1]/input")).click();
		
		Radio.click();
		
	}

	public void TextBox() throws Throwable {
		//Action.type(Text, Name);
		
		Text.sendKeys("suraj");
	}

	public void DropDown() throws Throwable {

		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText("Option2");
	
	}

	public void CheckOption() throws Throwable {
	//	Action.click(driver, option1);
		option1.click();
	}

	public void SwitchWindow() throws Throwable {
		Action.click(driver, window);
		Action.switchToFrameByName("iframe-name");
		Action.implicitlyWait(driver);
		Action.click(driver, Popup);
		driver.quit();

	}

	public void NewWindow() throws Throwable {
		Action.click(driver, NewTab);
		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWindowID = it.next();
		// System.out.println("parent widnow id is : "+ parentWindowID);

		String childWindowID = it.next();
		// System.out.println("child pop up widnow id is : "+ childWindowID);

		driver.switchTo().window(childWindowID);

		System.out.println("child window title is " + driver.getTitle());

		driver.close();

		driver.switchTo().window(parentWindowID);
		System.out.println("parent window title is " + driver.getTitle());

	}

	public void GetAlert(String Msg) throws Throwable {
		Action.type(AlertText, Msg);
		Action.click(driver, AlertBtn);
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
	}

	public void HideText(String HideTex) throws Throwable {
		Action.type(HideText, HideTex);
		Thread.sleep(3000);
		Action.click(driver, HideBtn);
		Thread.sleep(3000);
		Action.click(driver, ShowBtn);
		
	}
	
	public String WebTable() throws Throwable {
		return Webtable.getText();
	}
	
	public void MouseMove() throws Throwable {
		Action.mouseOverElement(MouseMOve);
		Thread.sleep(3000);
		Action.click(driver,MouseMOveTop );
	}
	
	public void Iframe() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", MouseMOve);
		
		/*  JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		   */
		/*	int frameCount = driver.findElements(By.tagName("frame")).size();
			System.out.println("total frames: "+ frameCount);
			
			WebElement frameElement = Iframe;*/
			driver.switchTo().frame(0);
			
			String text = course.getText();
			System.out.println(text);
			course.click();
			driver.switchTo().defaultContent();
		  Thread.sleep(6000);
	}
	
	
	
}
