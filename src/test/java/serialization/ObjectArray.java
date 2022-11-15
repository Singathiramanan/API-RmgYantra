package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.employeeDetailsWithObjectArray;
import pojoClasses.spose;

public class ObjectArray {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// Create Object for pojo class
				spose sp[]={new spose("NotFound", 78956, "imagine@gmail.com", "anywhere")};
				employeeDetailsWithObjectArray emp = new employeeDetailsWithObjectArray("venkat", "TYRMG007", 123456, "ramanan@gmail.com", "paramakudi", sp);
				
				//create object of an Object array
				ObjectMapper obj=new ObjectMapper();
				
				//Write the value
				obj.writeValue(new File("./JsonFormat/ObjectArray.json"), emp);

	}

}
