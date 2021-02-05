package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
	String Path=System.getProperty("user.dir");
public WebDriver initializeDriver() throws IOException
{
prop= new Properties();
FileInputStream fis=new FileInputStream(Path+"\\src\\main\\java\\resources\\data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver",Path+"\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
}
else if (browserName.equals("firefox"))
{
	 System.setProperty("webdriver.gecko.driver",Path+"\\Drivers\\geckodriver.exe");
	 driver= new FirefoxDriver();
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}
public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	System.out.println(destinationFile);
	FileUtils.copyFile(source,new File(destinationFile));



}

}
