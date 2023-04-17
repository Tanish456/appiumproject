package NativeApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class capabilities {
public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Tanishka");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	//dc.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
	//DEFAULT automation name for mobile is APPIUM and it works in both IOS and android. 
	//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.APPIUM);
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);  
	return driver;
}
}
     