package com.transflower.tflcomentor.AddConcept.dto;

public class FrameworkConceptDTO {
    int conceptId;
    int frameworkId;
    private String name;
    private String description;

    public FrameworkConceptDTO() {
    }

    public FrameworkConceptDTO(int conceptId, int frameworkId, String name, String description) {
        this.conceptId = conceptId;
        this.frameworkId = frameworkId;
        this.name = name;
        this.description = description;
    }

    public int getConceptId() {
        return conceptId;
    }

    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

    public int getFrameworkId() {
        return frameworkId;
    }

    public void setFrameworkId(int frameworkId) {
        this.frameworkId = frameworkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
