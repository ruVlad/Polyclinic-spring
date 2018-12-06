package com.dev.service.impl;

import java.util.List;

import com.dev.dao.DoctorDAO;
import com.dev.model.Doctor;
import com.dev.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctorDAO;

	public void insert(Doctor doctor) {
		doctorDAO.addDoctor(doctor);
	}

	public void update(Doctor doctor) {
		doctorDAO.updateDoctor(doctor);
	}

	public Doctor getById(int id) {
		return doctorDAO.getDoctor(id);
	}

	public void delete(int id) {
		doctorDAO.deleteDoctor(id);
	}

	public List<Doctor> getAll() {
		return doctorDAO.getDoctors();
	}

}
