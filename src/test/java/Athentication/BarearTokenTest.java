package Athentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarearTokenTest {
@Test
public void Authentication(){
	given()
		.auth().oauth2("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")
	.when()
		.get("https://api.github.com/users/repos")
	.then()
		.assertThat().statusCode(200)
		.log().all();
}
}
