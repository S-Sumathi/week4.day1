package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
		public static void main(String[] args) throws InterruptedException {
			
			//Call WDM for the browser driver
			WebDriverManager.chromedriver().setup();
			
			//Launch the browser
			ChromeDriver driver=new ChromeDriver();
			
			//Load the url
			driver.get("http://leaftaps.com/opentaps/control/login");
			
			//Maximize the browser
			driver.manage().window().maximize();
			
			//Manage timeout
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//Enter the usernmae
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			
			//Enter the password
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
			//Click on submit
			driver.findElement(By.className("decorativeSubmit")).click();
			
			//Click CRM/SFA
			driver.findElement(By.linkText("CRM/SFA")).click();
			
			//Click on Contacts
		    driver.findElement(By.linkText("Contacts")).click();
		    
		    //Click on merge contacts
		    driver.findElement(By.linkText("Merge Contacts")).click();
		    String windowHandle = driver.getWindowHandle();
		    
		    //Click on widget of From contact
		    driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img")).click();
		  
		    //switch to new window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> lstWindow = new ArrayList<String>(windowHandles);
			String secondWindow = lstWindow.get(1);
			driver.switchTo().window(secondWindow);
			
			//Click on first resulting contact
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			
			//To move to first window
			driver.switchTo().window(windowHandle);
			System.out.println(driver.getTitle());
			
			 //Click on widget of To contact
		    driver.findElement(By.xpath("//input[@id='partyIdTo']/following::img")).click();
		    
		    //Switch to new window
			Set<String> windowHandles1 = driver.getWindowHandles();
			List<String> lstWindow1 = new ArrayList<String>(windowHandles1);
			String secondWindow1 = lstWindow1.get(1);
			driver.switchTo().window(secondWindow1);
			
            //Click on Second resulting contact
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
			
			//Move to first window	
			driver.switchTo().window(windowHandle);
			
			//Click on Merge button
			driver.findElement(By.linkText("Merge")).click();
			
			//confirm alert
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			//Get the title of the page
			String title = driver.getTitle();
			if(title.equals("View Lead | opentaps CRM"));
			System.out.println("You are at right page View Lead | opentaps CRM");

	}

}
