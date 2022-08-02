package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {
	
		public static void main(String[] args) throws InterruptedException {
			
			//Call WDM for the browser driver
			WebDriverManager.chromedriver().setup();
			
			//Launch the browser
			ChromeDriver driver=new ChromeDriver();
			
			//Load the url
			driver.get("http://www.leafground.com/pages/Window.html");
			
			//Maximize the browser
			driver.manage().window().maximize();
			
			//Manage timeout
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Click on open home page
			driver.findElement(By.id("home")).click();
			String window1=driver.getWindowHandle();
			System.out.println(window1);
			
			//Handle second window
			Set<String> window =driver.getWindowHandles();
			List<String> listOfWindows=new ArrayList<String>(window);
			String secondWindow=listOfWindows.get(1);
			driver.switchTo().window(secondWindow).close();
			
			//Moving to first window
			driver.switchTo().window(window1);
			
			// Handling Multiple windows
		    driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		    
		    Set<String> manyWindows=driver.getWindowHandles();
		    List<String> listofmanyWindows=new ArrayList<String>(manyWindows);
		    String firstWindow=listofmanyWindows.get(1);
		    String secondWindow1=listofmanyWindows.get(2);
	        
		    driver.switchTo().window(secondWindow1).close();
	        driver.switchTo().window(firstWindow).close();
		  
	        driver.switchTo().window(window1);
	        
			//Wait for 2 new windows to open
	        driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
	        Set<String> newW = driver.getWindowHandles();
			List<String> lstnewW = new ArrayList<String>(newW);
			String newW1 = lstnewW.get(1);
			String newW2 = lstnewW.get(2);
			
			System.out.println("Window1: "+newW1);
			System.out.println("Window2: "+newW2);
			System.out.println("Two new windows opened");
			
			driver.switchTo().window(newW1).close();
			driver.switchTo().window(newW2).close();
		
	}

}
