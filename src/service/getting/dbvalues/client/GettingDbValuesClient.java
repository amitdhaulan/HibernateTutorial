package service.getting.dbvalues.client;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GettingDbValuesClient {
	static final String REST_URI = "http://localhost:7070/ConnectionWithDatabase/db/values/";
	static final String TABLE = "employee";

	public static void main(String[] str) throws ClientProtocolException,
			IOException {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		
		WebResource service = client.resource(REST_URI);
		WebResource addService = service.path("").path(TABLE);
		System.out.println("CEL_TO_FAR Response: " + getResponse(addService));
		System.out.println("CEL_TO_FAR Output as JSON: "
				+ getOutputAsJSON(addService));
		System.out
				.println("---------------------------------------------------");

	}

	private static String getResponse(WebResource service) {
		return service.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class).toString();

	}

	private static String getOutputAsJSON(WebResource service) {
		return service.accept(MediaType.APPLICATION_JSON).get(String.class);

	}

}
