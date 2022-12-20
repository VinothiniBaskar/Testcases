package servicenow.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNowApplication {

	@Test
	public void serviceNow() throws InterruptedException {
		//Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev137890.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		//Login with valid username and password
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Testleaf@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		//Click All
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		
		shadow.setImplicitWait(20);
		//Click Incidents in Filter Navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		
		//find the iframe and come out from the iframe
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Main Content']"));
		driver.switchTo().frame(frame);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is :"+incidentNumber);
		
		
		WebElement incidentSDesc = driver.findElement(By.xpath("//input[@id='incident.short_description']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(incidentSDesc).perform();
		incidentSDesc.sendKeys("Automation Testing");
		
		
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit'][1]"));
		builder.moveToElement(submit).click().perform();
		driver.switchTo().defaultContent();

//			//To get the console                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
//			//F12

	}

}
