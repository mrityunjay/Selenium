package learn.corejava;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCommandAndScreenshot {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrityunjay\\selenium_learn\\chromedriver.exe");
		
		
		//Create chrome driver object, launch chrome browser
		ChromeDriver driver= new ChromeDriver();
		String url="http://www.spicejet.com/";
		driver.get(url);
		
		By by=By.xpath(".//span[contains(text(),'Hotels')]");
		
		String x=new String("Hello");
		
		WebElement hotelTab=driver.findElement(by);
		String hotelClassName=hotelTab.getAttribute("class");
		String style=hotelTab.getAttribute("style");
		
		System.out.println(hotelClassName);
		System.out.println(style);
		
		String color=hotelTab.getCssValue("color");
		System.out.println(color);
		//driver.findElements(by)
		
		driver.findElement(By.xpath(".//input[@value='Departure City']")).click();
		//WebElement listOfCity=driver.findElement(By.xpath(".//input[@value='Departure City']"));
		File screenshotFile=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("city.jpg"));
		} catch (IOException e) {
			System.out.println("An excpetion has occured while saving the screenshot");
		}
		driver.close();

	}
	
	public static void printLength(String x) {
		System.out.println(x.charAt(3));
	}

}
