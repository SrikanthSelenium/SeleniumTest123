package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {

	public static WebDriver d;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/srikanth.chincholi/workspace/JavaSelenium/Drivers/chromedriver_win32/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.google.co.in/webhp?ei=MFXrWOOQCYHvvgSh94sQ&ved=0EKkuCAYoAQ");
		
	}
}
