package EndToEndAPITestcase;

import static io.restassured.RestAssured.when;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;

import io.restassured.response.Response;


public class CreateProjectInGUIAndVerifyDB extends BaseClass {
	
	
	public WebDriver driver;
	String proId = "TY_PROJ_2202";
	String expectedData = "HTTP/1.1 200 ";
	@Test
	public void createProjectInGUI() throws Throwable
	{
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("Escort");
		//driver.findElement(By.name("teamSize")).sendKeys("1");
		driver.findElement(By.name("createdBy")).sendKeys("Singone");
		WebElement option = driver.findElement(By.name("status"));
		Select sel = new Select(option);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Response res = when()
				.get(EndPointUtility.getSingleProject+proId);
		
		String actData = res.getStatusLine();

		Assert.assertEquals(expectedData, actData);

		System.out.println("projectId is created through API");
		
		
		String query = "select * from project";
		dlib.execyteQuery(query);
		dlib.executeQuerryAndVerify(query, 2, "Singone");
	}

}
