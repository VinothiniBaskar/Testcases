package testngassertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHardAssertion {

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
		//Matched
		String actualTitle = "Leaftaps - TestLeaf Automation Platform";
		//unMatched
//		String actualTitle = "TestLeaf Automation Platform";
		String title = driver.getTitle();
		//For using same actualTitle and title should be equal the code is executed successfully-->matched and CRM link also clicked
		//For using not  actualTitle and title should  not be equal still code is executed successfully--> not matched and CRM link also clicked
		//Using If condition the title is not same still the CRM link is clicked and testcase is passed--> It is not correct approach
//		if (title.equals(actualTitle)) {
//			System.out.println("Title is matched");
//
//		} else {
//			System.out.println("Title is not matched");
//
//		}
		//TestNG asserts the tester decides whether the test was successful or not, along with the exceptions.
		//Assertions in TestNG are a way to verify that the expected result and the actual result matched or not.
		//Verification and validation
		//compare the expected and actual result
		//types -->Hard assert and soft assert
		
		//Hard assert -->Mostly we are using Hard assert
		//If the assert comment is failed rest of the statements is not executed
		//Assert is a static method --> We can directly acess the method(assertEquals) by using Assert class
		//java.lang.AssertionError: expected [Leaftaps - TestLeaf Automation Platform] but found [TestLeaf Automation Platform]
		//It does not proceed with next line -->Crm link is not clicked and testcase also failed -->Correct approach
		//assetEquals is used to verify the expected result and actual result
		Assert.assertEquals(actualTitle, title);//When give the wrong title the execution will be stopped this line and does not click the CRM link
		                                        //testcase will failed
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		//assertTrue(condition) : This method asserts if the condition is true or not. If not, then the exception error is thrown. 
		//Assert. assertTrue(condition, message) : Similar to the previous method with an addition of message, which is shown on the console when the assertion fails along with the exception.
		Assert.assertTrue(displayed);//expects True;If it is found true-->pass;If it is found false-->fail
		
		//assertFalse is used to verify if a given Boolean condition is false. 
		//In other words, the return type of the given Boolean condition should be False.
		//This assertion passes if the specified condition has a FALSE return type if not, an assertion error is thrown
		Assert.assertFalse(displayed);//expects False;If it is found false(By.linkText("CRM/SFA1")).isDisplayed())-->pass;If it is found true()By.linkText("CRM/SFA")).isDisplayed()-->fail

		driver.findElement(By.linkText("CRM/SFA")).click();
		

	}
}
