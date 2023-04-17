package WebApp;


import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Webcapability extends Webcapabilities {
private static final RemoteWebDriver Links = null;
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void eat() throws MalformedURLException {
		driver = capa1();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
	@Test
	public void web() throws InterruptedException {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@class='q']")).sendKeys("Moolyaed");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		List<AndroidElement> links = driver.findElements(By.tagName("a"));   //a tagname
				links.size();
				System.out.println(links.size());//no.of link
				for(int i=0;i<links.size();i++);
				Thread.sleep(4000);
				
				System.out.println(links.get(i).getText());//text of links
				Thread.sleep(4000);
				System.out.println(links.get(i).getAttribute("href"));  //href links
				AndroidElement linkedin = driver.findElement(By.xpath("//a[@href='https://in.linkedin.com/company/moolyaed\']"));
				linkedin.click();
	}
}
