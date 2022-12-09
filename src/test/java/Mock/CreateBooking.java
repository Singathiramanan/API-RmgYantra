package Mock;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoMock.BookingDates;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;

public class CreateBooking {

		@Test
		public void createBookingTest() throws JsonGenerationException, JsonMappingException, IOException{
			BookingDates dates=new BookingDates("2022-12-11", "2022-12-15");
			PojoMock.CreateBooking book=new PojoMock.CreateBooking("Singathi", "Ramanan", 1203, true, dates, "snacks");
			ObjectMapper obj=new ObjectMapper();
			obj.writeValue(new File("./JsonFormat/CreateBooking.json"), book);
			File file=new File("./JsonFormat/CreateBooking.json");
			given()
				.contentType("application/json")
				.header("Accept", "application/json")
				.body(file)
			.when()
				.post("https://restful-booker.herokuapp.com/booking")
			.then()
				.statusCode(200)
				.log().all();
		}
}
