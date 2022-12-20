package testcase.basicclass.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests   implements IRetryAnalyzer {
    int count=0;
	public boolean retry(ITestResult result) {
		if (count<2) {
			count++; //continue the retry
			return true;
		}
		return false;//after 2 stop the retry
	}

}
