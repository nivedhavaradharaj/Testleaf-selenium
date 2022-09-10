package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBroswer {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main" );
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	String text = driver.findElement(By.tagName("h2")).getText();
	System.out.println(text);
	String title =driver.getTitle();
	 System.out.println(title);
	 driver.findElement(By.linkText("CRM/SFA")).click();
	 driver.findElement(By.linkText("Leads")).click();
	 driver.findElement(By.linkText("Create Lead")).click();
	 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
	 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nivedha");
	 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("varadharaj");
     driver.findElement(By.name("departmentName")).sendKeys("information technology");
     driver.findElement(By.name("description")).sendKeys("Nivedha trainee of Testleaf Organisation,I have completed my assignment-1 from the agenda of the selenium");
     driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("nivevara@gmail.com");
     driver.findElement(By.className("smallSubmit")).click();
     String title1 =driver.getTitle();
    System.out.println(title1);
    driver.close();

    
 
 






	
 	
  }
}
