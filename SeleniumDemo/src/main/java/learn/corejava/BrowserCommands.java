package learn.corejava;

import org.openqa.selenium.WebDriver;

import learn.lib.SeleniumLib;

public class BrowserCommands {

	public static void main(String[] args) {
		String url="http://www.google.com/";
		WebDriver driver=SeleniumLib.launchBrowser(url);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String source=driver.getPageSource();
		//System.out.println(source);
		
		int len=source.length();
		System.out.println("Source code Lenght:"+len);
		
		//Browser Navigation Commands
		driver.navigate().to("https://www.spicejet.com");
		
		driver.navigate().back();
		//driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		
		driver.close();
		
	}

}
