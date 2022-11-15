package EndToEndAPITestcase;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;
import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.ProjectsPage;

import io.restassured.http.ContentType;

public class CreateInGUIUpdateWithFileVerifyInDB extends BaseClass {
	String proId = "TY_PROJ_2402";

	@SuppressWarnings("unchecked")
	@Test
	public void createProjectInGUI() throws Throwable {
		wlib.waitForElementInDOM(driver);
		HomePage home=new HomePage(driver);
		home.getProjectTab().click();
		ProjectsPage project=new ProjectsPage(driver);
		project.getCreateProjectButton().click();
		driver.findElement(By.name("projectName")).sendKeys("Escortese");
		driver.findElement(By.name("createdBy")).sendKeys("Singoneous");
		WebElement option = driver.findElement(By.name("status"));
		Select sel = new Select(option);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Ramanan");
		jobj.put("projectName", "Singathicart"+jlib.RandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 6);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put(EndPointUtility.updateProject+proId);
		
		
		String query = "select * from project";
		
		dlib.executeQuerryAndVerify(query, 2, "Ramanan");
	}
}
