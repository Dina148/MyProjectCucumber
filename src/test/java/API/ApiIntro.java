package API;


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

public class ApiIntro {
/*
1.Launch POSTMAN/client
2.Find/provide an endpoint / URL
3.Define a HTTP request(action)
4. Send/execute a request
5.Check the status code
 */
    @Test
    public void getTest() throws URISyntaxException, IOException {
        //aunch POSTMAN/client
        HttpClient client = HttpClientBuilder.create().build();
        //2.
        //https://corona.lmao.ninja/v2/countries/Italy
        //2.Find/provide an endpoint / URL
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/countries/Italy");

       // 3.Define a HTTP request(action)
        HttpGet get=new HttpGet(uriBuilder.build());

        //4. Send/execute a request
        HttpResponse response = client.execute(get);

        //5.Check the status code
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

    }

    @Test
    public void getTest1() throws URISyntaxException, IOException {
        //https://corona.lmao.ninja/v2/states/Texas
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states/Texas");

        HttpGet get=new HttpGet(uriBuilder.build());
        HttpResponse response=client.execute(get);
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("Get request has a response status code" +statusCode );
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());


    }

    @Test
    public void getTest2() throws URISyntaxException, IOException {

        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/789");
        HttpGet get=new HttpGet(uriBuilder.build());
        HttpResponse response=client.execute(get);
        System.out.println("");
        Assert.assertFalse(response.getStatusLine().getStatusCode() == 404);
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());

    }
    @Test
    public void  getTest3() throws IOException, URISyntaxException {
       HttpClient client=HttpClientBuilder.create().build();

       URIBuilder builder=new URIBuilder();
       builder.setScheme("https").setHost("corona.lmao.ninja").setPath("v2/states/Texas");
       HttpGet get=new HttpGet(builder.build());
       HttpResponse response=client.execute(get);
       System.out.println("Get request has a response of "+response.getStatusLine().getStatusCode());
       Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }
    @Test
    public void petTest1() throws URISyntaxException, IOException {

        HttpClient client=HttpClientBuilder.create().build();

        URIBuilder builder=new URIBuilder();
        builder.setScheme("https").setHost("petstore.swagger.io").setPath("v2/pet/789");
        HttpGet get=new HttpGet(builder.build());
        HttpResponse response=client.execute(get);
        System.out.println(response.getEntity().getContent());

    }


}
