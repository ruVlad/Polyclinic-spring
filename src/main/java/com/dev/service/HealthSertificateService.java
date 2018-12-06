package com.dev.service;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.HealthSertificate;

public interface HealthSertificateService {

    public void insert(HealthSertificate healthSertificate);
    public void update(HealthSertificate healthSertificate);
    public HealthSertificate getById(int id);
    public void delete(int id);
    public List<HealthSertificate> getAll();

}
