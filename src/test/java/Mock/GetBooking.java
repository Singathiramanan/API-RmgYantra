package Mock;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetBooking {
		
	@Test
	public void getBookingTest(){
		given()
			.get("https://restful-booker.herokuapp.com/booking")
		.then()
			.log().all();
	}
}
