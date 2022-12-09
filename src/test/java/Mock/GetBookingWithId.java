package Mock;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetBookingWithId {

		@Test
		public void getBookingWithId(){
			given()
				.header("Accept", "application/json")
				//.header("Accept", "application/xml")
				.pathParam("id", "1")
			.when()
				.get("https://restful-booker.herokuapp.com/booking/{id}")
			.then()
				.statusCode(200)
				.log().all();
			
		}
}
