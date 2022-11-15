package EndToEndAPITestcase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.RmgYantra.GenericUtility.BaseClass;
import com.RmgYantra.GenericUtility.EndPointUtility;
import com.RmgYantra.PomRepository.HomePage;
import com.RmgYantra.PomRepository.ProjectsPage;

import io.restassured.http.ContentType;
import pojoClasses.PojoClassForPostRequest;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.util.List;

public class CreateProjectInAPIVAlidateInGuiAndDatabaseTest extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Test
	public void createProjectInAPItest() throws Throwable{
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
			.post(EndPointUtility.createProject)
		.then()
			.log().all();
		
		//Gui validation
		HomePage home=new HomePage(driver);
		home.getProjectTab().click();
		ProjectsPage project=new ProjectsPage(driver);
		List<WebElement> pname = project.getAllProjectname();
		boolean flag = false;
		for(WebElement ele:pname){
			if(ele.getText().equals(proName)){
				flag=true;
				break;}
		}
		if(flag==true){
			System.out.println("project is created in GUI");
		}else{
			System.out.println("Project is not created in GUI");
		}
		//DataBase Validation
		String query="select * from project where project_name='"+proName+"';";
		ResultSet result = dlib.execyteQuery(query);
		while(result.next()){
		if(result.getString(4).equals(proName)){
			System.out.println("project is created in Database");
		}else{
			System.out.println("Project is not created in Database");
		}
		}
			
	}

}
