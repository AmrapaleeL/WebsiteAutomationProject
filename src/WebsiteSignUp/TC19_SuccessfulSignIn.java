package WebsiteSignUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC19_SuccessfulSignIn {
	
	public String baseUrl = "https://www.loblaws.ca/";
	public String driverPath = "C:\\Users\\slagade\\Google Drive\\CG backup\\Personal Documents\\Amra\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver ; 
	public String SignIn = "//*[@id=\"site-layout\"]/div[1]/div[3]/div/header/div[2]/div[2]/div/div/div/a";
	public String CreateAccount ="//*[@id=\"__next\"]/div/div/div/a"; 
	public String EmailID = "//*[@id=\"email\"]";
	public String Password = "//*[@id=\"newPassword\"]";
	public String ConfirmPassword = "//*[@id=\"confirmPassword\"]"; 
	public String Terms = "termsAndConditions"; 
	public String Create = "//*[@id=\"create-account\"]/fieldset/button";
	public String Text = "//*[@id=\"root\"]/div/div/h1/span";
	public String email = "abcd111@gmail.com";
	public String pwd1 = "loblaw@123";
	
	
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1)
	public void TC19() {
		driver.findElement(By.xpath(SignIn)).click();
		driver.findElement(By.xpath(CreateAccount)).click();
		driver.findElement(By.xpath(EmailID)).sendKeys(email);
		driver.findElement(By.xpath(Password)).sendKeys(pwd1);
		driver.findElement(By.xpath(ConfirmPassword)).sendKeys(pwd1);
		driver.findElement(By.id(Terms)).click(); 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
		driver.findElement(By.xpath(Create)).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Text))); 
		String VerText = driver.findElement(By.xpath(Text)).getText();
				
		Assert.assertEquals(VerText, "COMPLETE YOUR PROFILE");
	
	}
	
	
	@AfterTest	
	public void CloseBrowser() {
	driver.quit();
	}

}

