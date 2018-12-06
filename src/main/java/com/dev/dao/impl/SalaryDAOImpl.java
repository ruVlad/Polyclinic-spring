package com.dev.dao.impl;

import java.util.List;

import com.dev.dao.SalaryDAO;
import com.dev.dao.SalaryDAO;
import com.dev.model.Salary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalaryDAOImpl implements SalaryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSalary(Salary salary) {
        getCurrentSession().save(salary);
    }

    public void updateSalary(Salary salary) {
        Salary salaryUpdate = getSalary(salary.getId());
        salaryUpdate.setIdDoctor(salary.getIdDoctor());
        salaryUpdate.setSum(salary.getSum());
        getCurrentSession().update(salaryUpdate);

    }

    public Salary getSalary(int id) {
        Salary salary = (Salary) getCurrentSession().get(Salary.class, id);
        return salary;
    }

    public void deleteSalary(int id) {
        Salary salary = getSalary(id);
        if (salary != null)
            getCurrentSession().delete(salary);
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getSalaries() {
        return getCurrentSession().createQuery("from Salary").list();
    }

}
