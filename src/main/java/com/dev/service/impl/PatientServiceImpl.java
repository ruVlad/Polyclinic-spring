package com.dev.service.impl;

import java.util.List;

import com.dev.dao.PatientDAO;
import com.dev.model.Patient;
import com.dev.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    public void insert(Patient patient) {
        patientDAO.addPatient(patient);
    }

    public void update(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    public Patient getById(int id) {
        return patientDAO.getPatient(id);
    }

    public void delete(int id) {
        patientDAO.deletePatient(id);
    }

    public List<Patient> getAll() {
        return patientDAO.getPatients();
    }

}
