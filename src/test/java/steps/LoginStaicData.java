package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStaicData extends BaseClassStatic {

	@Given("Enter the username as {string}")
	public void enter_the_username_as(String string) {
		driver.findElement(By.id("username")).sendKeys(string);

	}

	@Given("Enter the password as {string}")
	public void enter_the_password_as(String string) {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	@When("Click on  Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("HomPage should be displayed")
	public void home_page_should_be_displayed() {
		WebElement homePage = driver.findElement(By.linkText("CRM/SFA"));
		homePage.click();
		String title = driver.getTitle();
		if (title.contains("My Home")) {
			System.out.println("Home Page is displyed");
		} else {
			System.out.println("Home Page is  not displyed");

		}
	}

	@But("ErrorMessage should be displayed")
	public void errormsg() {
		String text = driver.findElement(By.xpath("//div[@id='errorDiv']/p")).getText();
		if (text.contains("The Following Errors")) {
			System.out.println("Error msg is displayed");
		} else {
			System.out.println("Error msg is not  displayed");

		}

	}

}