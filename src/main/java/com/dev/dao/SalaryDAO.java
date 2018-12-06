package com.dev.dao;

import java.util.List;

import com.dev.model.Doctor;
import com.dev.model.Salary;

public interface SalaryDAO {

    public void addSalary(Salary salary);
    public void updateSalary(Salary salary);
    public Salary getSalary(int id);
    public void deleteSalary(int id);
    public List<Salary> getSalaries();

}
