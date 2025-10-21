package util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CommonUtil {

    private final HttpClient httpClient;
    private final String accessCode;
    private final ObjectMapper objectMapper;

    public CommonUtil() {
        httpClient = HttpClient.newHttpClient();
        accessCode = "";
        objectMapper = new ObjectMapper();
    }

    public String getProblem(String url) {
        return getProblem(url, String.class);
    }

    public <T> T getProblem(String url, Class<T> tClass) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url.concat(accessCode)))
                    .GET()
                    .build();

            HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, stringBodyHandler);
            return stringToJsonObject(httpResponse.body(), tClass);
        } catch (Exception e) {
            System.out.println("\nError in getting problem, {}, {}, \n" + e.getClass().getName() + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String sendSolution(String url, Object solution) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url.concat(accessCode)))
                    .POST(HttpRequest.BodyPublishers.ofString(JsonObjectToString(solution)))
                    .build();

            HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, stringBodyHandler);
            return httpResponse.body();
        } catch (Exception e) {
            System.out.println("\nError in sending solution, {}, {}, \n" + e.getClass().getName() + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public <T> T stringToJsonObject(String input, Class<T> clazz){
        if (input == null || input.isEmpty()){
            System.out.println("\nInvalid input for serialization");
            return null;
        }
        try {
            return objectMapper.readValue(input, clazz);
        } catch (JsonProcessingException e) {
            System.out.println("\nerror in serialization {}\n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String JsonObjectToString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.out.println("\nerror in deserialization {}\n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
