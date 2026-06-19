package com.transflower.tflcomentor.AddConcept.entity;

public class FrameworkConcept {
    int id;
    int frameworkId;
    int conceptId;

    public FrameworkConcept() {
    }

    public FrameworkConcept(int id, int frameworkId, int conceptId) {
        this.id = id;
        this.frameworkId = frameworkId;
        this.conceptId = conceptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrameworkId() {
        return frameworkId;
    }

    public void setFrameworkId(int frameworkId) {
        this.frameworkId = frameworkId;
    }

    public int getConceptId() {
        return conceptId;
    }

    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

}
