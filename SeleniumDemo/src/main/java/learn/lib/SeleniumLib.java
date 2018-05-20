package learn.lib;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLib {
	
	public static WebDriver launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrityunjay\\selenium_learn\\chromedriver.exe");			
		//Create chrome driver object, launch chrome browser
		ChromeDriver driver= new ChromeDriver();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver launchBrowser(String url, String browserName) {
		
		return null;
	}
	
	public static void takeScreenshot(ChromeDriver driver,String fileName) {
		File screenshotFile=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(fileName));
		} catch (IOException e) {
			System.out.println("An excpetion has occured while saving the screenshot");
		}
	}
	
	public static void takeScreenshot(String fileName) {
		Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try {
			Robot r=new Robot();
			BufferedImage image=r.createScreenCapture(rect);
			File output=new File(fileName);
			boolean flag=ImageIO.write(image, "jpg", output);
			if(flag) {
				System.out.println("Image saved successfully");
			}else {
				System.out.println("An error occured during screenshot creation");
			}
		} catch (AWTException e) {
			System.out.println("Not able to create robot class object");
		}catch(IOException e) {
			System.out.println("Exception occured during file save");
		}
	}
	
	public static void waitForMe(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
