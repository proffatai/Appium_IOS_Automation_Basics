package iOSTest;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Gestures extends BaseClass {

	@Test
	public void Setup() throws MalformedURLException, InterruptedException {
	
		scroll("down");
		clickWebView();
		Thread.sleep(2000);
		back();
		swipe("down");
		Thread.sleep(2000);
		clickImageView();
		Thread.sleep(2000);
		back();
		scrollDown2();
		clickWebView();
		back();
		scrollToElement("Activity Indicators");
		clickActivityIndicator();
		back();
		clickSteppers();
		back();
		Thread.sleep(3000);
	}
	
	public void clickActivityIndicator() {
		driver.findElement(AppiumBy.accessibilityId("Activity Indicators")).click(); 
	}
	
	public void clickWebView() {
		driver.findElement(AppiumBy.accessibilityId("Web View")).click(); 
		String text=driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a ")).getAttribute("name");
		Assert.assertEquals(text, "This is HTML content inside a ");
	}
	
	public void clickImageView() {
		driver.findElement(AppiumBy.accessibilityId("Image View")).click(); 
	}
	public void clickSteppers()
	{
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click(); 
		longPressONElementByXPATH("(//XCUIElementTypeButton[@name='Increment'])[3]", 2);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
