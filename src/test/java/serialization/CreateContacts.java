package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.Family;
import pojoClasses.contacts;

public class CreateContacts {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int[] phNo={7410852,852741,7894620};
		int[] phnum={74108521,85207410,124578};
		Family[] f1={new Family("appa", "airtel", "pmk", phnum, "nosocialmedia")};
		contacts c1=new contacts("venkat", "ramanan", "airtel", phNo, "PMK", "300797", "www.insta.com", "ramanan", "ramanan.facebook", f1);
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./JsonFormat/contacts.json"), c1);
	}

}
