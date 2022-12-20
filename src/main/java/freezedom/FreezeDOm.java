package freezedom;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreezeDOm {

	public static void main(String[] args) {
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
		driver.navigate().to("https://www.flipkart.com/");
		// Maximize the window
		driver.manage().window().maximize();
		// Give the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//div[text()='Fashion']

	}

}
