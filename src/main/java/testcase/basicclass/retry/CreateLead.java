package testcase.basicclass.retry;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	//Method 1:Using the retryAnalyzer attribute we can retry the testcases
	@Test(retryAnalyzer=testcase.basicclass.retry.RetryFailedTests.class)
	public void createLead() {
		getMethod().findElement(By.linkText("Leads1")).click();
		getMethod().findElement(By.linkText("Create Lead")).click();
		getMethod().findElement(By.id("createLeadForm_companyName")).sendKeys("TVS");
		getMethod().findElement(By.id("createLeadForm_firstName")).sendKeys("Vino");
		getMethod().findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		getMethod().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("86");
		getMethod().findElement(By.name("submitButton")).click();
	}

}
