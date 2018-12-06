package com.dev.dao.impl;

import java.util.List;

import com.dev.dao.DiseaseDAO;
import com.dev.dao.DiseaseDAO;
import com.dev.model.Disease;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DiseaseDAOImpl implements DiseaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addDisease(Disease disease) {
        getCurrentSession().save(disease);
    }

    public void updateDisease(Disease disease) {
        Disease diseaseUpdate = getDisease(disease.getId());
        diseaseUpdate.setName(disease.getName());
        diseaseUpdate.setComment(disease.getComment());
        getCurrentSession().update(diseaseUpdate);

    }

    public Disease getDisease(int id) {
        Disease disease = (Disease) getCurrentSession().get(Disease.class, id);
        return disease;
    }

    public void deleteDisease(int id) {
        Disease disease = getDisease(id);
        if (disease != null)
            getCurrentSession().delete(disease);
    }

    @SuppressWarnings("unchecked")
    public List<Disease> getDiseases() {
        return getCurrentSession().createQuery("from Disease").list();
    }

}
