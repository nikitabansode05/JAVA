package com.example.ai.dto;

import java.util.List;

public class GeminiRequest {

    private List<Content> contents;

    public GeminiRequest() {}

    public GeminiRequest(List<Content> contents) {
        this.contents = contents;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}