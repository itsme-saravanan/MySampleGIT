package a3_ParmaterPassing;

public class A3_DataProvider {

	public static String parameterPassing(String name, String job) {
		String s = "{\r\n" + "  "
				+ "  \"name\": \"" + name + "\",\r\n" 
				+ "    \"job\": \"" + job + "\"\r\n" 
				+ "}";
		return s;
	}
}
