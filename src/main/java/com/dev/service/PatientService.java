package com.dev.service;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.Patient;

public interface PatientService {

    public void insert(Patient patient);
    public void update(Patient patient);
    public Patient getById(int id);
    public void delete(int id);
    public List<Patient> getAll();

}
