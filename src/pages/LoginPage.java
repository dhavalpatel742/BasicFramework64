package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		}
	WebDriver driver;
	
	//WebElement email = driver.findElement(By.id("usernameInput-input"));
	//WebElement password = driver.findElement(By.id("password-input"));
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailError;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordError;

	
	public void OpenBrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		
		prop.load(f);
		String browser = prop.getProperty("browser");
		
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		 //System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		  //driver = new FirefoxDriver();
		
		PageFactory.initElements(driver, this);//initialize driver

	}
	
	
	
	public void openLoginPage() {
		  driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qjhCJuRZoS4&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoicWpoQ0p1UlpvUzQiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTI1MzYwMywiaWF0IjoxNjU1MjUyNDAzLCJqdGkiOiJiNGJmYjZiZi0xNDNhLTQ5NGUtOTZjZC0yZTFiNjViMTE2MmEiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.ezSbETD4jllYkOSpxiKuJLErWjglianS1MCmfY-a6bchRNiH7sog-s-EfTAAk6gtzhlaKDTJWe6JBGJb7NbX6s4f6hkBC2oaVaC1THwNFqdEUODX_ekYKfGcFnwBVQBwhVLVdSPR4HqTdmx0wwSDk1GWMvKq71eBWZCr-Y9lrkq-rvw2nrT_t4wcM5gQTL5bLXsf1yV8zQrazkNlbJuOOCMyXMlqP-v58gPBfrbcCtN9OD2G2qIgBnBNk4TvVVnBKcDXd4ac9-32eseqK7vpqdo9yqGE_gN2NSOkZsFthvwlcclqnZ-HdtgwD6YX1XBTE-V6VpNUfHz5ooSOaRTTJg&preferred_environment=");
	}
	
	public void closeBrowser() {
		  driver.quit();

	}
	
	public void Login(String a , String b) {
		email.sendKeys(a);
	  	password.sendKeys(b);
	  	signInButton.click();
		
	}
	
	public String readEmailErr() {
		String actualErr = emailError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr = passwordError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readGlobalErr() {
		String actualErr = globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
