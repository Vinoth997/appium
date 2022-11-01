package files;

import io.restassured.path.json.JsonPath;

public class reUsableMethods {

	public static JsonPath rawToJson(String response) {
		JsonPath jp1 = new JsonPath(response);
		return jp1;		
	}
}
