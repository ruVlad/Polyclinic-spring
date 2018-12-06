package com.dev.service;

import java.util.List;

import com.dev.model.Doctor;

public interface DoctorService {
	
	public void insert(Doctor doctor);
	public void update(Doctor doctor);
	public Doctor getById(int id);
	public void delete(int id);
	public List<Doctor> getAll();

}
