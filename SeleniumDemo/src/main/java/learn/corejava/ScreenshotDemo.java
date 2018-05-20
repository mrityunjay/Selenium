package learn.corejava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static learn.lib.SeleniumLib.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver=launchBrowser("https://www.oracle.com");
		//SeleniumLib.takeScreenshot("./screenshot/ScreenshotUsingJava.jpg");
		//SeleniumLib.takeScreenshot((ChromeDriver) driver, "./screenshot/ScreenshotUsingSelenium.jpg");
		
		//Hardcode wait
		waitForMe(4);
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Explicit wait or wait for conditions
		//.//span[text()='Call']
		
		WebDriverWait w=new WebDriverWait(driver, 30);
		WebElement callButton=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[text()='Call']")));
		callButton.click();
		
		
		
		driver.findElement(By.id("txtSearch")).sendKeys("Selenium");
		driver.findElement(By.id("txtSearch")).submit();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("Integrated Web Testing with Selenium")).click();
		
		String currentWidnow=driver.getWindowHandle();
		
		Set<String> listOfWindows=driver.getWindowHandles();
		
		for(String temp:listOfWindows) {
			if(!temp.equals(currentWidnow)) {
				driver.switchTo().window(temp);
				break;
			}
		}
		
		driver.findElement(By.xpath("(.//ul[@class='level01']/li/a)[1]")).click();
		
		//driver.close();
		
		driver.switchTo().defaultContent();
		
		
		
	}

}