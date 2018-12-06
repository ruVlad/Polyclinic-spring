package com.dev.service.impl;

import java.util.List;

import com.dev.dao.SalaryDAO;
import com.dev.model.Salary;
import com.dev.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDAO salaryDAO;

    public void insert(Salary salary) {
        salaryDAO.addSalary(salary);
    }

    public void update(Salary salary) {
        salaryDAO.updateSalary(salary);
    }

    public Salary getById(int id) {
        return salaryDAO.getSalary(id);
    }

    public void delete(int id) {
        salaryDAO.deleteSalary(id);
    }

    public List<Salary> getAll() {
        return salaryDAO.getSalaries();
    }

}
