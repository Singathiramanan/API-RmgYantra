package RA_WithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class GetAllProjects {
	@Test
	public void fetchAllProjects(){
		ValidatableResponse resval = RestAssured.get("http://localhost:8085/projects").then();
		resval.log().all();
		resval.assertThat().statusCode(200);
		resval.assertThat().contentType(ContentType.JSON);
	}
}
