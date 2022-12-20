package flipcart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipCartApplication {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable=notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[text()='Get access to your Orders, Wishlist and Recommendations']/following::input"))
				.sendKeys("8610084950");
		driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']/following::input"))
				.sendKeys("Vinoqueen@123");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		Actions builder = new Actions(driver);
		WebElement fashion = driver.findElement(By.xpath("//img[@src='https://rukminim1.flixcart.com/flap/128/128/image/c12afc017e6f24cb.png?q=100']"));
		builder.moveToElement(fashion).perform();

	}
	
}
