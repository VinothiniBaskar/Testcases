package javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnJavascript {
    @Test
	public  void learnJavascriptClick() {
		// Set up the driver
				WebDriverManager.chromedriver().setup();

				// disable the notifications in the browser
				// create an object for the class ChromeOptions
				ChromeOptions options = new ChromeOptions();

				// use that object and use the method(addArguments)
				// In that method pass the arguments("disable-notification")
				options.addArguments("disable-notification");

				// pass the object in the constructor of ChromeDriver class
				ChromeDriver driver = new ChromeDriver(options);

				// Lanuch the url
				driver.navigate().to("http://leaftaps.com/opentaps/control/main");
				// Maximize the window
				driver.manage().window().maximize();
				// Give the implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				// enter the username and password
				driver.findElement(By.id("username")).sendKeys("Democsr2");
				driver.findElement(By.id("password")).sendKeys("crmsfa");

				// Click the login button
				WebElement login = driver.findElement(By.className("decorativeSubmit"));
				//Here using javascript to click a web element 
				driver.executeScript("arguments[0].click()",login );
				
				WebElement crmLink = driver.findElement(By.linkText("CRM/SFA"));
				driver.executeScript("arguments[0].click()", crmLink);
				
				//It is used to go back the page
				driver.navigate().back();
				
				WebElement logOut = driver.findElement(By.xpath("//input[@value='Logout']"));
				driver.executeScript("arguments[0].click()", logOut);
				
				driver.close();

	}

}
