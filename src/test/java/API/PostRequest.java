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
import utils.Constants;
import utils.PayloadUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

public class PostRequest {


    @Test
    public void postResponse() throws URISyntaxException, IOException {


        HttpClient client= HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        //https://slack.com/api/chat.postMessage
        builder.setScheme("https").setHost("slack.com").setPath("api/chat.postMessage");

        HttpPost httpPost=new HttpPost(builder.build());
        httpPost.setHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);
        httpPost.setHeader(Constants.CONTENT_TYPE , Constants.APPLICATION_JSON);
        httpPost.setHeader(Constants.AUTHORIZATION , "Bearer xoxb-1474998748244-1962618617536-P6kebmsEIzBmNlVO6ts1HRTP");



        HttpEntity requestBody=new StringEntity(PayloadUtils.getSlackMessagePayload("Hello from POSTMAN"));

        httpPost.setEntity(requestBody);

        HttpResponse responseBody = client.execute(httpPost);
        Assert.assertEquals(HttpStatus.SC_OK, responseBody.getStatusLine().getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,  Object> parseResponse=objectMapper.readValue(responseBody.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Assert.assertEquals("C01TSUXQ7LL", parseResponse.get("channel") );


    }




}
