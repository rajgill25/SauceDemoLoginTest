package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By Username=By.cssSelector("[id='user-name']");
	By Password=By.cssSelector("[id='password']");
	By LOGIN=By.cssSelector("[id='login-button']");
	By Menu=By.xpath("//*[text()='Open Menu']");
    By LogOut=By.cssSelector("[id='logout_sidebar_link']");
    By ErrorMessage=By.xpath("//*[contains(text(),'Epic sadface:')]");
	public LoginPage(WebDriver driver) 
	{
	    this.driver=driver;
	}
    public WebElement getUsername()
	{
		return driver.findElement(Username);
	}
	
    public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(LOGIN);
	}
	
	public WebElement getMenuOption()
	{
		return driver.findElement(Menu);
	}
	public WebElement getLogOut()
	{
		
		return driver.findElement(LogOut);
	}
	public  WebElement getErrorMessage()
	{
		return driver.findElement(ErrorMessage);
	}
	}
