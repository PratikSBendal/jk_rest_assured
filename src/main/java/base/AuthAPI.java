package base;

import java.util.Map;

import endpoint.APIEndPoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthAPI {

	private static String token = null;

	// Create User If Not Already exist

	public static void createUser(Map<String, Object> userData) {

		try {
			Response response = RestAssured.given().spec(RequestBuilder.buildRequest()).body(userData).when()
					.post(APIEndPoint.SIGNUP);

			if (response.statusCode() == 200) {
				System.out.println("User created successfully: " + userData.get("email"));
			} else if (response.statusCode() == 400) {
				System.out.println("User already exists: " + userData.get("email"));
			} else {
				System.out.println("Failed to create user. Status: " + response.statusCode());
			}
		} catch (Exception e) {
			System.out.println("Exception while creating user: " + e.getMessage());
		}

	}

	// Generate New Token Or If User Alrady exist then Reuse Token

	public static String genrateToken(Map<String, Object> userData) {
		try { 

			// Return Existing Token If Already Generated
			if (token != null) {
				return token;
			}

			Response response = RestAssured.given().spec(RequestBuilder.buildRequest()).body(userData).when()
					.post(APIEndPoint.LOGIN);

			token = response.jsonPath().getString("access_token");
			RequestBuilder.setToken(token);
		} catch (Exception e) {
			System.out.println("Exception while generating token: " + e.getMessage());

		}
		return token;

	}

	// Create User If Needed And Return Token

	public static String getOrCreateToken(Map<String, Object> userData) {
		try {
			createUser(userData); 
			return genrateToken(userData);
		} catch (Exception e) {
			System.out.println("⚠️ Exception in getOrCreateToken: " + e.getMessage());
			return null;
		}
	}
}
