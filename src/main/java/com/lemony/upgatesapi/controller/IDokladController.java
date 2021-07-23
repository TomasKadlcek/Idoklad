package com.lemony.upgatesapi.controller;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * USE
 * https://identity.idoklad.cz/server/connect/authorize?scope=idoklad_api%20offline_access&client_id=4dfacf7f-ac3a-4bf8-9815-4be40dea64f6&response_type=code&redirect_uri=http://localhost:8085/idoklad
 *
 */
@RestController
@RequestMapping("idoklad")
public class IDokladController {

    @GetMapping()
    public String getConnection(@RequestParam String code) {
        System.out.println("dsda");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", "4dfacf7f-ac3a-4bf8-9815-4be40dea64f6");
        map.add("client_secret", "6557f99c-6ab4-49ff-ad69-40a09a71fac7");
        map.add("scope", "idoklad_api%20offline_access");
        map.add("code", code);
        map.add("redirect_uri", "http://localhost:8085/idoklad");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity( "https://identity.idoklad.cz/server/connect/token", request , String.class );

        String jsonString = response.getBody();
        JSONObject obj = new JSONObject(jsonString);
        String refreshTokenString = obj.getString("refresh_token");

        return response.getBody() + " sasd sda" + refreshTokenString;


    }
}
