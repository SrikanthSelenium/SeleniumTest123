package test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private int maxcount = 2;
		
	@Override
	public boolean retry(ITestResult result) {
	 if(count<maxcount && !result.isSuccess())
	 {
		System.out.println("Going to retry test case: " + result.getMethod() + ", " + count + " out of " + maxcount);
          count++;
          return true; 
	 }
		
		return false;
	}

}
