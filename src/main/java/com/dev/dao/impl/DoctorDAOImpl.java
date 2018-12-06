package com.dev.dao.impl;

import java.util.List;

import com.dev.dao.DoctorDAO;
import com.dev.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DoctorDAOImpl implements DoctorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	public void addDoctor(Doctor doctor) {
		getCurrentSession().save(doctor);
	}

	public void updateDoctor(Doctor doctor) {
		Doctor doctorUpdate = getDoctor(doctor.getId());
		doctorUpdate.setName(doctor.getName());
		doctorUpdate.setAge(doctor.getAge());
		doctorUpdate.setEmail(doctor.getEmail());
		getCurrentSession().update(doctorUpdate);

	}

	public Doctor getDoctor(int id) {
		Doctor doctor = (Doctor) getCurrentSession().get(Doctor.class, id);
		return doctor;
	}

	public void deleteDoctor(int id) {
		Doctor doctor = getDoctor(id);
		if (doctor != null)
			getCurrentSession().delete(doctor);

	}

	@SuppressWarnings("unchecked")
	public List<Doctor> getDoctors() {
		return getCurrentSession().createQuery("from Doctor").list();
	}

}
