package com.dev.dao;

import java.util.List;

import com.dev.model.Disease;
import com.dev.model.Doctor;

public interface DiseaseDAO{

    public void addDisease(Disease disease);
    public void updateDisease(Disease disease);
    public Disease getDisease(int id);
    public void deleteDisease(int id);
    public List<Disease> getDiseases();

}
