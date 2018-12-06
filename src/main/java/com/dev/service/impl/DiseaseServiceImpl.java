package com.dev.service.impl;

import java.util.List;

import com.dev.dao.DiseaseDAO;
import com.dev.dao.DiseaseDAO;
import com.dev.model.Disease;
import com.dev.service.DiseaseService;
import com.dev.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseDAO diseaseDAO;

    public void insert(Disease disease) {
        diseaseDAO.addDisease(disease);
    }

    public void update(Disease disease) {
        diseaseDAO.updateDisease(disease);
    }

    public Disease getById(int id) {
        return diseaseDAO.getDisease(id);
    }

    public void delete(int id) {
        diseaseDAO.deleteDisease(id);
    }

    public List<Disease> getAll() {
        return diseaseDAO.getDiseases();
    }

}
