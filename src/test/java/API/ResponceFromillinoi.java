package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class ResponceFromillinoi {


    @Test
    public void validateCharacterNames() throws URISyntaxException, IOException {

        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        //   http://swapi.dev/api/people?page=1
        builder.setScheme("http");
        builder.setHost("swapi.dev");
        builder.setPath("api/people?page=1");

        HttpGet httpGet=new HttpGet(builder.build());
        //let server know that we expect response body in JSON format
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response=client.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());


        ObjectMapper objectMapper=new ObjectMapper();
        Map<String, Object> parsedResponse=objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> resultList=(List<Map<String, Object>>) parsedResponse.get("results");

    }
}
