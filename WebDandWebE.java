package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDandWebE {
	
	static WebDriver driver;
	
	
		//System.setProperty("webdriver.ie.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/IEDriverServer.exe");
	
	
	
	public static void main(String[] args) {
		
		//WebDandWebE waw = new WebDandWebE();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\srikanth.chincholi\\workspace\\JavaSelenium\\Drivers\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\srikanth.chincholi\\workspace\\JavaSelenium\\Drivers\\chromedriver.exe");
		
	//	driver = new ChromeDriver();
		driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		WebElement mail = driver.findElement(By.linkText("Gmail"));
		Actions act = new Actions(driver);
		act.moveToElement(mail).sendKeys(Keys.chord(Keys.CONTROL,"t")).build().perform();
	//	act.sendKeys(mail,Keys.chord(Keys.CONTROL,"t"));
		/*Set <String> s = driver.getWindowHandles();
				for(String f : s)
		{
			System.out.println(f);
		}
	*/
	}
	

}
