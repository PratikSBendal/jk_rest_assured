package httpmethod;

import java.util.Map;

import base.RequestBuilder;
import endpoint.APIEndPoint;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.qameta.allure.Allure;

public class DefaultMethod {

	Response response = null;

	// Get Health
	
	public Response getHealth()
	{
		try {
			response = given()
	                .spec(RequestBuilder.buildRequest())
	                .when() 
	                .get(APIEndPoint.HEALTH)
	                .then()
	                .extract().response();
			 Allure.addAttachment("Health Check Response", response.asString());

		}
		catch (Exception e)
		{
			System.out.println("Exception in getHealth(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Get Health Response Failure", response.asString());
			} else {
				Allure.addAttachment("Get Health Response Failure", "No response captured due to exception.");
			}
		}
		  	
	     return response;  
	}
	
	// SignUp for User
	
	 public Response signUp(Map<String, Object> body) {
		 try {
			 response = given()
		                .spec(RequestBuilder.buildRequest())
		                .body(body)
		                .when()
		                .post(APIEndPoint.SIGNUP)
		                .then()
		                .extract().response();
		        
		        Allure.addAttachment("Signup Request", body.toString());
		        Allure.addAttachment("Signup Response", response.asString());
		 }
		 catch (Exception e)
		 {
			 System.out.println("Exception in signUp(): " + e.getMessage());
				if (response != null) {
					Allure.addAttachment("SignUp Response Failure", response.asString());
				} else {
					Allure.addAttachment("SignUp Response Failure", "No response captured due to exception.");
				}
		 }
	         
	        return response;
	    }

	 // User Login
	public Response userLogin(Map<String, Object> body) {
	        try {
	        	response = given()
		                .spec(RequestBuilder.buildRequest())
		                .body(body)
		                .when()
		                .post(APIEndPoint.LOGIN)
		                .then()
		                .extract().response();
		        
		        Allure.addAttachment("Login Request", body.toString());
		        Allure.addAttachment("Login Response", response.asString());
		       
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Exception in userLogin(): " + e.getMessage());
				if (response != null) {
					Allure.addAttachment("UserLogin Response Failure", response.asString());
				} else {
					Allure.addAttachment("UserLogin Response Failure", "No response captured due to exception.");
				}
	        }
	        return response;
	    }
}
