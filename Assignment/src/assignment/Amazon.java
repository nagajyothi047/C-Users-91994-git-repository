package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	

	static WebDriver driver;
	static JavascriptExecutor js;
	static int product_Count = 0;
	
	
	public static void main(String args[]) throws Exception
	{
	   
		Launch_Website();
		product_Search();
		
	}
	
	
	public static void Launch_Website()
	{
		 driver = new ChromeDriver();	  
		 driver.get("https://www.amazon.in");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone");
		 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	
	}
	
	
	public static  void product_Search() throws Exception
	{
		 List<WebElement> Search_Result = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		  
		  for (WebElement  Product_Name : Search_Result) 
		  {
			  String Product = Product_Name.getText();
		      System.out.println(Product);
		      
		      if(Product.contains("New Apple iPhone 12") && Product.contains("256GB"))
			  {
				  System.out.println("Product Mathed");
				  product_Count = product_Count+1;
				
			  }
		      else
		      {
		    	//  System.out.println("Product NOT Matched");
		      }
		       
		      // Assert.assertEquals(Product, "New Apple iPhone 12 (256GB) - (Product) RED"); 
		      
		  }
		  
		  
		  System.out.println("Product Count:   " + product_Count);
		  
		  if(product_Count == 0)
		  {
			  System.out.println("SDAADSDASDASDASDASDASDSDS");
			  WebDriverWait wait = new WebDriverWait(driver,30);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Next']")));
			  //WebElement button = driver.findElement(By.xpath("//a[text()='Next']"));
			  //JavascriptExecutor jse = (JavascriptExecutor)driver;
		        //jse.executeScript("arguments[0].scrollIntoView();", button);
			 //button.click();
			  
			  product_Search(); 

			  
		  }
		  else
		  {

			  System.out.println("Element not present");
		  }

	}

}
		
  
  /*public void Iphone_Product_Search() {
	  
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
	   
*/	
	

