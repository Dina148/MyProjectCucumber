package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ResponsDeserialization {


    @Test
    public void  respDeserialization() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        //https://petstore.swagger.io/v2/pet/789
        builder.setScheme("https");
        builder.setHost("petstore.swagger.io");
        builder.setPath("/v2/pet/789");

        HttpGet httpGet=new HttpGet(builder.build());
        //let server know that we expect response  in JSON format
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response=client.execute(httpGet);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        HttpEntity responseBody=response.getEntity();
        //System.out.println(EntityUtils.toString(responseBody));

        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> responseMap=objectMapper.readValue(responseBody.getContent(), new TypeReference<Map<String, Object>>() {
        });

        System.out.println(responseMap.get("name"));
        System.out.println(responseMap.get("status"));

        Assert.assertEquals(789, responseMap.get("id"));
    }
    @Test
    public void covidResponseTest() throws URISyntaxException, IOException {
        HttpClient client=HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        //https://corona.lmao.ninja/v2/states/Illinois
        builder.setScheme("https");
        builder.setHost("corona.lmao.ninja");
        builder.setPath("/v2/states/Illinois");

        HttpGet httpGet=new HttpGet(builder.build());
        //let server know that we expect response body in JSON format
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response=client.execute(httpGet);

        HttpEntity responseBody=response.getEntity();
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> responseMap=objectMapper.readValue(responseBody.getContent(), new TypeReference<Map<String, Object>>() {
        });
       Assert.assertEquals("Illinois", responseMap.get("state"));
       Assert.assertTrue(12671821 == (int)responseMap.get("population"));
    }
}
