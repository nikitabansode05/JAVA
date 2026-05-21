package com.transflower.tflcomentor.AddConcept.repository;

import com.transflower.tflcomentor.AddConcept.dto.FrameworkConceptDTO;
import com.transflower.tflcomentor.AddConcept.entity.Concept;

public interface IConceptRepository {
    public Concept addConcept(FrameworkConceptDTO concept);
}
