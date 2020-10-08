package WebsiteSignUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC18_UnsuccessfulSignIn {
	
	public String baseUrl = "https://www.loblaws.ca/";
	public String driverPath = "resources\\chromedriver.exe";
	public WebDriver driver ; 
	
	public String SignIn = "//*[@id=\"site-layout\"]/div[1]/div[3]/div/header/div[2]/div[2]/div/div/div/a";
	public String CreateAccount ="//*[@id=\"__next\"]/div/div/div/a"; 
	public String Create = "//*[@id=\"create-account\"]/fieldset/button";

	public String EmailLocator = "//*[@id=\"email__error\"]/span";
	public String PwdLocator ="//*[@id=\"newPassword__error\"]/span"; 
	public String ConfirmPwdLocator = "//*[@id=\"confirmPassword__error\"]/span";
		
	public String EmailExpText = "Please enter an email address.";
	public String PwdExpText ="Please enter a password."; 
	public String ConfirmPwdExpText = "Please confirm your password.";
		
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1)
	public void TC18() {
	
		driver.findElement(By.xpath(SignIn)).click();
		driver.findElement(By.xpath(CreateAccount)).click();
		driver.findElement(By.xpath(Create)).click();
		String EmailActualText = driver.findElement(By.xpath(EmailLocator)).getText();
		String PwdActualText = driver.findElement(By.xpath(PwdLocator)).getText();
		String ConPwdActualText = driver.findElement(By.xpath(ConfirmPwdLocator)).getText();
		
		Assert.assertEquals(EmailActualText, EmailExpText);
		Assert.assertEquals(PwdActualText, PwdExpText);
		Assert.assertEquals(ConPwdActualText, ConfirmPwdExpText);
	
	}
	
	
	@AfterTest	
	public void CloseBrowser() {
	driver.quit();
	}

}

