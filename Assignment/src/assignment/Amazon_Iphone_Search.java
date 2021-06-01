package assignment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Iphone_Search {
	
	
	WebDriver driver;
	JavascriptExecutor js;
	int product_Count = 0;
	
  @Test
  public void f() {
	  
	  driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone");
	  driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  
	  // New Apple iPhone 12 (256GB) - (Product) RED
	  
	//  for(int i = 0)
	  js = (JavascriptExecutor) driver;
	  
	  List<WebElement> Search_Result = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	  
	  for (WebElement  Product_Name : Search_Result) 
	  {
		  String Product = Product_Name.getText();
	      System.out.println(Product);
	      
	      if(Product.contains("Red") && Product.contains("256GB"))
		  {
			  System.out.println("Product Mathed");
			  product_Count = product_Count+1;
			  
			  
		  }
	      else
	      {
	    	  System.out.println("Product NOT Matched");
	      }
	          // Assert.assertEquals(Product, "New Apple iPhone 12 (256GB) - (Product) RED"); 
	      
	  }
	  
	  
	   if(product_Count == 0)
	   {
		  driver.findElement(By.xpath("//a[text()='Next']"));
		  
	   }
	   else
	   { 
		   driver.findElement(By.xpath(null));
	   }
	   
	   
	  
	/*  while(int i != 0)
	  {
		  WebElement Iphone = driver.findElement(By.xpath("//*[text()='New Apple iPhone 12 (256GB) - (Product) RED')")); 
		  js.executeScript("arguments[0].scrollIntoView(true);", element);
	  }
	  
	 */
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();	  
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
