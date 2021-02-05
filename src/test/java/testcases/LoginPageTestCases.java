package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import pageObjects.LoginPage;
import resources.base;

@Listeners(listeners.ListenerTest.class)	
public class LoginPageTestCases extends base {
	public WebDriver driver;
	public LoginPage LP;
	@BeforeTest
	public void DriverInitialisation() throws IOException {
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
		LP=new LoginPage(driver);
	}
	@Test(priority=1)
	public void LoginWithEmptyUsernameAndPassword() {
        LP.getLogin().click();
		String ActualErrorMsg=LP.getErrorMessage().getText();
		String ExpectedErrorMsg="Epic sadface: Username is required";		
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
			
	}
	
	@Test(priority=2,dataProvider="ValidUserData")
    public void LoginWithValidCredentials(String username,String password) throws IOException, InterruptedException	{
    LP.getUsername().sendKeys(username);
	LP.getPassword().sendKeys(password);
	LP.getLogin().click();
	String CurrentUrl=driver.getCurrentUrl();
	String ExpectedUrl="https://www.saucedemo.com/inventory.html";
    Assert.assertEquals(CurrentUrl, ExpectedUrl);
    System.out.println("URL matched");
    LP.getMenuOption().click();
    LP.getLogOut().click();
    
     }
	@Test(priority=3)
	public void LoginWithLockedOutUser() {
		LP.getUsername().sendKeys("locked_out_user");
		LP.getPassword().sendKeys("secret_sauce");
		LP.getLogin().click();
		String ActualErrorMsg=LP.getErrorMessage().getText();
		String ExpectedErrorMsg="Epic sadface: Sorry, this user has been locked out.";		
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
			
	}
	@Test(priority=4)
	public void LoginWithInvalidCredentials() {
		
	    LP.getUsername().sendKeys("abc");
		LP.getPassword().sendKeys("secret_sauce");
		LP.getLogin().click();
		String ActualErrorMsg=LP.getErrorMessage().getText();
		String ExpectedErrorMsg="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(ActualErrorMsg, ExpectedErrorMsg);
	}
	
	@DataProvider
	public Object[][]ValidUserData(){
	Object[][]userdata=new Object[3][2];
	userdata[0][0]="standard_user";
	userdata[0][1]="secret_sauce";
	userdata[1][0]="problem_user";
	userdata[1][1]="secret_sauce";
	userdata[2][0]="performance_glitch_user";
	userdata[2][1]="secret_sauce";
	return userdata;
	}
    @AfterTest 
	public void tearDown() { driver.close(); }
	}



