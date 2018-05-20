package learn.corejava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTabs {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrityunjay\\selenium_learn\\chromedriver.exe");	
		
		//Create chrome driver object, launch chrome browser
		ChromeDriver driver= new ChromeDriver();
		String url="http://www.spicejet.com/";
		driver.get(url);
		
		List<WebElement> tabs=driver.findElements(By.xpath(".//span[@class='text-label']"));
		
		// for, while, do-while, for-each
		String tabName="";
		boolean flag=false;
		for(int i=0;i<tabs.size();i++) {
			WebElement temp=tabs.get(i);
			tabName=temp.getText();
			if(tabName.trim().equals("Holiday Packages")) {
				flag=true;
				break;
			}
			
		}
		if(flag) {
			System.out.println("Holiday packages tab is available");
		}else {
			System.out.println("Holiday packages tab doesn't exist");
		}
		//System.out.println(tabName);
		driver.close();
	}

}
