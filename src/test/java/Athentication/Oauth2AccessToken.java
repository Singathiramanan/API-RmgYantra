package Athentication;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class Oauth2AccessToken {
	public static void main(String[] args) {
		
		Response response = given()
				.formParam("client_id", "chickenShop")
				.formParam("client_secret", "3f8de69e94cb3f5ea3a72eaf8489361d")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
				.formParam("code", "3884")
		.when()
				.post("http://coop.apps.symfonycasts.com/token");
		response.then().log().all();
	     System.out.println(response);
		 String token = response.jsonPath().get("access_token");
		 
		 given()
		 		.auth().oauth2(token)
		 		.pathParam("USER_ID", 2934)
		 .when()
		 		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		 	.then().log().all();
	}
}
