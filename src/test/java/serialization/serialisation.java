package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import pojoClasses.employeeDetails;

public class serialisation {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	
		//create object for pojo class
		employeeDetails emp = new employeeDetails("venkat", "TYSS00", 74185296, "ramanan@gmail.com", "paramakudi");
		
		//create object for object mapper
		ObjectMapper obj=new ObjectMapper();
		
		//write the value
		obj.writeValue(new File("./JsonFormat/EmployeeDetails.json"), emp);
		
	}

}
