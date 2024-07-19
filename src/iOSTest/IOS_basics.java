package iOSTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOS_basics extends BaseClass {

	@Test
	public void Setup() throws MalformedURLException, InterruptedException {
		String message="Hello everybody";
		// Accessing app elements using 6 different locators
		clickAlert();
		Thread.sleep(2000);
		clickTextEntry(message);
		Thread.sleep(2000);
		clickOther();
		Thread.sleep(2000);
		clickSimple();
		Thread.sleep(2000);
		back();
		clickDefault();
		Thread.sleep(2000);
	}
	public void clickAlert() {
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click(); //also works with id
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Confirm / Cancel']")).click();
		driver.findElement(AppiumBy.name("Confirm")).click();

	}

	public void clickTextEntry(String text)
	{

		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Text Entry'")).click();
		driver.findElement(AppiumBy.className("XCUIElementTypeTextField")).sendKeys(text);
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'OK'`]")).click();

	}
	
	public void clickOther() {
		driver.findElement(AppiumBy.id("Other")).click();
		driver.findElement(AppiumBy.accessibilityId("Choice One")).click();
	}
	
	
	public void clickSimple() {
		driver.findElement(AppiumBy.iOSNsPredicateString("name== 'Simple'")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("name=='OK'")).click();
		
	}

	
	public void clickDefault() {
		driver.findElement(AppiumBy.iOSNsPredicateString("name ENDSWITH 'arch'")).click(); //We want to click on an element that has a name attribute whose value ends with arch. PS [c] implies we are neglecting the case of the text. We are interested in the value
		driver.findElement(AppiumBy.iOSNsPredicateString("name ENDSWITH 'fault'")).click(); //We want to click on an element that has a label attribute whose value starts with Def and it also has an attribute value which starts with Def.
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
