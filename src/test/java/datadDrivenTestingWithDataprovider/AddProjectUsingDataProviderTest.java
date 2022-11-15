package datadDrivenTestingWithDataprovider;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.ExcelUtility;

import io.restassured.http.ContentType;
import pojoClasses.PojoClassForPostRequest;
import static io.restassured.RestAssured.*;

import java.io.IOException;


public class AddProjectUsingDataProviderTest {
	@Test(dataProvider="TestBody")
	public void addProjectTest(String createdBy,String projectName,String status,int teamsize) {
		PojoClassForPostRequest apj=new PojoClassForPostRequest(createdBy, projectName, status, teamsize);
		given()
		      .contentType(ContentType.JSON)
		      .body(apj)
		.when()
		      .post("http://localhost:8084/addProject")
		.then()
		      .assertThat()
		      .contentType(ContentType.JSON)
		      .log().all();
		}

	@DataProvider
	public Object[][] TestBody() throws EncryptedDocumentException, IOException {
		Object [][] obj=new Object[2][4];
		obj[0][0]=ExcelUtility.getStringExcelData("Sheet1", 0,0);
		obj[0][1]=ExcelUtility.getStringExcelData("Sheet1", 0, 1);
		obj[0][2]=ExcelUtility.getStringExcelData("Sheet1", 0, 2);
	    obj[0][3]=ExcelUtility.getNumericExcelData("Sheet1", 0, 3);
	    obj[1][0]=ExcelUtility.getStringExcelData("Sheet1", 1, 0);
	    obj[1][1]=ExcelUtility.getStringExcelData("Sheet1", 1, 1);
	    obj[1][2]=ExcelUtility.getStringExcelData("Sheet1", 1, 2);
	    obj[1][3]=ExcelUtility.getNumericExcelData("Sheet1", 1, 3);
	    return obj;

}
}
