package EndToEndAPITestcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;
import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.ProjectsPage;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class CreateDeleteInDataBase extends BaseClass{

	String expectedData = "HTTP/1.1 200 ";
	String ID;
	@Test
	public void deleteId() throws Throwable
	{
		
		wlib.waitForElementInDOM(driver);
		dlib.connectDB();
		String proId = "TY_PROJ_"+jlib.RandomNumber();
		String proname = "techmax"+jlib.RandomNumber();
		String query = "insert into project values('"+proId+"', 'Ramanan', '03/04/2022', '"+proname+"', 'Completed', 9);";
		dlib.execyteUpdate(query);
		System.out.println("created");
		String query1 = "select * from project;";
		dlib.executeQuerryAndVerify(query1, 4, proname);
		
		System.out.println("Project created in DataBase");
		
		Response res = when()
				.get(EndPointUtility.getSingleProject+proId);
		
		String actData = res.getStatusLine();

		Assert.assertEquals(expectedData, actData);

		System.out.println("projectId is created through API");

		HomePage home=new HomePage(driver);
		home.getProjectTab().click();
		ProjectsPage project=new ProjectsPage(driver);
		project.deleteProject(proId);
		
	}

}
