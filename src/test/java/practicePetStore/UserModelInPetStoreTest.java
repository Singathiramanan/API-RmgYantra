package practicePetStore;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UserModelInPetStoreTest {
	
	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void ApiPetStore(){
		JSONObject obj=new JSONObject();
		obj.put("id", 100);
		obj.put("username", "ramanan");
		obj.put("firstName", "bear");
		obj.put("lastName", "grylls");
		obj.put("email", "beargrylls@gmail.com");
		obj.put("password", "beargrylls");
		obj.put("phone", "3456783");
		obj.put("userStatus", 50);
		
		baseURI="https://petstore.swagger.io/v2";
		given().
			body(obj).
			contentType(ContentType.JSON)
		.when().
			post("/user").
		then().
			log().all();
		
	}
	@Test(enabled=false)
	public void loginUser()
	{
		baseURI="https://petstore.swagger.io/v2";

		given().
		when().get("/user/login").
		then().log().all();
	}
	@Test(enabled=false)
	public void logoutUser(){
		baseURI="https://petstore.swagger.io/v2";

		given().get("/user/logout").then().log().all();
		
	}
	@Test(enabled=false)
	public void deleteuser(){
		baseURI="https://petstore.swagger.io/v2";
		
		given().when().pathParam("username", "ramanan").delete("/user/{username}").then().log().all();
	}
	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void updateUser(){
		baseURI="https://petstore.swagger.io/v2";
		JSONObject obj=new JSONObject();
		obj.put("id", 101);
		obj.put("username", "ramananr");
		obj.put("firstName", "bearr");
		obj.put("lastName", "gryllss");
		obj.put("email", "beargryllss@gmail.com");
		obj.put("password", "beargryllss");
		obj.put("phone", "345783");
		obj.put("userStatus", 40);
		given().
			body(obj).
			contentType(ContentType.JSON)
		.when()
			.pathParam("username", "ramanan")
			.put("/user/{username}")
		.then()
			.log().all();
	}
	@Test(enabled=false)
	public void getUser(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("username", "ramananr").when().get("/user/{username}").then().log().all();
	}
	@SuppressWarnings("unchecked")
	@Test(enabled=false)
	public void createListOfUser(){
		baseURI="https://petstore.swagger.io/v2";
		JSONObject obj=new JSONObject();
		obj.put("id", 102);
		obj.put("username", "ramaanr");
		obj.put("firstName", "berr");
		obj.put("lastName", "grylss");
		obj.put("email", "beargrylss@gmail.com");
		obj.put("password", "beargrylss");
		obj.put("phone", "34783");
		obj.put("userStatus", 30);
		JSONObject obj1=new JSONObject();
		obj.put("id", 103);
		obj.put("username", "ramtaanr");
		obj.put("firstName", "bertr");
		obj.put("lastName", "grylsts");
		obj.put("email", "beargrylsts@gmail.com");
		obj.put("password", "beargrytlss");
		obj.put("phone", "347833");
		obj.put("userStatus", 20);
		Object[] oarr={obj,obj1};
		
		given().
			body(oarr).contentType(ContentType.JSON).when().post("/user/createWithList").then().log().all();
		
	}
	@SuppressWarnings("unchecked")
	@Test(enabled=true)
	public void createWithArray(){
		baseURI="https://petstore.swagger.io/v2";
		JSONObject obj=new JSONObject();
		obj.put("id", 104);
		obj.put("username", "raamaanr");
		obj.put("firstName", "baerr");
		obj.put("lastName", "gryalss");
		obj.put("email", "beargryalss@gmail.com");
		obj.put("password", "beargarylss");
		obj.put("phone", "347853");
		obj.put("userStatus", 25);
		Object[] arr={obj};
		
		given().body(arr).contentType(ContentType.JSON).when().post("/user/createWithArray").then().log().all();
	}
}
