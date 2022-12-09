package Mock;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetBookingWithName {
	
	@Test
	public void getbookingWithFirstNameTest(){
		given()
			.queryParam("firstname", "James")
			.and().queryParam("lastname", "Brown")
		.when()
			.get("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();
	}
}
