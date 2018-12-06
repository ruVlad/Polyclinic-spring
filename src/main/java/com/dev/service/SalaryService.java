package com.dev.service;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.Salary;

public interface SalaryService {

    public void insert(Salary salary);
    public void update(Salary salary);
    public Salary getById(int id);
    public void delete(int id);
    public List<Salary> getAll();

}
