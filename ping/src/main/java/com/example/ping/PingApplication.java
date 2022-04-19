package com.example.ping;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class PingApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(PingApplication.class, args);
        String serverUrl = "http://pong-service:8080/ping-pong";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("text", "Zdarova, eto Ping..." +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));

        HttpEntity<String> request =
                new HttpEntity<String>(jsonObject.toString(), httpHeaders);

        while (true) {
            String personResultAsJsonStr =
                    restTemplate.postForObject(serverUrl, request, String.class);
            System.out.println("Ping - ping - ping...");
            Thread.sleep(3000);
        }
    }
}
