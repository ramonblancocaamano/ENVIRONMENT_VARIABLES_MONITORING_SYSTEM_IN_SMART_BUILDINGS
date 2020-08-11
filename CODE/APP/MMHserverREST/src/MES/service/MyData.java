package MES.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import MES.utils.MySQLModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

/**
 * Implements the login on the server.
 * @author Pablo Rey Persical
 * @version 1.0
 * This class will take the user's token and check it out. If its ok, the user's last data will be sent 
 * 
 * HowToInvoke: Request will be made on path /mydata through POST
 * Request: JSON with the following structure:
 * {"toke":"USERTOKEN"}
 * RETURN: JSON with the format:
 * {"temp":"USERLASTTEMPERATURE","hum":"USERLASTHUMIDITY"}
 */
@Path("/mydata")
public class MyData {
	
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
   	  jsonObject.put("temp", MySQLModel.getdatadb()); 
   	  jsonObject.put("hum", 30);
   	  
   	  
System.out.println(jsonObject.toString()); 

       return jsonObject.toString();
     }	
	 
}

