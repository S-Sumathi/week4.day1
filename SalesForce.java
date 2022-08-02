package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {
	
		public static void main(String[] args) throws InterruptedException {
			
			//Call WDM for the browser driver
			WebDriverManager.chromedriver().setup();
			//Handle Browser Notifications
			ChromeOptions options=new ChromeOptions();
			
			//Notifications
			options.addArguments("--disable-notifications");
			
			//Launch the browser
			ChromeDriver driver=new ChromeDriver();
			
			//Load the url
			driver.get("https://login.salesforce.com/");
			
			//Maximize the browser
			driver.manage().window().maximize();
			
			//Manage timeout
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Enter the usernmae
			driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
			
			//Enter the password
			driver.findElement(By.id("password")).sendKeys("Password$123");
			
			//Click on submit
			driver.findElement(By.id("Login")).click();
			Thread.sleep(30000);
			
			//Click on Learn More
			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			String windowHandle = driver.getWindowHandle();
			
			//New Window
			Set<String> windowHandles=driver.getWindowHandles();
			List<String> listWindow=new ArrayList<String>(windowHandles);
			String secondWindow=listWindow.get(1);
			driver.switchTo().window(secondWindow);
			
		   //Click on confirm and Get title of the page
		   driver.findElement(By.xpath("//button[text()='Confirm']")).click();	
		   
		   String title=driver.getTitle();
		   System.out.println("The title of the new window is "+ title);
		   
		  //Switch to parent window
		   driver.switchTo().window(windowHandle);
		   //Closing the window
		   driver.close();
			
	}

}
