package org.dimuthu.jax_ws.channeling.models;

public class Doctor {

	private int doctorId;
	
	private String doctorName;
	
	private DocSpecialty specialty;
	
	private int maxAppoinments;
	
	public Doctor(){}
	
	public Doctor(int doctorId,String doctorName,DocSpecialty specialty,int maxAppoinments){
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialty = specialty;
		this.maxAppoinments = maxAppoinments;
	}
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public DocSpecialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(DocSpecialty specialty) {
		this.specialty = specialty;
	}

	public int getMaxAppoinments() {
		return maxAppoinments;
	}

	public void setMaxAppoinments(int maxAppoinments) {
		this.maxAppoinments = maxAppoinments;
	}
	
}
