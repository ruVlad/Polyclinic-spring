package com.dev.dao.impl;

import java.util.List;

import com.dev.dao.PatientDAO;
import com.dev.dao.PatientDAO;
import com.dev.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl implements PatientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addPatient(Patient patient) {
        getCurrentSession().save(patient);
    }

    public void updatePatient(Patient patient) {
        Patient patientUpdate = getPatient(patient.getId());
        patientUpdate.setName(patient.getName());
        patientUpdate.setAge(patient.getAge());
        getCurrentSession().update(patientUpdate);

    }

    public Patient getPatient(int id) {
        Patient patient = (Patient) getCurrentSession().get(Patient.class, id);
        return patient;
    }

    public void deletePatient(int id) {
        Patient patient = getPatient(id);
        if (patient != null)
            getCurrentSession().delete(patient);
    }

    @SuppressWarnings("unchecked")
    public List<Patient> getPatients() {
        return getCurrentSession().createQuery("from Patient").list();
    }

}
