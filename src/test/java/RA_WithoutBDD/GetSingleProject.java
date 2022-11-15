package RA_WithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleProject {

	@Test
	public void singleProject(){
		String projectid="TY_PROJ_837"; 
		RequestSpecification reqsp = RestAssured.given();
		RequestSpecification proid = reqsp.pathParam("pathID", projectid);
		Response response = reqsp.get("http://localhost:8085/projects/",proid);
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusLine());
		System.out.println(response.jsonPath().prettyPrint());
		response.then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON);
		
		
	}

}
