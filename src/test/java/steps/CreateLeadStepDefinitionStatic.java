package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadStepDefinitionStatic extends BaseClassStatic {


	@Given("Click Leads Button")
	public void clickLeads() {
		driver.findElement(By.linkText("Leads")).click();
	}
	@And("Click CreateLead link")
	public void clickCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	@When("Enter the companyName as (.*)$")
	public void enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	
	@And("Enter the firstName as (.*)$")
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	@And("Enter the LastName as (.*)$")
	public void enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	}
	
	@When("Click on the CreateLeads Button")
	public void clickCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	@Then("View Lead page is displayed")
	public void viewLeadPage() {
		boolean viewPage=driver.findElement(By.name("submitButton")).isDisplayed();
		if (viewPage) {
			System.out.println("View Lead is displayed");
		}
		else {
			System.out.println("View Lead is  not displayed");

		}
	}

}