/**
 * 
 */
package SalesforceApiDemo.com.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author 29265
 *
 */
public class call {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//https://login.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9YDQS5WtC11oHCvKnjrUo_FDoBn98KqIRWL.yqzIEnAQelwKsNiXo.aYN4GA1C9ib5TA_ODUlxZOOpOYf&client_secret=4349989114563044885&username=kvikash26n@gmail.com&password=l@litaDEVI1@3
		
		// RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 String secret="4349989114563044885";
String key="3MVG9YDQS5WtC11oHCvKnjrUo_FDoBn98KqIRWL.yqzIEnAQelwKsNiXo.aYN4GA1C9ib5TA_ODUlxZOOpOYf";
String endpoint="https://login.salesforce.com";

RestAssured.baseURI =endpoint+"/services/oauth2/token?"+"grant_type=password&client_id="+key+"&client_secret="+secret+"&username=kvikash26n@gmail.com&password=l@litaDEVI1@3";
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = (Response) httpRequest.request(Method.POST);
		 
		 // Now let us print the body of the message to see what response
		 // we have recieved from the server
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		
	}

}
