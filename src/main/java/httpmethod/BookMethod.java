package httpmethod;

import java.util.Map;

import base.RequestBuilder;
import endpoint.APIEndPoint;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.qameta.allure.Allure;

public class BookMethod {
	Response response = null;
	
// Get All Book Details	
	public Response getAllBook() {

		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.when()
					.get(APIEndPoint.BOOKS)
					.then()
					.extract().response();
 
			Allure.addAttachment("Get All Books Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in getAllBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Get All Books Response Failure", response.asString());
			} else {
				Allure.addAttachment("Get All Books Response Failure", "No response captured due to exception.");
			}
		}

		return response;

	}

// Create Book Details

	public Response createBook(Map<String, Object> body) {

		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.body(body)
					.when()
					.post(APIEndPoint.BOOKS)
					.then()
					.extract().response();
			
			
			Allure.addAttachment("Create Book Request", body.toString());
			Allure.addAttachment("Create Book Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in createBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Create Books Response Failure", response.asString());
			} else {
				Allure.addAttachment("Create Books Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	}

// Update Book Details

	public Response updateBook(int bookid, Map<String, Object> body) {
		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.pathParam("book_id", bookid)
					.body(body)
					.when()
					.put(APIEndPoint.BOOK_BY_ID)
					.then()
					.extract().response();

			Allure.addAttachment("Update Book Request", body.toString());
			Allure.addAttachment("Update Book Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in updateBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Update Books Response Failure", response.asString());
			} else {
				Allure.addAttachment("Update Books Response Failure", "No response captured due to exception.");
			}

		}
		return response;
	}

// Delete Book ID

	public Response deleteBook(int bookid) {
		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.pathParam("book_id", bookid)
					.when()
					.delete(APIEndPoint.BOOK_BY_ID)
					.then()
					.extract().response();

			Allure.addAttachment("Delete Book ID Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in deleteBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Delete Books Response Failure", response.asString());
			} else {
				Allure.addAttachment("Delete Books Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	}

// Get selective Book ID

	public Response getBook(int bookid) {
		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.pathParam("book_id", bookid)
					.when()
					.get(APIEndPoint.BOOK_BY_ID)
					.then()
					.extract().response();
            System.out.println(response.asString());
			Allure.addAttachment("Get Book by ID Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in getBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Get Books Response Failure", response.asString());
			} else {
				Allure.addAttachment("Get Books Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	}
	

// Get All Book Missing with No Token
	
	public Response missingTokenGetBook ()
	{
	try {
		response = given()
				.baseUri("http://localhost:8080")
				.when()
				.get(APIEndPoint.BOOKS)
				.then()
				.extract().response();

		Allure.addAttachment("Missing Token Get All Books Response", response.asString());
	} catch (Exception e) {
		System.out.println("Exception in missingTokenGetBook(): " + e.getMessage());
		if (response != null) {
			Allure.addAttachment("Missing Token Get All Books Response Failure", response.asString());
		} else {
			Allure.addAttachment("Missing Token Get All Books Response Failure", "No response captured due to exception.");
		}
	}

	return response;
}
	
// Missing Mandatory Field 
	
	public Response missingFieldCreateBook (Map<String, Object> body)
	{
		try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.body(body)
					.when()
					.post(APIEndPoint.BOOKS)
					.then()
					.extract().response();
			
			
			Allure.addAttachment("Missing Filed Book Request", body.toString());
			Allure.addAttachment("Missing Filed Book Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in missingFieldCreateBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Missing Filed Book Response Failure", response.asString());
			} else {
				Allure.addAttachment("Missing Filed Book Response Failure", "No response captured due to exception.");
			}
		}

		return response;
	
}
	
// Non Existing Book Record 
	
   public Response nonExistingBook (int bookid)
   {
	   try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.pathParam("book_id", bookid)
					.when()
					.get(APIEndPoint.BOOK_BY_ID)
					.then()
					.extract().response();
           System.out.println(response.asString());
			Allure.addAttachment("Get Non Existing Book by ID Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in nonExistingBook(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Get Non Existing Book Response Failure", response.asString());
			} else {
				Allure.addAttachment("Get Non Existing Book Response Failure", "No response captured due to exception.");
			}
		}

		return response;
   }
 
 // Update Non Existing Book Record
   
   public Response nonExistingBookUpdate(int bookid,Map<String, Object> body)
   {
	   try {
			response = given()
					.spec(RequestBuilder.buildRequest())
					.pathParam("book_id", bookid)
					.body(body)
					.when()
					.put(APIEndPoint.BOOK_BY_ID)
					.then()
					.extract().response();

			Allure.addAttachment("Update Non Exitsing Book Request", body.toString());
			Allure.addAttachment("Update Non Exitsing Response", response.asString());
		} catch (Exception e) {
			System.out.println("Exception in nonExistingBookUpdate(): " + e.getMessage());
			if (response != null) {
				Allure.addAttachment("Update Non Exitsing Response Failure", response.asString());
			} else {
				Allure.addAttachment("Update Non Exitsing Failure", "No response captured due to exception.");
			}

		}
		return response;
   }
   
}
