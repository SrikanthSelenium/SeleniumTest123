package test;


import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class MainClass {
	
	 private FunctionClass functionclass;
	 
	@Parameters({"browser"})		
	@BeforeTest
	public void setup(@Optional("chrome") String browser)
	{
		functionclass = new FunctionClass();
		functionclass.openBrowser(browser);
	}
	
	
	@Test//(retryAnalyzer=RetryAnalyzer.class)
	public void openGmail() throws InterruptedException
	{
		//functionclass.navigateToGmail("srikanth.chincholi@gmail.com","Srikanth@kk4242");
		functionclass.clickOnBtn();
	}
	
	
	@AfterTest
	public void teardown()
	{
		functionclass.driver.quit();
	}

}
