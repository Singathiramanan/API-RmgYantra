package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.Child1;
import pojoClasses.Child2;
import pojoClasses.EmployeeDetailsMultiObject;
import pojoClasses.spouse;

public class MultiObjectArray {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Child1 ch1=new Child1("child1", 15, "bangalore");
		Child2 ch2=new Child2("child2", 10, "bangalore");
		spouse[] sp={new spouse("Notfound", 741852, "lara@gmail.com", "bangalore", ch1, ch2)};
		EmployeeDetailsMultiObject emp=new EmployeeDetailsMultiObject("venkat", "TYRMG007", 74185296, "ramanan@gmail.com", "paramakudi", sp);
		//create object of an Object array
		ObjectMapper obj=new ObjectMapper();
		
		//Write the value
		obj.writeValue(new File("./JsonFormat/MultiObject.json"), emp);
	}

}
