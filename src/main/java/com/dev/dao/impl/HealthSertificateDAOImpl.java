package com.dev.dao.impl;

import java.util.List;

import com.dev.dao.HealthSertificateDAO;
import com.dev.dao.HealthSertificateDAO;
import com.dev.model.HealthSertificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HealthSertificateDAOImpl implements HealthSertificateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addHealthSertificate(HealthSertificate healthSertificate) {
        getCurrentSession().save(healthSertificate);
    }

    public void updateHealthSertificate(HealthSertificate healthSertificate) {
        HealthSertificate healthSertificateUpdate = getHealthSertificate(healthSertificate.getId());
        healthSertificateUpdate.setIdDiseases(healthSertificate.getIdDiseases());
        healthSertificateUpdate.setIdDoctor(healthSertificate.getIdDiseases());
        healthSertificateUpdate.setIdPatient(healthSertificate.getIdPatient());
        healthSertificateUpdate.setDateOfIssue(healthSertificate.getDateOfIssue());
        healthSertificateUpdate.setExpiryDate(healthSertificate.getExpiryDate());
        getCurrentSession().update(healthSertificateUpdate);

    }

    public HealthSertificate getHealthSertificate(int id) {
        HealthSertificate healthSertificate = (HealthSertificate) getCurrentSession().get(HealthSertificate.class, id);
        return healthSertificate;
    }

    public void deleteHealthSertificate(int id) {
        HealthSertificate healthSertificate = getHealthSertificate(id);
        if (healthSertificate != null)
            getCurrentSession().delete(healthSertificate);
    }

    @SuppressWarnings("unchecked")
    public List<HealthSertificate> getHealthSertificates() {
        return getCurrentSession().createQuery("from HealthSertificate").list();
    }

}
