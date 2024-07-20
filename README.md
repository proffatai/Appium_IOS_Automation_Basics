## HOW TO INSTALL THE IOS APP INTO THE EMULATOR
Open the .app file on xcode and build the app on any selected simulator of your choice. When build is completed, the application gets installed into the simulator.
<br>

## Setting the desired capability to run the app
<br>
IOSDriver driver; // Our driver is of type IOSDriver.
<br>
public void setup() throws MalformedURLException {
<br>
		DesiredCapabilities capabilities= new DesiredCapabilities();
		<br>
		capabilities.setCapability("platformName", "iOS"); //this is straightforward
		<br>
		capabilities.setCapability("platformVersion", "17.4"); // This can be gotten after starting the simulator. It is present at the top section of the emulator in the form iOS x.x.x
		<br>
		capabilities.setCapability("deviceName or udid","iPhone 15 Pro Max or the identifier"); // This is the name of the emulator. It can also be found after starting the emulator
		<br>
		capabilities.setCapability("app","//Users//proffatai//Documents//Appium Android Automation//Practice//src//iOSTest//UiKitCatalog.app");// This is the location to the .app file
		<br>
		capabilities.setCapability("automationName", "XCUITest"); // Name of the automation to use. Pretty straightforward
		<br>
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"),capabilities); // we are creating an object of the IOSDriver. Similar to AndroidDriver
		<br>
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		<br>
	}
<br>
## Setting up Appium Inspector
<br>
Similar to what we passed to the desired capabilities method
<br>
app: path to the .app file
<br>
platformName: iOS
<br>
automationName: XCUITest
<br>
udid or deviceName
<br>
deviceName is simply the name of the simulator
<br>
udid:Universal device identifier, How to get it: Open Xcode, Click on that dropdown that shows list of iPhones simulators available, click on Manage Run Destinations, Click Simulators, click any of the simulators, now copy the identifier that appears. That is the udid
<br>

## Locators that can be used to access an element
<br>
All the locators that can be used on android devices like: id, accessibilityId,name, className, xpath etc and some iOS specific selectors like:
<br>
-  iOSNsPredicateString:  This selector uses an NSPredicate string to locate elements. It’s a powerful way to query elements with specific conditions.
<br>
Example / Usage
<br>
`driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'Login'"));`
<br>
- iOSClassChain: This selector uses a class chain query to locate elements. It’s particularly useful for complex element hierarchies.
<br>
`driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'ItemCell'`]"));`
<br>
Note: xpath and iOSclassChains are similar. PS: in iOS apps, using xpath might become slow because the native source of iOS applications do not use xml to locate object thereby requiring some form of conversions to be done.
<br>
To prevent this, we can use the iOSClassChain property, and the syntax is similar to that of xpath.
<br>
For xpath: xpath(//tagname[@attr='value'])
<br>
for classChain: iOSClassChain(**/tagname[`attr=='value'`])
<br>
## Finding iOSNsPredicateString: This simply means matching string, it also allows us to use multiple attributes to locate an element.
<br>
Syntax: iOSNsPredicateString("attr='value'") OR using multiple attributes: iOSPredicateString(attr1=value1 AND attr2=value2)
<br>
## ENDSWITH and STARTSWITH
<br>
driver.findElement(AppiumBy.iOSNsPredicateString("type BEGINSWITH 'XCUIElement' AND label=='UIKitCatalog'")).click(); //We want to click on an element that has a type attribute whose value starts with XCUIElement and it also has an attribute label which equals to UIKitCatalog.
<br>
driver.findElement(AppiumBy.iOSNsPredicateString("name [c] ENDSWITH 'Controls'")).click(); //We want to click on an element that has a name attribute whose value ends with Controls. PS [c] implies we are neglecting the case of the text. We are interested in the value
	
	
type BEGINSWITH 'XCUIElement' AND label=='UIKitCatalog'



