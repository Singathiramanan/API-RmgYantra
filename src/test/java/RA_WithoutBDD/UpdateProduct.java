package RA_WithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RmgYantra.GenericUtility.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProduct {
	@SuppressWarnings("unchecked")
	@Test
	public void completeUpdate(){
		String projectid="TY_PROJ_835";
		JavaUtility ran=new JavaUtility();
		int random = ran.RandomNumber();
		//create pre condition json body object using json simple
		JSONObject jo=new JSONObject();
		jo.put("createdBy", "venkat");
		jo.put("projectName", "Techmax"+random);
		jo.put("status", "ongoing");
		jo.put("teamSize", 4);
		RequestSpecification reqsp = RestAssured.given();
		reqsp.body(jo);
		reqsp.contentType(ContentType.JSON);
		Response response = reqsp.put("http://localhost:8085/projects/"+projectid);
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusLine());
		response.prettyPeek();
		System.out.println(response.prettyPeek());
		System.out.println(response.statusCode());
		response.then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON);
		
		
	}
}
