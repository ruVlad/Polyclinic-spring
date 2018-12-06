package com.dev.dao;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.HealthSertificate;

public interface HealthSertificateDAO {

    public void addHealthSertificate(HealthSertificate healthSertificate);
    public void updateHealthSertificate(HealthSertificate healthSertificate);
    public HealthSertificate getHealthSertificate(int id);
    public void deleteHealthSertificate(int id);
    public List<HealthSertificate> getHealthSertificates();

}
