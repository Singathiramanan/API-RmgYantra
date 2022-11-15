package DifferentWaysToPostRequest;

import java.io.IOException;
import java.util.TreeSet;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.ExcelUtility;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PostUsingExcel {
	@Test

	public void getMultipleData() throws EncryptedDocumentException, IOException {
		ExcelUtility excel = new ExcelUtility();
		String[][] data = excel.getMultipleData("src/test/resources/Testdata.xlsx", "ApiDataProvider");
		TreeSet<Object> map = new TreeSet<Object>();
		map.add(data);

		given().body(map).contentType(ContentType.JSON)
		.when().put("http://localhost:8084/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
