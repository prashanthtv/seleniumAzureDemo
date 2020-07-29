package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class HRMSLogin {

WebDriver driver;
@BeforeClass
public void startBrowser()
{

	System.setProperty("webdriver.chrome.driver", "d:\\softwares\\selenium\\chromedriver.exe");
driver= new ChromeDriver();
System.out.println("===========Browser Started==========");
}
//this is a new comment from prashanth
@Test
public void LaunchApp()

{

driver.manage().window().maximize();
driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
String CurrentURL=driver.getCurrentUrl();
Assert.assertTrue(CurrentURL.contains("auth/login"));
System.out.println("App launched");

}

@Test(dependsOnMethods="LaunchApp")
public void login()
{

driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
boolean status=driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).isDisplayed();
Assert.assertTrue(status);
System.out.println("Login to app");
}

@Test(dependsOnMethods="login")
public void logout() throws InterruptedException

{

driver.findElement(By.xpath("//a[@id='welcome']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
boolean logoutconfirm=driver.findElement(By.xpath("//input[@value='LOGIN']")).isDisplayed();
Assert.assertTrue(logoutconfirm);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
System.out.println("Logout of application");

}

@AfterClass
public void closeapp()

{

driver.quit();
System.out.println("====Browser Closed===");
}

}