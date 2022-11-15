package RA_WithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostProduct {

	@SuppressWarnings("unchecked")
	@Test
	public void createProduct(){
		JavaUtility ran=new JavaUtility();
		int random = ran.RandomNumber();
		//create pre condition json body object using json simple
		JSONObject jo=new JSONObject();
		jo.put("createdBy", "ramanan");
		jo.put("projectName", "Techmax"+random);
		jo.put("status", "ongoing");
		jo.put("teamSize", 0);
		//create pre condition send content type
		RequestSpecification reqsp = RestAssured.given();
		reqsp.body(jo);
		reqsp.contentType(ContentType.JSON);
		Response response = reqsp.post("http://localhost:8085/addProject");
		ValidatableResponse resval = response.then();
		resval.assertThat().contentType(ContentType.JSON);
		resval.assertThat().statusCode(201);
		resval.log().all();
		
		
		
		
	}
}
