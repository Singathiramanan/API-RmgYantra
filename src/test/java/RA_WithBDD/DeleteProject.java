package RA_WithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject {
	@Test
	public void DeleteSingleProject(){
		baseURI="http://localhost";
		port=8085;
		given()
			.delete("projects/TY_PROJ_833")
			.then()
				.assertThat()
					.statusCode(204)
				.log().all();
	}

}
