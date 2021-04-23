//package API;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Map;
//
//public class apiFromHome {
//
//    //https://catfact.ninja/facts?limit=165
//
//
//    @Test
//    public void getResepons() throws URISyntaxException, IOException {
//
//        HttpClient client= HttpClientBuilder.create().build();
//        URIBuilder uriBuilder=new URIBuilder();
//        uriBuilder.setScheme("https")
//        .setHost("catfact.ninja")
//        .setPath("facts")
//        .setParameter("limit", "2");
//        HttpGet get=new HttpGet(uriBuilder.build());
//        get.setHeader("Accept", "application/json");
//
//        HttpResponse response=client.execute(get);
//        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
//
//        ObjectMapper objectMapper=new ObjectMapper();
//
//        Map<String, Object> linksList=objectMapper.readValue(response.getEntity().getContent(),
//                new TypeReference<Map<String, Object>>() {});
//
//        List<Map<String,Object>> responseList=(List<Map<String,Object>>) linksList.get("links");
//
//        for (Map<String, Object> map : responseList){
//
//            String temp=String.valueOf(map.get("url"));
//
//            if(temp != "null"){
//                HttpClient tempClient=HttpClientBuilder.create().build();
//                System.out.println(temp);
//                URIBuilder builder1=new URIBuilder();
//                HttpGet get1=new HttpGet(builder1.build());
//                get1.setHeader("Accept","application/json");
//
//                HttpResponse response1=tempClient.execute(get1);
//
//                Assert.assertEquals(HttpStatus.SC_OK,response1.getStatusLine().getStatusCode());
//
//
//            }
//        }
//
//
//
//
//
//
//    }
//
//
//
//
//}
