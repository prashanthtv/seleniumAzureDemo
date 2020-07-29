package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {


	WebDriver driver;
	@Test
	public void Google()
	
	{
		
		System.setProperty("webdriver.chrome.driver", "d:\\softwares\\selenium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		System.out.println("Amazon app loaded");
		driver.quit();
	
		
	}
}
