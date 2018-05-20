package learn.corejava;

import static learn.lib.SeleniumLib.launchBrowser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertAndFrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	WebDriver driver=launchBrowser("http://www.seleniumframework.com/Practiceform/");
	driver.findElement(By.id("alert")).click();
	
	Alert alert=driver.switchTo().alert();
	String alertText=alert.getText();
	System.out.println(alertText);
	alert.accept();
	
	driver.findElement(By.name("name")).sendKeys("Selenium");
	
	driver.switchTo().frame(0);
	//adfasdfasdf
	driver.switchTo().defaultContent();
	
	
	
	}

}
