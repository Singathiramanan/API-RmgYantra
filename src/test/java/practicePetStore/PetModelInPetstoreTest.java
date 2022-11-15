package practicePetStore;

import org.testng.annotations.Test;

import PojoForPetstore.addNewPet;
import PojoForPetstore.categoryObject;
import PojoForPetstore.tagsArrayObject;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PetModelInPetstoreTest {
	@Test(enabled=false)
	public void addNewPetInStore(){
		baseURI="https://petstore.swagger.io/v2";
		categoryObject cate=new categoryObject(15, "fourLeg");
		tagsArrayObject tags=new tagsArrayObject(15, "dog");
		String[] photoUrl={"photourl"};
		Object[] tagsAr={tags};
		addNewPet pet=new addNewPet(12, cate, "scoobe", photoUrl, tagsAr, "available");
		
		given().body(pet).contentType(ContentType.JSON).when().post("/pet").then().log().all();
	}
	@Test(enabled=false)									
	public void findPetByStatus(){
		baseURI="https://petstore.swagger.io/v2";
		String[] sta={"available"};
		given().queryParams("status", sta).when().get("/pet/findByStatus").then().log().all();
	}
	@Test(enabled=false)
	public void findByPetId(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("petId", 12).when().get("/pet/{petId}").then().log().all();
	}
	@Test(enabled=false)
	public void updatePetUsingFormData(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("petId", 13).formParam("name", "charli").formParam("status", "sold")
		.when().post("/pet/{petId}").then().log().all();
	}
	@Test(enabled=true)										//not completed
	public void uploadOnImagePet(){
		baseURI="https://petstore.swagger.io/v2";
		File img=new File("C:\\Users\\Umamani\\Downloads\\326b32581069519ed004717b6e7ded3c.png");
		given().pathParam("petId", 13).formParam("additionalMetadata", "Strong").formParam("uploadImage", img)
		.when().post("/pet/{petId}/uploadImage").then()
		.log().all();
	}
	@Test(enabled=false)
	public void updateExistingData(){
		baseURI="https://petstore.swagger.io/v2";
		categoryObject cate=new categoryObject(10, "fast");
		tagsArrayObject tags=new tagsArrayObject(10, "puppy");
		String[] photoUrl={"photossurl"};
		Object[] tagsArr={tags};
		addNewPet pet=new addNewPet(13, cate, "scoobedoo", photoUrl, tagsArr, "pending");
		given().body(pet).contentType(ContentType.JSON).when()
		.put("/pet").then().log().all();
	}
	@Test(enabled=false)
	public void deleteAPet(){
		baseURI="https://petstore.swagger.io/v2";
		given().pathParam("petId", 13).when().delete("/pet/{petId}").then().log().all();
	}
	@Test(enabled=false)									
	public void findPetByTags(){
		baseURI="https://petstore.swagger.io/v2";
		String[] sta={"tagsArr"};
		given().queryParams("status", sta).when().get("/pet/findByTags").then().log().all();
	}
	
}
