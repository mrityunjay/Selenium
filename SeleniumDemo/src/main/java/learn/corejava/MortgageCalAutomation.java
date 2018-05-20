package learn.corejava;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import learn.lib.SeleniumLib;

public class MortgageCalAutomation {

	public static void main(String[] args) {
		ChromeDriver driver=(ChromeDriver)SeleniumLib.launchBrowser("https://www.mortgagecalculator.org/");
		
		WebElement homeValue=driver.findElement(By.id("homeval"));
		homeValue.clear();
		homeValue.sendKeys("1000");
		
		driver.findElement(By.name("param[downpayment]")).sendKeys("10");
		
		WebElement radio=driver.findElement(By.xpath(".//input[@value='percent']"));
		if(!radio.isSelected())
			radio.click();

		WebElement startDate=driver.findElement(By.name("param[start_month]"));
		
		Select selectDate=new Select(startDate);
		
		Date d=new Date();
		String temp=d.toString();
		
		
		
		selectDate.selectByVisibleText(temp.split(" ")[1]);
		//selectDate.selectByValue("4");
		//selectDate.selectByIndex(6);
		
		List<WebElement> months=selectDate.getOptions();
		
		for(WebElement m:months) {
			System.out.println(m.getText());
		}
		
		driver.findElement(By.name("cal")).submit();
		WebElement result=driver.findElement(By.xpath("(.//div[@class='rw-box']/div/h3)[1]"));
		String PMI=result.getText();
		System.out.println(PMI);
		
		Point p=result.getLocation();
		System.out.println("("+p.getX()+","+p.getY()+")");
	
		Dimension dm=result.getSize();
		System.out.println("Height:"+dm.getHeight());
		System.out.println("Width:"+dm.getWidth());;

		
		
	}

}
