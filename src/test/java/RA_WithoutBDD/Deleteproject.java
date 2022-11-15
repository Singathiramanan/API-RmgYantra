package RA_WithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deleteproject {
	@Test
	public void removeProject(){
		String projectid="TY_PROJ_836"; 
		RequestSpecification reqsp = RestAssured.given();
		Response response = reqsp.delete("http://localhost:8085/projects/"+projectid);
		System.out.println(response.statusCode());
	}

}
