package validationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BodyValidationTest {
	@Test
	public void bodyValidationTest() {
		baseURI="http://localhost";
		port=8084;
		@SuppressWarnings("unused")
		String expectStatusLine="HTTP/1.1 200";
		Response res=given()
		.get("projects");
		String body=res.getBody().asString();
		System.out.println(body);
		Boolean flag=false;
		
		if(body.contains("TY_PROJ_2402")) {
			flag=true;
			System.out.println("found");
		}
		Assert.assertTrue(flag);
	}

	}
