package API;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
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

public class UpdatePet {

    @Test
    public  void updatePetTest() throws URISyntaxException, IOException {

        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder builder=new URIBuilder();
        builder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet");

        HttpPut httpPut=new HttpPut(builder.build());
        httpPut.setHeader(Constants.ACCEPT, Constants.APPLICATION_JSON);
        httpPut.setHeader(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);

        HttpEntity putReqBody=new StringEntity(PayloadUtils.getPetPayload(2022));
        httpPut.setEntity(putReqBody);
        HttpResponse response=client.execute(httpPut);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());






    }
}
