package MES.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Implements the login on the server.
 * @author Pablo Rey Persical
 * @version 1.0
 * This class will take the user's token and check it out. If its ok, the user's last week data will be sent 
 * 
 * HowToInvoke: Request will be made on path /lastweek through POST
 * Request: JSON with the following structure:
 * {"toke":"USERTOKEN"}
 * RETURN: JSON with the format:
 * {"MondayMax":"USER_LAST_MONDAY_MAX_TEMPERATURE","MondayMin":"USER_LAST_MONDAY_MIN_TEMPERATURE";"NextDayMax":"USER_LAST_NEXTDAY_MAX_TEMPERATURE","NextDayMin":"USER_LAST_NEXTDAY_MIN_TEMPERATURE";}
 */
@Path("/lastweek")
public class LastWeek {
	
	 @POST
     @Produces(MediaType.APPLICATION_JSON)
     @Consumes(MediaType.APPLICATION_JSON)
     public String Login(String request) throws JSONException {
   	  
   	  //Obtain token
   	  JSONObject jsonRequest = new JSONObject(request);
   	  System.out.println(jsonRequest.get("token"));
   	  //TODO check it out
   	  
   	 
   	  //RESPONSE
   	  JSONObject jsonObject = new JSONObject();
   	  
   	  
   	  //Build JSON
   	  jsonObject.put("MondayMax", 35); 
   	jsonObject.put("MondayMin", 25);
   	  jsonObject.put("TuesdayMax",30 );
   	jsonObject.put("TuesdayMin", 25);
   	  jsonObject.put("WednesdayMax", 33);
   	jsonObject.put("WednesdayMin", 27);
   	  jsonObject.put("ThursdayMax", 30);
   	jsonObject.put("ThursdayMin", 28);
   	  jsonObject.put("FridayMax", 39);
   	jsonObject.put("FridayMin", 35);
   	  jsonObject.put("SaturdayMax", 45);
   	jsonObject.put("SaturdayMin", 39);
   	  jsonObject.put("SundayMax", 25);
   	jsonObject.put("SundayMin", 20);
   	  

   	  
System.out.println(jsonObject.toString()); 

       return jsonObject.toString();
     }
}