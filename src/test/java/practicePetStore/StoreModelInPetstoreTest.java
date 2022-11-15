package practicePetStore;

import org.testng.annotations.Test;

import PojoForPetstore.petPlaceOrderStore;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class StoreModelInPetstoreTest {
	@Test(enabled=false)
	public void placeOrderForPet(){
		petPlaceOrderStore obj=new petPlaceOrderStore(12, 101, 1, "234567", "placed", true);
		baseURI="https://petstore.swagger.io/v2";
		given().
			body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("/store/order")
		.then()
			.log().all();
		
	}
	@Test(enabled=false)
	public void getUsingOrderId(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("orderId", 10).when().get("/store/order/{orderId}").then().log().all();
	}
	@Test(enabled=false)
	public void deletePuchaseOrder(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("orderId", 10).when().delete("/store/order/{orderId}").then().log().all();
	}
	@Test(enabled=true)
	public void returnPetInventoryStatus(){
		baseURI="https://petstore.swagger.io/v2";
		given().get("/store/inventory").then().log().all();
	}
}
