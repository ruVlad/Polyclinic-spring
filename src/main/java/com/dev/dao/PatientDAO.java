package com.dev.dao;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.Patient;

public interface PatientDAO {

    public void addPatient(Patient patient);
    public void updatePatient(Patient patient);
    public Patient getPatient(int id);
    public void deletePatient(int id);
    public List<Patient> getPatients();

}
