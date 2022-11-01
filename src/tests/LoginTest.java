package tests;

import org.testng.annotations.Test;



import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	//WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  lp.OpenBrowser();
	  lp.openLoginPage();
	 // System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
	  //driver = new FirefoxDriver();
	  //driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qjhCJuRZoS4&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoicWpoQ0p1UlpvUzQiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTI1MzYwMywiaWF0IjoxNjU1MjUyNDAzLCJqdGkiOiJiNGJmYjZiZi0xNDNhLTQ5NGUtOTZjZC0yZTFiNjViMTE2MmEiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.ezSbETD4jllYkOSpxiKuJLErWjglianS1MCmfY-a6bchRNiH7sog-s-EfTAAk6gtzhlaKDTJWe6JBGJb7NbX6s4f6hkBC2oaVaC1THwNFqdEUODX_ekYKfGcFnwBVQBwhVLVdSPR4HqTdmx0wwSDk1GWMvKq71eBWZCr-Y9lrkq-rvw2nrT_t4wcM5gQTL5bLXsf1yV8zQrazkNlbJuOOCMyXMlqP-v58gPBfrbcCtN9OD2G2qIgBnBNk4TvVVnBKcDXd4ac9-32eseqK7vpqdo9yqGE_gN2NSOkZsFthvwlcclqnZ-HdtgwD6YX1XBTE-V6VpNUfHz5ooSOaRTTJg&preferred_environment=");
		
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
	 // driver.quit();
  }
  
  @Test(priority = 1)
  public void loginEmailWithSpecialCharTest() {
	  
	  	lp.Login(df.emailwithspecialchar,df.wrongpassword);
	  //	driver.findElement(By.id("usernameInput-input")).sendKeys("dbdjbwihbwcb%$sj");
	  //	driver.findElement(By.id("password-input")).sendKeys("sxfwywjhbxj");
	//	driver.findElement(By.id("signIn")).click();
		
	
		
		String expectederrormsg = df.specialcharerr;//"Please enter a username or card number without special characters.";
		String actualerrormsg = lp.readEmailErr();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		
		 //System.out.println(actualerrormsg);
		
		Assert.assertEquals(expectederrormsg, actualerrormsg);

  }
  
  @Test (priority = 2)
  public void loginWithEmptyEmailTest() {
	  
	  lp.Login("",df.wrongpassword);
	  //	driver.findElement(By.id("usernameInput-input")).sendKeys("dbdjbwihbwcb%$sj");
	  	//driver.findElement(By.id("password-input")).sendKeys("sxfwywjhbxj");
		//driver.findElement(By.id("signIn")).click();
		
	
		
		String expectederrormsg = df.emptyemailerr;
		String actualerrormsg = lp.readEmailErr();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		
		// System.out.println(actualerrormsg);
		
		Assert.assertEquals(expectederrormsg, actualerrormsg);

  }
  
  @Test(priority = 3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  
	  lp.Login(df.wrongemail,"");
	  //driver.findElement(By.id("usernameInput-input")).sendKeys("dbdjbwihbwcbsj");
	  	//driver.findElement(By.id("password-input")).sendKeys("sxfwywjhbxj");
		//driver.findElement(By.id("signIn")).click();
		
	
		//Thread.sleep(2000);
		String expectederrormsg = df.emptypassworderr;
		String actualerrormsg = lp.readPasswordErr();//driver.findElement(By.id("PasswordTextField__errors-password")).getText();
		
		// System.out.println(actualerrormsg);
		
		Assert.assertEquals(expectederrormsg, actualerrormsg);

  }
  
  @Test (priority = 4)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	  
	  lp.Login(df.wrongemail,df.wrongpassword);
	  	//driver.findElement(By.id("usernameInput-input")).sendKeys("dbdjbwihbwcbsj");
	  	//driver.findElement(By.id("password-input")).sendKeys("sxfwywjhbxj");
		//driver.findElement(By.id("signIn")).click();
		
	
		Thread.sleep(3000);
		String expectederrormsg = df.globalerr;//"Please check your card number / username or password and try again.";
		String actualerrormsg = lp.readGlobalErr();//driver.findElement(By.className("_25yKbJzdQG5JaS-QB9EOCt")).getText();
		
		 //System.out.println(actualerrormsg);
		
		Assert.assertEquals(expectederrormsg, actualerrormsg);

  }
  

}
