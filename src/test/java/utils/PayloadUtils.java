package utils;

public class PayloadUtils {

    public static String getSlackMessagePayload(String message) {
        return "{\n" +
                "    \"text\":\"" + message + "\",\n" +
                "    \"channel\": \"C01TSUXQ7LL\"\n" +
                "    \n" +
                "}";
    }


    public static String getPetPayload(int petId) {
        return "{\n" +
                "    \"id\": "+ petId +", \n" +
                "    \"category\": {\n" +
                "        \"id\": 76\n" +
                "    },\n" +
                "    \"name\": \"Naida\",\n" +
                "    \"photoUrls\": [],\n" +
                "    \"tags\": [],\n" +
                "    \"status\": \"created from java code Gulya\"\n" +
                "}";

    }
}