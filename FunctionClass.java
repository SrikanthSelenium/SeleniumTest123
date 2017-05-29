package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionClass {
	
	WebDriver driver;
	By link = By.xpath("//a[text()='Gmail']");
	By email = By.id("Email");
	By next = By.id("next");
	By pswd = By.id("Passwd");
	By signin = By.id("signIn");
	
	
	public void openBrowser(String browser)
	{
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				System.setProperty("webdriver.chrome.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver(options);
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}
	public void clickOnBtn() throws InterruptedException
	{
		driver.get("https://www.bankbazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("Alert handled");
//		Actions act = new Actions(driver);
//	//	act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'LOANS')]"))).build().perform();
//		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'LOANS')]"))).moveToElement(driver.findElement(By.xpath("//a[text()='Personal Loan']"))).click().build().perform();
//		System.out.println("clicked on Personal loan");
		WebElement btn = driver.findElement(By.xpath("html/body/div[7]/div[2]/div[1]/div[1]/button"));
		btn.click();
		WebElement btnsbl = driver.findElement(By.xpath("html/body/div[7]/div[2]/div[1]/div[1]/button/following-sibling::ul"));
		List<WebElement> list = btnsbl.findElements(By.tagName("a"));
		for(WebElement list1 : list)
		{
			if(list1.getText().equals("Talk to our help team"))
			{
				list1.click();
				Thread.sleep(2000);
				System.out.println("clicked on " +list1.getText().trim());
			}
		}
		Thread.sleep(3000);
	}
	public void navigateToGmail(String username,String password) throws InterruptedException
	{
		
		driver.get("https://www.bankbazaar.com/home-loan.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		System.out.println("Alert handled");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'LOANS')]"))).build().perform();
		WebElement loans = driver.findElement(By.xpath("html/body/header/nav[1]/ul[1]/li[1]/ul"));
		List <WebElement> loantypes = loans.findElements(By.tagName("a"));
		for(WebElement loantype : loantypes)
		{
			System.out.println(loantype.getText());	
			
		 /*act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'LOANS')]"))).build().perform();
		 if(loantypes.isDisplayed() && loantypes.isEnabled())
			 System.out.println(loantypes.getText());
		 else
			 System.out.println("element is not displayed");*/
		}
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'LOANS')]"))).moveToElement(driver.findElement(By.xpath("//a[text()='Personal Loan']"))).click().build().perform();
		System.out.println("clicked on Personal loan");
			
		/*
		driver.get("https://www.google.co.in/");
		driver.findElement(link).click();
		Thread.sleep(1000);
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(new String[] {username});
		Thread.sleep(1000);
		driver.findElement(next).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(pswd));
		driver.findElement(pswd).clear();
		driver.findElement(pswd).sendKeys(new String [] {password});
		driver.findElement(signin).click();
		*/
	}
	
	

}
