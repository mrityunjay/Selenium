package learn.corejava;

import org.testng.annotations.Test;

import learn.lib.SeleniumLib;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestNGDemo {
	
  WebDriver driver=null;
  
  @DataProvider(name="google")
  public static String[][] getDataForGoogleSearch(){
	 /* return new String[][]{
		  {"automation","12,75,00,00,000"},
		  {"testing","4,62,00,00,000"},
		  {"manual testing","58,10,00,000"},
		  {"selenium","2,88,00,000"}
	  };*/
	  
	 // Workbook
	  return null;
  }
	
  @Test(dataProvider="google")
  public void demoTest(String searchText,String resultCount) {
	  driver.findElement(By.name("q")).clear();
	  driver.findElement(By.name("q")).sendKeys(searchText);
	  driver.findElement(By.name("q")).submit();
	  driver.quit();
	  String result=driver.findElement(By.id("resultStats")).getText();
	  System.out.println(result);
	  Assert.assertTrue(result.contains(resultCount));
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  driver=SeleniumLib.launchBrowser("https://www.google.co.in/search?q=x");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test Completed");
	  driver.close();
  }

}
