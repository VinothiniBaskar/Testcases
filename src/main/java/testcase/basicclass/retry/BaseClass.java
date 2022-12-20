package testcase.basicclass.retry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static final ThreadLocal<RemoteWebDriver> rd=new ThreadLocal<RemoteWebDriver>();
	
	//create a setMethod
	public void setMethod() {
		rd.set(new ChromeDriver());

	}
	//create a get method
	public RemoteWebDriver getMethod() {
		return rd.get();

	}
	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		setMethod();
		getMethod().get("http://leaftaps.com/opentaps/");
		getMethod().manage().window().maximize();
		getMethod().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getMethod().findElement(By.id("username")).sendKeys("DemoSalesManager");
		getMethod().findElement(By.id("password")).sendKeys("crmsfa");
		getMethod().findElement(By.className("decorativeSubmit")).click();
		getMethod().findElement(By.linkText("CRM/SFA")).click();

	}
	@AfterMethod
	public void postCondition() {
		getMethod().close();
	}

}
