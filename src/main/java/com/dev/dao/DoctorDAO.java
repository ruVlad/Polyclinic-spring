package com.dev.dao;

import java.util.List;

import com.dev.model.Doctor;

public interface DoctorDAO {
	
	public void addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public Doctor getDoctor(int id);
	public void deleteDoctor(int id);
	public List<Doctor> getDoctors();

}
