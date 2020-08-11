package MES.service;

import java.math.BigInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import MES.utils.*;

/**
 * Implements the login on the server.
 * @author Pablo Rey Persical
 * @version 1.0
 * This class will take the user's login and check it out. If its ok, a unique random token will be generated with which the user will be able to request his/her own data
 * 
 * HowToInvoke: Request will be made on path /login through POST
 * Request: JSON with the following structure:
 * {"user":"YOURUSER","pass":"YOURPASS"}
 * RETURN: JSON with user's generated token and its expiration date
 * {"token":"YOURTOKEN","Edate":"ExpirationDate"}
 * date format: "yyyy-MM-dd;hh:mm:ss z"
 */
@Path("/login")
public class LoginService {
 
      @POST
      @Produces(MediaType.APPLICATION_JSON)
      @Consumes(MediaType.APPLICATION_JSON)
      public String Login(String request) throws JSONException, InterruptedException {
    	  
    	  //Obtain login data
    	  JSONObject jsonRequest = new JSONObject(request);
    	  System.out.println(jsonRequest.get("user"));
    	  System.out.println(jsonRequest.get("pass"));
    	  //TODO check it out
    	  
    	 
    	  //RESPONSE
    	  JSONObject jsonObject = new JSONObject();
    	  
    	  //Generate token
    	  String token =  new BigInteger(128, TokenGenerator.random).toString(32);
    	  
    	  //Get the expiration date
    	  String Edate = DateUtils.getExpirationDate();
    	  
    	  //Build JSON
    	  jsonObject.put("token", token); 
    	  jsonObject.put("Edate", Edate);
    	  
    	  
System.out.println(jsonObject.toString()); 

//TimeUnit.MINUTES.sleep(2);
        return jsonObject.toString();
      }

      
}