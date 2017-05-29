package test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertClass {
	static WebDriver d;
	@Test
	public void alertTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/chromedriver_win32/chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	WebDriverWait wait = new WebDriverWait(d, 10);
//		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(".//*[@id='content']/p[4]/button"))));
//		WebElement ele = d.findElement(By.xpath("//div//button[@onclick='pushAlert()']"));
//		ele.click();
		
//		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div//button[@onclick='pushConfirm()']"))));
//		WebElement ele = d.findElement(By.xpath("//div//button[@onclick='pushConfirm()']"));
//		ele.click();
//		Alert a  = d.switchTo().alert();
//		Thread.sleep(5000);
//		a.dismiss();
		
	//	wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div//button[@onclick='promptConfirm()']"))));
		WebElement ele = d.findElement(By.xpath("//div//button[@onclick='promptConfirm()']"));
		((JavascriptExecutor)d).executeScript("arguments[0].click()",ele);
		//ele.click();
		Alert a  = d.switchTo().alert();
		d.switchTo().alert().sendKeys("erere");
		System.out.println(a.getText());
		Thread.sleep(5000);
		a.accept();
		d.quit();
		
		
		
			
		
	}

}
