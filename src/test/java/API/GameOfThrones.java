package API;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class GameOfThrones {


    @Test
    public  void gameOfThrones(){
        HttpClient httpClient= HttpClientBuilder.create().build();
        URIBuilder builder=new URIBuilder();
        builder.setScheme("http").setHost("").setPath("");
        HttpGet get=new HttpGet();


    }


}
