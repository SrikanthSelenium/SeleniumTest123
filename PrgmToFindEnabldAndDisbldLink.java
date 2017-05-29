package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PrgmToFindEnabldAndDisbldLink {
	static WebDriver d;
	public static void main(String[] args) throws InterruptedException 
	{
	
		int enabled = 0, disabled = 0;
		System.setProperty("webdriver.chrome.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/chromedriver_win32/chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.google.com");
		d.manage().window().maximize();
		Actions act = new Actions(d);
		WebElement search = d.findElement(By.name("q"));
		search.sendKeys("srikanth");
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		List <WebElement> list = d.findElements(By.tagName("a"));
		for(WebElement list1 :list)
		{
			if(list1.isDisplayed() && list1.isEnabled())
			{
			//	System.out.println("Element is enabled and displayed");
				System.out.println(list1.getText());
				enabled ++;
			}
			else
			{
				//System.out.println("Elements are disabled");
				System.out.println(list1.getText());
				disabled++;
			}
		}
		
		System.out.println(enabled+"       " +disabled);
	
		
	}
}
