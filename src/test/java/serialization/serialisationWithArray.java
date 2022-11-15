package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.employeeDetailsWithArray;

public class serialisationWithArray {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// Create Object for pojo class
		int[] phNo={74185,963852,789456};
		employeeDetailsWithArray emp = new employeeDetailsWithArray("venkat", "TY007", phNo, "ramanan@gmail.com", "Paramakudi");
		
		//create object of an Object array
		ObjectMapper obj=new ObjectMapper();
		
		//Write the value
		obj.writeValue(new File("./JsonFormat/Array.json"), emp);

	}

}
