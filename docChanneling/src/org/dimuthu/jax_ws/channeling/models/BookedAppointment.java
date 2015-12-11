package org.dimuthu.jax_ws.channeling.models;

public class BookedAppointment {

	private String patientName;
	
	private int appointmentNumber;
	
	private String doctorsName;
	
	private String specialty;
	
	public BookedAppointment(String patientName, int appointmentNumber,String doctorsName, String specialty) {
		this.patientName = patientName;
		this.appointmentNumber = appointmentNumber;
		this.doctorsName = doctorsName;
		this.specialty = specialty;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(int appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public String getDoctorsName() {
		return doctorsName;
	}

	public void setDoctorsName(String doctorsName) {
		this.doctorsName = doctorsName;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
}
