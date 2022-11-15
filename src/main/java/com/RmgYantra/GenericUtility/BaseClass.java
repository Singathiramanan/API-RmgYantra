package com.RmgYantra.GenericUtility;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import static io.restassured.RestAssured.*;

public class BaseClass {
	public static WebDriver driver=null;
	public static WebDriver sdriver=null;
	public DataBaseUtility dlib=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredUtility rlib=new RestAssuredUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite
	public void bsConfig() throws SQLException{
		System.out.println("Connect to DB");
		dlib.connectDB();
		baseURI="http://localhost";
		port=8084;
	}
	
	@BeforeClass
	public void bcConfig() throws MalformedURLException{
		System.out.println("=============Launch the Browser=======");
		String browser= IConstants.browser;
		if (browser.equalsIgnoreCase("msedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			URL url = new URL("http://13.233.116.234:4444/wd/hub");
//			DesiredCapabilities cap=new DesiredCapabilities();
//			cap.setBrowserName("chrome");
//			cap.setPlatform(Platform.WINDOWS);
//			driver=new RemoteWebDriver(url, cap);
		} else {
			System.out.println("invalid browser");
		}
		sdriver=driver;
	}
	
	@BeforeMethod
	public void bmMethod(){
		driver.get(IConstants.appUrl);
		LogInPage login=new LogInPage(driver);
		login.LoginToApplication(IConstants.appUsername, IConstants.appPassword);
	}
	
	@AfterMethod
	public void afMethod(){
		HomePage home=new HomePage(driver);
		home.LogoutApplication();
	}
	
	@AfterClass
	public void acConfig(){
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	@AfterSuite
	public void asConfig() throws SQLException{
		dlib.closeDB();
	}
}
