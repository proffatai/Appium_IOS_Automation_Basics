package iOSTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iOS_Slider_pickerView extends BaseClass{

	@Test
	public void iOSSlider() throws InterruptedException  {

//
//		pickerView();
//		slider();
//		switches();
		datePicker();

	}

	public void pickerView() throws InterruptedException {

		//picker view
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		//we have to pass a string to sendKeys()
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("0");
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("245");
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("200");
		Thread.sleep(1000);
		//Lets put an assertion to be sure that the slider worked by getting the value that we slide to

		String value=driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
		Assert.assertEquals(value, "200");

		back();
		Thread.sleep(1000);

	}


	public void slider() throws InterruptedException {
		//slider
		driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
		//we have to pass a string to sendKeys()
		driver.findElement(AppiumBy.iOSNsPredicateString("value == '42%'")).sendKeys("0");
		Thread.sleep(2000);

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == '50%'`][2]")).sendKeys("1");
		Thread.sleep(2000);

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == '50%'`][1]")).sendKeys("0.75");
		Thread.sleep(2000);

		back();
		Thread.sleep(2000);
	}


	public void switches() throws InterruptedException {
		//Toggle switch ON || OFF
		driver.findElement(AppiumBy.accessibilityId("Switches")).click();

		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == \"1\"`][2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value=='1'`][1]")).click();
		Thread.sleep(2000);
	}

	public void datePicker() throws InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Date Picker")).click();
		
		driver.findElement(AppiumBy.accessibilityId("20 Jul 2024")).click();
		driver.findElement(AppiumBy.accessibilityId("Thursday, 25 July")).sendKeys("27");
		
		Thread.sleep(2000);
		back();
		
		
	}
}


