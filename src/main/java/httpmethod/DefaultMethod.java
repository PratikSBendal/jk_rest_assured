package httpmethod;

import java.util.Map;

import base.RequestBuilder;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.qameta.allure.Allure;

public class DefaultMethod {

	// Get Health
	
	public Response getHealth()
	{
		 Response response = given()
	                .spec(RequestBuilder.buildRequest())
	                .when()
	                .get("/health")
	                .then()
	                .extract().response();	
		 
		 Allure.addAttachment("Health Check Response", response.asString());
	     return response;
	}
	
	// SignUp for User
	
	 public Response signUp(Map<String, Object> body) {
	        Response response = given()
	                .spec(RequestBuilder.buildRequest())
	                .body(body)
	                .when()
	                .post("/signup")
	                .then()
	                .extract().response();
	        
	        Allure.addAttachment("Signup Request", body.toString());
	        Allure.addAttachment("Signup Response", response.asString());
	        return response;
	    }

	 // User Login
	public Response userLogin(Map<String, Object> body) {
	        Response response = given()
	                .spec(RequestBuilder.buildRequest())
	                .body(body)
	                .when()
	                .post("/login")
	                .then()
	                .extract().response();
	        
	        Allure.addAttachment("Login Request", body.toString());
	        Allure.addAttachment("Login Response", response.asString());
	        return response;
	    }
}
