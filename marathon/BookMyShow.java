package marathon;

import java.io.File;
import java.io.IOException;
 import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
	
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//03) Type the city as "Hyderabad" in Select City

		driver.findElement(By.xpath("//input[@class='sc-jvEmr elijMA']")).sendKeys("Hyderabad");;
		driver.findElement(By.xpath("//span[@class='sc-fihHvN fUfZof']")).click();
		Thread.sleep(2000);
		//04) Confirm the URL has got loaded with Hyderabad 

		String url = driver.getCurrentUrl();
		System.out.println(url);
		if(url.contains("hyderabad"))
		{
			System.out.println("The URL loaded correctly");
		}
		//05) Search for your favorite movie 

		driver.findElement(By.xpath("(//div[@id='2']//span)[2]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ponniyin Selvan - Part 1");
		//06) Click Book Tickets

		driver.findElement(By.xpath("(//span[@font-size='14px'])[1]")).click();
		driver.findElement(By.xpath("(//button[@data-phase='postRelease']//div)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='2D'])[2]")).click();
		//07) Print the name of the theater displayed first

		WebElement disptheatreName = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]"));
		System.out.println(disptheatreName.getText());
		//08) Click on the info of the theater

		driver.findElement(By.xpath("(//img[@class='venue-info-icon lazy'])[1]")).click();
		//09) Confirm if there is a parking facility in the theater
		String parkingintheater = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']")).getText();

 		if(parkingintheater.contains("Parking Facility"))
		{
			System.out.println("Parking Facility is Available");
		}
		else
		{
			System.out.println("Parking Facility is not Available");
		}
		//10) Close the theater popup//11) Click on the first green (available) timing


		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("(//div[@class='__text'])[3]")).click();
		//12) Click Accept

		driver.findElement(By.id("btnPopupAccept")).click();
		driver.findElement(By.xpath("//li[text()='1']")).click();
		//13) Choose 1 Seat and Click Select Seats

		driver.findElement(By.xpath("//div[text()[normalize-space()='Select Seats']]")).click();
		//14) Choose any available ticket and Click Pay

		driver.findElement(By.xpath("(//a[@class='_available'])[2]")).click();
		driver.findElement(By.xpath("(//a[@id='btmcntbook'])[1]")).click();
		//15) Print the sub total

		String price = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
		System.out.println(price);
		//16) Take screenshot and close browser
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/screenshort.png");
		FileUtils.copyFile(source, dest);
}

}
