## HOW TO INSTALL THE IOS APP INTO THE EMULATOR
Open the .app file on xcode and build the app on any selected simulator of your choice. When build is completed, the application gets installed into the simulator.


## Setting the desired capability to run the app

IOSDriver driver; // Our driver is of type IOSDriver.
public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS"); //this is straightforward
		capabilities.setCapability("platformVersion", "17.4"); // This can be gotten after starting the simulator. It is present at the top section of the emulator in the form iOS x.x.x
		capabilities.setCapability("deviceName or udid","iPhone 15 Pro Max or the identifier"); // This is the name of the emulator. It can also be found after starting the emulator
		capabilities.setCapability("app","//Users//proffatai//Documents//Appium Android Automation//Practice//src//iOSTest//UiKitCatalog.app");// This is the location to the .app file
		capabilities.setCapability("automationName", "XCUITest"); // Name of the automation to use. Pretty straightforward

		driver = new IOSDriver(new URL("http://127.0.0.1:4723"),capabilities); // we are creating an object of the IOSDriver. Similar to AndroidDriver
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
## Setting up Appium Inspector
Similar to what we passed to the desired capabilities method
app: path to the .app file
platformName: iOS
automationName: XCUITest
udid or deviceName
deviceName is simply the name of the simulator
udid:Universal device identifier, How to get it: Open Xcode, Click on that dropdown that shows list of iPhones simulators available, click on Manage Run Destinations, Click Simulators, click any of the simulators, now copy the identifier that appears. That is the udid


## Locators that can be used to access an element
All the locators that can be used on android devices like: id, accessibilityId,name, className, xpath etc and some iOS specific selectors like:
-  iOSNsPredicateString:  This selector uses an NSPredicate string to locate elements. It’s a powerful way to query elements with specific conditions.
Example / Usage
`driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'Login'"));`

- iOSClassChain: This selector uses a class chain query to locate elements. It’s particularly useful for complex element hierarchies.
`driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[`name == 'ItemCell'`]"));`

Note: xpath and iOSclassChains are similar. PS: in iOS apps, using xpath might become slow because the native source of iOS applications do not use xml to locate object thereby requiring some form of conversions to be done.
To prevent this, we can use the iOSClassChain property, and the syntax is similar to that of xpath.
For xpath: xpath(//tagname[@attr='value'])
for classChain: iOSClassChain(**/tagname[`attr=='value'`])

## Finding iOSNsPredicateString: This simply means matching string, it also allows us to use multiple attributes to locate an element.
Syntax: iOSNsPredicateString("attr='value'") OR using multiple attributes: iOSPredicateString(attr1=value1 AND attr2=value2)

## ENDSWITH and STARTSWITH
driver.findElement(AppiumBy.iOSNsPredicateString("type BEGINSWITH 'XCUIElement' AND label=='UIKitCatalog'")).click(); //We want to click on an element that has a type attribute whose value starts with XCUIElement and it also has an attribute label which equals to UIKitCatalog.
driver.findElement(AppiumBy.iOSNsPredicateString("name [c] ENDSWITH 'Controls'")).click(); //We want to click on an element that has a name attribute whose value ends with Controls. PS [c] implies we are neglecting the case of the text. We are interested in the value
	
	
type BEGINSWITH 'XCUIElement' AND label=='UIKitCatalog'