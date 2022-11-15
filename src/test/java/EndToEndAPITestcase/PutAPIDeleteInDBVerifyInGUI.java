package EndToEndAPITestcase;

import static io.restassured.RestAssured.given;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;
import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.ProjectsPage;

import io.restassured.http.ContentType;
import pojoClasses.PojoClassForPostRequest;


public class PutAPIDeleteInDBVerifyInGUI extends BaseClass{
	
	
	String pId = "TY_PROJ_003";

	@SuppressWarnings("static-access")
	@Test
	public void updateProject() throws Throwable
	{
		String createdBy = elib.getStringExcelData("Sheet1", 0, 0);
		String projectName = elib.getStringExcelData("Sheet1", 0, 1);
		String status = elib.getStringExcelData("Sheet1", 0, 2);
		int teamSize = Integer.valueOf(elib.getStringExcelData("Sheet1", 0, 3));
		String proName = projectName+jlib.RandomNumber();
		PojoClassForPostRequest jobj=new PojoClassForPostRequest(createdBy, proName, status, teamSize);
		driver.manage().window().maximize();
		given().
			body(jobj).
			contentType(ContentType.JSON)
		.when()
			.put(EndPointUtility.updateProject+pId)
		.then()
			.log().all();
			
		
		String query = "delete from project where created_by = 'Ramanan';";
		
		dlib.execyteUpdate(query);
		
		
		HomePage home=new HomePage(driver);
		home.getProjectTab().click();
		ProjectsPage project=new ProjectsPage(driver);
		List<WebElement> proIds = project.getAllProjectId();
		for (WebElement projectIds : proIds) {
			String ID = projectIds.getText();
			if (ID.equals(pId)) {
				System.out.println("Project ID in GUI" + ID);
				break;
			}
		}
	}

}
