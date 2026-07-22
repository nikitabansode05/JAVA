package com.example.ai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ai.dto.GeminiRequest;
import com.example.ai.dto.GeminiResponse;
import com.example.ai.dto.Content;
import com.example.ai.dto.Part;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String askGemini(String prompt) {

        GeminiRequest request = new GeminiRequest(List.of(new Content(List.of(new Part(prompt)))));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GeminiRequest> entity =
                new HttpEntity<>(request, headers);

        String url = apiUrl + "?key=" + apiKey;

        ResponseEntity<GeminiResponse> response =restTemplate.postForEntity(url,entity,GeminiResponse.class);

        return response.getBody()
                .getCandidates()
                .get(0)
                .getContent()
                .getParts()
                .get(0)
                .getText();
    }

}