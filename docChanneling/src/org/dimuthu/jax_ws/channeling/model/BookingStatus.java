package org.dimuthu.jax_ws.channeling.model;

public class BookingStatus {

	private String message;
	
	private String doctorsName;
	
	private String specialty;
	
	private int nextAppointment;
	
	public BookingStatus(){
	}
	
	public BookingStatus(String message){
		this.message = message;
	}
	
	public BookingStatus(String message, String doctorsName, String specialty,int nextAppointment) {
		this.message = message;
		this.doctorsName = doctorsName;
		this.specialty = specialty;
		this.nextAppointment = nextAppointment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getNextAppointment() {
		return nextAppointment;
	}

	public void setNextAppointment(int nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
}
