package base;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
	protected static String baseUrl = "http://localhost:8000";
	private static String TOKEN = null;

	// For Token Set
	public static void setToken(String token) {
		try {
			TOKEN = token;
			System.out.println("Token set successfully.");
		} catch (Exception e) {
			System.out.println("Failed to set token:" + e.getMessage());
		}
	}

	// Create Request

	public static RequestSpecification buildRequest() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		try {

			builder.setBaseUri(baseUrl).setContentType(ContentType.JSON);

			if (TOKEN != null) {
				builder.addHeader("Authorization", "Bearer " + TOKEN);

			}

		} catch (Exception e) {
			System.out.println("⚠️ Failed to build request specification: " + e.getMessage());

		}
		return builder.build();

	}

}
