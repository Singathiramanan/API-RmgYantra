package EndToEndAPITestcase;

import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;
import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.ProjectsPage;

import static io.restassured.RestAssured.*;

public class FetchNullProjectnameIdfromGuiDeleteIndatabaseChechInApiTest extends BaseClass {
	
	@Test
	public void FetchNullProjectnameIdfromDatabaseDeleteInGUIChechInApitest() throws Throwable{
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		HomePage home=new HomePage(driver);
		home.getProjectTab().click();
		ProjectsPage project=new ProjectsPage(driver);
		String pId = project.getProjectId("Google-346");
		System.out.println(pId);
		
		//delete in database
		dlib.connectDB();
		String query="delete from project where project_id='"+pId+"';";
		dlib.execyteUpdate(query);
		
		//validate in APi 
		given().
			get(EndPointUtility.getSingleProject+pId)
		.then()
			.assertThat().statusCode(500)
			.log().all();
	}

}
