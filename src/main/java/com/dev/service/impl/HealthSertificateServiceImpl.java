package com.dev.service.impl;

import java.util.List;

import com.dev.dao.HealthSertificateDAO;
import com.dev.model.HealthSertificate;
import com.dev.service.HealthSertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HealthSertificateServiceImpl implements HealthSertificateService {

    @Autowired
    private HealthSertificateDAO healthSertificateDAO;

    public void insert(HealthSertificate healthSertificate) {
        healthSertificateDAO.addHealthSertificate(healthSertificate);
    }

    public void update(HealthSertificate healthSertificate) {
        healthSertificateDAO.updateHealthSertificate(healthSertificate);
    }

    public HealthSertificate getById(int id) {
        return healthSertificateDAO.getHealthSertificate(id);
    }

    public void delete(int id) {
        healthSertificateDAO.deleteHealthSertificate(id);
    }

    public List<HealthSertificate> getAll() {
        return healthSertificateDAO.getHealthSertificates();
    }

}
