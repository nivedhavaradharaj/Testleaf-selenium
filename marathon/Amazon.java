package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
public static void main(String[] args) throws InterruptedException, IOException {
	//Testcase 1 (Amazon)
	//01) Launch Chrome
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	//02) Load https://www.amazon.in/
	driver.get("https://www.amazon.in");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(3000);
	//03) Type "Bags" in the Search box
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
	//04) Choose the displayed item in the result with bags for boys
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()=' for boys']")).click();
	//05) Print the total number of results (like 30000)
			   // 1-48 of over 30,000 results for "bags for boys"
	String totalitems = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']")).getText();
	String[] split = totalitems.split(" ");
	System.out.println(split[4]);
	
	//06) Select the first 2 brands in the left menu
	    //(like American Tourister, Generic)
   driver.findElement(By.xpath("//span[text()='See more']")).click();
	driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')]//i)[3]")).click();
  driver.findElement(By.xpath("//li[@id='p_89/Generic']/span[1]/a[1]/div[1]/label[1]")).click();
	//07) Confirm the results have got reduced like 5000 &30,000     (use step 05 for compare)
  String total1 = driver.findElement(By.xpath("//span[text()='1-48 of over 5,000 results for']")).getText();
  if(totalitems.equals(total1)) {
	  System.out.println("NOT REDUCED");
  }
	  else {
		  System.out.println("REDUCED");
	  } 
	//08) Choose New Arrivals (Sort)
  driver.findElement(By.xpath("//span[text()='Featured']")).click();
  driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	//09) Print the first resulting bag info (name, discounted price)
	driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']//div")).click();
   Set<String> windows1 = driver.getWindowHandles();
	ArrayList<String> list1 = new ArrayList<String>(windows1);
	driver.switchTo().window(list1.get(1));
 	String bag = driver.findElement(By.id("productTitle")).getText();
	System.out.println("Bag Name:"+bag);
	System.out.println(driver.findElement(By.className("a-price-whole")).getText());
//10) Take screenshot and close
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./snaps/screenshort.png");
	FileUtils.copyFile(source, dest);
	driver.close();

 
}

}