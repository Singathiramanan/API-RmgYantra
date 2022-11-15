package EndToEndTestingAPI;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static io.restassured.RestAssured.*;

public class CreateProjectInGUIandDeleteInAPIandCheckInDatabase {

	@Test
	public void createProjectDeleteProjectAndValidate() throws InterruptedException{
		Random random=new Random();
		int ran = random.nextInt(1000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8084");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String pName = "Singathicart"+ran;
		System.out.println(pName);
		driver.findElement(By.name("projectName")).sendKeys(pName);
		driver.findElement(By.name("createdBy")).sendKeys("Ramanan");
		WebElement dropdown = driver.findElement(By.name("status"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		driver.close();
		
		baseURI="http://localhost/";
		port=8085;
		
	}
}
