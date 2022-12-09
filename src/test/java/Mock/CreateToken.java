package Mock;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateToken {

	@SuppressWarnings("unchecked")
	@Test
	public void createTokenTest(){
		JSONObject obj=new JSONObject();
		obj.put("username", "admin");
		obj.put("password", "password123");
		String uri = "https://restful-booker.herokuapp.com/auth";
		given().
			contentType("application/json")
			.body(obj)
		.when()
			.post(uri)
		.then()
			.log().all();
		
	}

}
