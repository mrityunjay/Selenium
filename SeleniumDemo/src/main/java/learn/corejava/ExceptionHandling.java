package learn.corejava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import learn.lib.SeleniumLib;

public class ExceptionHandling {

	public static void main(String[] args) {
		ChromeDriver driver=(ChromeDriver)SeleniumLib.launchBrowser("https://www.mortgagecalculator.org/");
		
		try {
			driver.findElement(By.xpath(".//*[@id='toggle_pie1']")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("Unable to click on pie chart");
		}
		catch(Exception e) {
			System.out.println("Unknow error occurred"+e.getMessage());
		}
		
		boolean b=driver.findElement(By.xpath(".//*[@id='toggle_pie']")).isDisplayed();
		System.out.println(b);
		/*
		List<WebElement> link=driver.findElements(By.xpath(".//*[@id='toggle_pie']"));
		if(link.size()==0) {
			System.out.println("Link does not present.");
		}else {
			link.get(0).click();
			
		}*/
			
		
		System.out.println("Test Completed");
	}

}
