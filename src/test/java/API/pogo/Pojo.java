package API.pogo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import utils.Constants;

import java.io.IOException;
import java.net.URISyntaxException;

public class Pojo {
    @Test

    public void getPetPogoTest() throws URISyntaxException, IOException {

        HttpClient httpClient= HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder("https://petstore.swagger.io/v2/pet/2022");

        HttpGet httpGet=new HttpGet(uriBuilder.build());
        httpGet.setHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);

        HttpResponse response=httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        PetPojo parsePet=objectMapper.readValue(response.getEntity().getContent(), PetPojo.class);
        Assert.assertEquals(2022, parsePet.getId());
        Assert.assertEquals("Naida", parsePet.getName());

    }
}
