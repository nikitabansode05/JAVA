package com.example.ai.dto;

import java.util.List;

public class Content {

    private List<Part> parts;

    public Content() {}

    public Content(List<Part> parts) {
        this.parts = parts;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}