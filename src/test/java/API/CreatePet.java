package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class CreatePet {

    @Test
    public  void createPetPath() throws URISyntaxException, IOException {
        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();

        //https://petstore.swagger.io/v2/pet/7565
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/");
        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Accept" , "application/json");
        httpPost.setHeader("Content-Type" , "application/json");

        String jsonBody="{\n" +
                "    \"id\": 7565,\n" +
                "    \"category\": {\n" +
                "        \"id\": 76\n" +
                "    },\n" +
                "    \"name\": \"Naida\",\n" +
                "    \"photoUrls\": [],\n" +
                "    \"tags\": [],\n" +
                "    \"status\": \"created from java code Gulya\"\n" +
                "}";
        HttpEntity requestBody=new StringEntity(jsonBody);
        httpPost.setEntity(requestBody);

        HttpResponse response =client.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

//
//        ObjectMapper objectMapper=new ObjectMapper();
//        Map<String, Object> parseRespond=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String,Object>>() {
//        });
//        System.out.println(parseRespond.get("id"));
//        System.out.println(parseRespond.get("name"));
//        System.out.println(parseRespond.get("status"));
//
//        Assert.assertEquals(7565, parseRespond.get("id"));
//        Assert.assertEquals("Naida", parseRespond.get("name"));
//        Assert.assertEquals("created from java code Gulya", parseRespond.get("status"));



    }


}
