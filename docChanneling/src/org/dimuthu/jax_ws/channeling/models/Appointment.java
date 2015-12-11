package org.dimuthu.jax_ws.channeling.models;

public class Appointment {

	private int appointmentNo;
	
	private String patient;
	
	private Doctor doctor;

	public Appointment(int appointmentNo,String patient,Doctor doctor){
		this.appointmentNo = appointmentNo;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	public int getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(int appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}
