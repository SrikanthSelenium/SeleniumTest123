package test;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SampleTest {
	
	private WebDriver driver;
	String baseURL = "http://www.google.com/";
		
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) 
	{
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void login_Test() throws Throwable
	{
		try
		{
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement link = driver.findElement(By.xpath("//a[text()='Gmail']"));
		link.click();
		WebElement uid = driver.findElement(By.id("Email"));
		uid.clear();
		uid.sendKeys(new String[] {"srikanth.chincholi@gmail.com"});
		Thread.sleep(1000);
		driver.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		WebElement pwd = driver.findElement(By.id("Passwd"));
		pwd.clear();
		pwd.sendKeys(new String [] {"Srikanth@kk4242"});
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.id("signIn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//div/a/span[@class='gb_9a gbii']"))));
		driver.findElement(By.xpath("//div/a/span[@class='gb_9a gbii']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//a[contains(text(),'Sign out')]"))));
		WebElement signout = driver.findElement(By.xpath("//a[contains(text(),'Sign out')]"));
		signout.click();
		Thread.sleep(10000);
		getScreen();
		System.out.println("Signed Out Success");
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
		
	}
	
	public void getScreen() throws Exception
	{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:\\Users\\test.png"));
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver.quit();
	}

	
	}


	  
		
