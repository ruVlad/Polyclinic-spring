package com.dev.service;

import java.util.List;

import com.dev.model.Disease;
import com.dev.model.Doctor;

public interface DiseaseService {

    public void insert(Disease disease);
    public void update(Disease disease);
    public Disease getById(int id);
    public void delete(int id);
    public List<Disease> getAll();

}
