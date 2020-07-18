package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

/*
 * 
 * To write JSON to file, you will be working to mainly two objects:
JSONArray : To write data in json arrays. Use its add() method to add objects of type JSONObject.
JSONObject : To write json objects. Use it’s put() method to populate fields.
 * 
 * */
public class WriteJson {
	@Test
	public void awriteData() {
		//First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");
         
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");
         
        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    	}
	@SuppressWarnings("unchecked")
	@Test
	public void readData()
	{
		
		 JSONParser parser = new JSONParser();

	     

	          

	            //JSON parser object to parse read file
	            try (FileReader reader = new FileReader("f:\\test.json"))
	            {
	             
	            
	     
	                //Read JSON file
	                Object obj = parser.parse(reader);
	     
	                JSONArray employeeList = (JSONArray) obj;
	                System.out.println(employeeList);
	                 
	                //Iterate over employee array
	                employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
	     
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        
}
	
	 private static void parseEmployeeObject(JSONObject employee)
	    {
	        //Get employee object within list
	        JSONObject employeeObject = (JSONObject) employee.get("employee");
	         
	        //Get employee first name
	        String firstName = (String) employeeObject.get("firstName");   
	        System.out.println(firstName);
	         
	        //Get employee last name
	        String lastName = (String) employeeObject.get("lastName"); 
	        System.out.println(lastName);
	         
	        //Get employee website name
	        String website = (String) employeeObject.get("website");   
	        System.out.println(website);
	    }
}