package NativeApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//for tap options
import static io.appium.java_client.touch.TapOptions.tapOptions;
//for long press
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//for element 
import static io.appium.java_client.touch.offset.ElementOption.element;
//for timeDuration
import static java.time.Duration.ofSeconds;
public class capability extends capabilities{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void eat() throws MalformedURLException {
		driver = cap();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test (enabled =false)
	public void preferences() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();//preference
		Thread.sleep(4000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();  //preference dependencies
		driver.findElement(By.id("android:id/checkbox")).click();    //wifi checkbox
		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();  //wifisettings
		//you are using androidUIautomator to identify an element using an attribute then,
		//you have to use UIselector() method for selecting the attribute
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Tanishka");
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
//	@Test  (priority =0)(enabled=false)
//	public void notification() {
//		driver.openNotifications();
//		driver.findElement(By.id("android:id/icon")).click();  //no allow
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.findElement(By.className("android.widget.ImageView").getClass().click();  //network changer
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.findElement(By.id("android:id/icon")).click();   //flight modeqqq
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.findElement(By.xpath("//android.widget.Switch[@content-desc='Auto-rotate screen']")).click();  //rotate screen
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));   
//		driver.findElement(By.xpath("//android.widget.Switch[@content-desc='Wi-Fi,Wifi signal full.,AndroidWifi']")).click();  //wifi
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));  
//	}
	@Test  (enabled =false)
	public void views() {
		//driver.findElementByAndroidUIAutomator("text(\"Views\")");
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//if you want to scroll . you need 3 things
		//UIAutomator, UI selector ,UI Scrollable
		driver.findElementByAndroidUIAutomator("new Scrollable(new UI Selector()).scrollIntoView (text(\"WebView\"))");
		AndroidElement clickable1  =driver.findElementByAndroidUIAutomator("new UISelector().clickable(true)");
		 Dimension print = clickable1.getSize();
		System.out.println(print);
	}
		
	@Test(enabled =true)
	public void tapandlongpress() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();	
		Thread.sleep(4000);
		AndroidElement  ele =driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
		Thread.sleep(4000);
		TouchAction at = new TouchAction(driver);
		at.tap(tapOptions().withElement(element(ele))).perform();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
	    AndroidElement ele1 = driver.findElementByAndroidUIAutomator("text(\"Fish Names\"");
		at.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).release().perform();
		String simple = driver.findElementsByClassName("android.widget.TextView").get(0).getText();    //
		System.out.println(simple);
		String simple2 = driver.findElementsByClassName("android.widget.TextView").get(1).getText();     //
		System.out.println(simple2);
	}
	@Test
	public void swipeaction() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();   //views
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();   //date 
		driver.findElement(By.xpath("//android.widget.textaview[@content-desc=\"2.Inline\"]")).click();   //Inline
		TouchAction at = new TouchAction(driver);
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));     
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));
		at.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).release().perform();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		  	
		}
	@Test
	public void draganddrop() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();                      //dropdown
		AndroidElement ele3 = driver.findElement(By.id("drag value"));                                      //change value
		AndroidElement ele4 = driver.findElement(By.id("drop value"));                                      //change value
		Thread.sleep(4000);
		TouchAction at = new TouchAction(driver);
		at.longPress(longPressOptions().withElement(element(ele3)).withDuration(ofSeconds(3))).release().perform();  }	
	@Test
	public void sendotp() {
		driver.findElementByAndroidUIAutomator("text\"os\")").click();                       //os            // MESSAGING/OS/VIEWS
		driver.findElementByAndroidUIAutomator("text\"SMS Messaging\")").click();            //sms messaging
		driver.findElement(MobileBy.AccessibilityId("Enabled SMS broadcast receiver")).click();           //checkbox
		driver.findElement(By.id("phone no id value")).sendKeys("9500000059");       
		driver.findElement(By.id("message box id value")).sendKeys("hello");
		driver.hideKeyboard();
		driver.findElement(By.id("Send")).click();		
	driver.activateApp("com.google.android.apps.messaging");            //go to message window
	String dr = driver.findElement(MobileBy.id("hii message id value")).getText();    //hii message
	System.out.println(dr);                        //for console print                                              
	driver.activateApp("io.appium.android.apis");         //back to os messaging page 
}}

