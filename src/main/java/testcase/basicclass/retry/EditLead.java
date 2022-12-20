package testcase.basicclass.retry;


import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class EditLead extends BaseClass {
	
	//It donetes it is test case to run
	@Test
	public void editLead( ) throws InterruptedException {
		getMethod().findElement(By.linkText("Leads")).click();
		getMethod().findElement(By.linkText("Find Leads1")).click();
		getMethod().findElement(By.xpath("//span[text()='Phone']")).click();
		getMethod().findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("86");
		getMethod().findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		getMethod().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		getMethod().findElement(By.linkText("Edit")).click();
		getMethod().findElement(By.id("updateLeadForm_companyName")).clear();
		getMethod().findElement(By.id("updateLeadForm_companyName")).sendKeys("Wipro");
		getMethod().findElement(By.name("submitButton")).click();

	}
}
