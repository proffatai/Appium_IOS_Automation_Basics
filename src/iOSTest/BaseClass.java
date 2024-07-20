package iOSTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {
	public static IOSDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "17.4");
		capabilities.setCapability("deviceName","iPhone 15");
		capabilities.setCapability("app","//Users//proffatai//Documents//Appium iOS Automation//Appium_IOS_Automation_Basics//src//iOSTest//UIKitCatalog.app");
		capabilities.setCapability("automationName", "XCUITest");

		driver = new IOSDriver(new URL("http://127.0.0.1:4723"),capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void scroll(String direction) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", direction);
		((JavascriptExecutor) driver).executeScript("mobile:scroll", params);
	}

	public void scrollDown2() {
		// Get screen size
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();

		// Create PointerInput instance for touch actions
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		// Create sequence of actions for scroll gesture
		Sequence scroll = new Sequence(finger,0);
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(0),
				PointerInput.Origin.viewport(), width / 2, height / 2));
		scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000),
				PointerInput.Origin.viewport(), width / 2, height / 4));
		scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the scroll
		driver.perform(Arrays.asList(scroll));
	}

	public void scrollToElement(String elementText) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("predicateString", "label == '" + elementText + "'");

		((JavascriptExecutor) driver).executeScript("mobile:scroll", params);
	}

	public static void swipe(String direction) {
		Map<String, Object> params = new HashMap<>();
		params.put("direction", direction);
		((JavascriptExecutor) driver).executeScript("mobile:swipe", params);
	}

	public void back() {
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'UIKitCatalog' AND type == 'XCUIElementTypeButton'")).click(); 
	}

	public void longPressONElementByXPATH(String elementXpath, int duration) {
		WebElement element=driver.findElement(AppiumBy.xpath(elementXpath));
		Map<String, Object> param=new HashMap<>();
		param.put("element", ((RemoteWebElement)element).getId());
		param.put("duration", duration);
		driver.executeScript("mobile:touchAndHold", param);

	}

	//Perform escape action
	public void performEditorAction() {
		Map<String, Object> params = new HashMap<>();
		params.put("action", "escape");  // Adjust the action as needed
		((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", params);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
