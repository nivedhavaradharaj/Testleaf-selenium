package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
 import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
public static void main(String[] args) throws InterruptedException, IOException {
	
	//01) Launch Firefox / Chrome
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();

	//02) Load https://www.redbus.in/
	driver.get("https://www.redbus.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(3000);
	//03) Type "Chennai" in the FROM text box 
	WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
	from.sendKeys("Chennai");
	driver.findElement(By.xpath("//li[@class='selected']")).click();
	from.sendKeys(Keys.TAB);
 //hint: Sendkeys(Keys.ENTER)
	//04) Type "Bangalore" in the TO text box
	WebElement to = driver.findElement(By.id("dest"));
	to.sendKeys("Bangalore");
	driver.findElement(By.xpath("//li[@class='selected']")).click();
	to.sendKeys(Keys.TAB);
//05) Select tomorrow's date in the Date field
    driver.findElement(By.xpath("//label[text()='Date']")).click();
    driver.findElement(By.xpath("//td[@class='wd day']")).click();
	//06) Click Search Buses
    driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
	//07) Print the number of buses shown as results (104 Buses found)
	String noofbusesdetails = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
	System.out.println(noofbusesdetails);
	//08) Choose SLEEPER in the left menu 
    Thread.sleep(3000);
    WebElement sleeper = driver.findElement(By.xpath("//label[@for='bt_SLEEPER'][1]"));
 //09) Print the name of the second resulting bus 
	String nameofsecbus = driver.findElement(By.xpath("(//div[contains(@class,'travels lh-24')])[2]")).getText();
	System.out.println(nameofsecbus);
    Thread.sleep(3000);
//10) Click the VIEW SEATS of that bus
    driver.findElement(By.xpath( "(//div[text()='View Seats'])[2]" )).getText();
    	//11) Take screenshot and close browser
	 File source = driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./snaps/screenshort.png");
	FileUtils.copyFile(source, dest);
	driver.close();

 	
}
}
