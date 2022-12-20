package testngassertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSoftAssert {

	@Test
	public void learnAssertion() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		// Matched
		String actualTitle = "Leaftaps - TestLeaf Automation Platform";
		// unMatched
//		String actualTitle = "TestLeaf Automation Platform";
		String title = driver.getTitle();
		// For using same actualTitle and title should be equal the code is executed
		// successfully-->matched and CRM link also clicked
		// For using not actualTitle and title should not be equal still code is
		// executed successfully--> not matched and CRM link also clicked
		// Using If condition the title is not same still the CRM link is clicked and
		// testcase is passed--> It is not correct approach
//		if (title.equals(actualTitle)) {
//			System.out.println("Title is matched");
//
//		} else {
//			System.out.println("Title is not matched");
//
//		}
		// TestNG asserts the tester decides whether the test was successful or not,
		// along with the exceptions.
		// Assertions in TestNG are a way to verify that the expected result and the
		// actual result matched or not.
		// Verification and validation
		// compare the expected and actual result
		// types -->Hard assert and soft assert

		// Soft assert
		// Create an object SoftAssert class using that object we can access the methods
		// mandatory to use in the last step obj.assertAll()
		// It is proceed the CRM link and testcase failed and exception get
		// (java.lang.AssertionError)
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, title);
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		sa.assertTrue(displayed);// expects True;If it is found true-->pass;If it is found false-->fail
		driver.findElement(By.linkText("CRM/SFA")).click();
		// mandatory to use in the last step obj.assertAll()
		sa.assertAll();

		// Difference between Hard assertion and Soft Assertion

		// Hard assertion -->In the Hard assertion even though the assertion statement is failed the rest of the statements will not execute.
		//Soft assertion-->In case of soft assertion even though the assertion statement is failed the rest of the statements will be contiued.

	}
}