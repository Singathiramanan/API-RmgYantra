package validationTest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation {
	@Test
	public void ValrespTime(){
		baseURI="http://localhost";
		port=8085;
		Response response = when().get("projects");
		response.then().assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);		
	}
}
