package snapdeal;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions builder = new Actions(driver);
//			2. Go to Mens Fashion
		WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
//			3. Go to Sports Shoes
		WebElement sport = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));

		try {
			builder.moveToElement(mens).click(sport).perform();
		} catch (Exception e1) {
			wait.until(ExpectedConditions.visibilityOf(mens));
		}
//		    4. Get the count of the sports shoes
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(text);

//			5. Click Training shoes
		WebElement ts = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		try {
			ts.click();
		} catch (Exception e1) {
			wait.until(ExpectedConditions.elementToBeClickable(ts));
		}
		// Thread.sleep(10000);
//			6. Sort by Low to High
		WebElement sort = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		try {
			sort.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(sort));
			sort.click();
		}
		// Thread.sleep(3000);
		WebElement li = driver.findElement(By.xpath("(//li[@class='search-li'])[1]"));
		try {
			li.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(li));
			li.click();
		}
//		7. Check if the items displayed are sorted correctly

		List<Integer> list = new ArrayList<Integer>();

		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		for (WebElement each : findElements) {

			String text2 = each.getText();
			wait.until(ExpectedConditions.stalenessOf(each));
			String replaceAll = text2.replaceAll("[^0-9]", "");
			list.add(Integer.parseInt(replaceAll));
//			

			System.out.println(list);

			Set<Integer> set = new TreeSet<Integer>(list);
			System.out.println(set);
//		8.Select the price range (900-1200)
			WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
			fromVal.clear();
			fromVal.sendKeys("900");
			WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
			toVal.clear();
			toVal.sendKeys("1200");
//		9.Filter with color Navy 
			driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
//		11. Mouse Hover on first resulting Training shoes

			WebElement findElement = driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
			builder.moveToElement(findElement).perform();
//		12. click QuickView button
			WebElement quickView = driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
			try {
				quickView.click();
			} catch (StaleElementReferenceException e) {

				wait.until(ExpectedConditions.stalenessOf(quickView));
				driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
			} catch (ElementClickInterceptedException e2) {
				wait.until(ExpectedConditions.elementToBeClickable(quickView));

			}

//		13. Print the cost and the discount percentage
			WebElement price = driver.findElement(By.xpath("//div[@class='lfloat']"));
			try {

				price.getText();
			} catch (Exception e) {
				wait.until(ExpectedConditions.visibilityOf(price));
				System.out.println(price);
			}

//		14. Take the snapshot of the shoes.
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Snaps/snapdeal.png");
			FileUtils.copyFile(source, destination);
//		15. Close the current window
//		driver.close();
			// driver.quit();

		}
	}
}
