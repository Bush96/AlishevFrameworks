package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RestTemplate restTemlate = new RestTemplate();
//___________________get______________________
//        String url = "https://reqres.in/api/users/2";
//        String response = restTemlate.getForObject(url, String.class);
//        System.out.println(response);
//___________________post______________________
//        Map<String, String> jsonToSend = new HashMap<>();
//        jsonToSend.put ("name", "Test name");
//        jsonToSend.put("job", "Test job");
//
//        String url = "https://reqres.in/api/users";
//        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
//        String response = restTemlate.postForObject(url, request, String.class);
//        System.out.println(response);
//    }
        //___________________Парсим json так ______________________
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = mapper.readTree(response);

//        и тут по ключам из всего джейсона можем достать именно тот элемент или ту часть текса которая нам необходима
//        но обычно для этого содаетс класс котоырй постоянно этим занимается
//        ключи в джэйсоне соответствуют полям в джлалвла клалссе, нужно создать класс с талкими полями
    }}