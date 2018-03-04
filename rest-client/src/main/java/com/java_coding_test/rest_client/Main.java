package com.java_coding_test.rest_client;

import java.util.logging.Logger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    private static Logger logger = Logger.getLogger("Main");
    private static final String apiUrl = "http://localhost:8080/validate";

    public static void main( String[] args ){
        String url = apiUrl;

        if(args.length > 0){
            url = args[0];
        }

        logger.info(String.format("API URL: %s", url));

        try {
            Client client = Client.create();

            WebResource webResource = client.resource(url);

            String input = new TestData().toString();

            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, input);

            if (response.getStatus() != 200) {
                logger.warning("HTTP error code: "
                        + response.getStatus());
                return;
            }

            String output = response.getEntity(String.class);
            JSONArray json = new JSONArray(output);
            logger.info("Output from Server: "+json.toString(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
