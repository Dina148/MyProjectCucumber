package API;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import utils.Constants;
import utils.PayloadUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class GetPostDelete {

    @Test

    public void petTest() throws URISyntaxException, IOException {

        //https://petstore.swagger.io/v2/pet/2021
        int petId=2021;
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPost httpPost=new HttpPost(uriBuilder.build());
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Accept", "application/json");

        HttpEntity requestBody=new StringEntity(PayloadUtils.getPetPayload(petId));
        httpPost.setEntity(requestBody);

        HttpResponse httpResponse=httpClient.execute(httpPost);

        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        URIBuilder uriBuilder1=new URIBuilder();
        uriBuilder1.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/" + petId);
        HttpGet httpGet=new HttpGet(uriBuilder1.build());
        httpGet.setHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);
        HttpResponse getResponse=httpClient.execute(httpGet);

         Assert.assertEquals(HttpStatus.SC_OK, getResponse.getStatusLine().getStatusCode());


         ObjectMapper objectMapper=new ObjectMapper();

         Map<String, Object> petAPI=objectMapper.readValue(getResponse.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
         });


         int actualPetId=(int)petAPI.get("id");
         Assert.assertEquals(petId, actualPetId);

         //DELETE
        HttpDelete httpDelete=new HttpDelete(uriBuilder1.build());
        httpDelete.setHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);

       HttpResponse deleteResponse= httpClient.execute(httpDelete);
       Assert.assertEquals(HttpStatus.SC_OK, deleteResponse.getStatusLine().getStatusCode());








    }



}








