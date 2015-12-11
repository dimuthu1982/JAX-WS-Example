package org.dimuthu.jax_ws.channeling.sei;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.dimuthu.jax_ws.channeling.exception.InvalidOperation;
import org.dimuthu.jax_ws.channeling.model.BookingStatus;
import org.dimuthu.jax_ws.channeling.models.BookedAppointment;
import org.dimuthu.jax_ws.channeling.service.AppointmentInformationService;


@WebService(serviceName="DoctorChanellingService", endpointInterface="org.dimuthu.jax_ws.channeling.sei.DocChanellingInterface", portName="DoctorChanellingPort")
public class DoctorChanelling implements DocChanellingInterface{

	@WebMethod(exclude=true)
	public static void main(String[] args){
		try {
			
			
			BookedAppointment appointment = AppointmentInformationService.getInstance().makeAppointment(200, "Dimuthu");
			System.out.println("\ngetAppointmentNumber : " + appointment.getAppointmentNumber());
			System.out.println("getPatientName : " + appointment.getPatientName());
			System.out.println("getDoctorsName : " + appointment.getDoctorsName());
			System.out.println("getSpecialty : " + appointment.getSpecialty());
			
			
			BookingStatus status = AppointmentInformationService.getInstance().checkDoctorBookingStatus(200);
			System.out.println("\n\tBoocking Status getMessage: " + status.getMessage());
			System.out.println("\tBoocking Status getDoctorsName: " + status.getDoctorsName());
			System.out.println("\tBoocking Status getSpecialty: " + status.getSpecialty());
			System.out.println("\tBoocking Status getNextAppointment: " + status.getNextAppointment());
			
			appointment = AppointmentInformationService.getInstance().makeAppointment(200, "Kasun");
			System.out.println("\ngetAppointmentNumber : " + appointment.getAppointmentNumber());
			System.out.println("getPatientName : " + appointment.getPatientName());
			System.out.println("getDoctorsName : " + appointment.getDoctorsName());
			System.out.println("getSpecialty : " + appointment.getSpecialty());
			
			String[] app = AppointmentInformationService.getInstance().findAllPatients(200);
			for (int i = 0; i < app.length; i++) {
				System.out.println(app[i]);
			}
			
			/*
			status = AppointmentInformationService.getInstance().checkDoctorBookingStatus(200);
			System.out.println("\n\tBoocking Status getMessage: " + status.getMessage());
			System.out.println("\tBoocking Status getDoctorsName: " + status.getDoctorsName());
			System.out.println("\tBoocking Status getSpecialty: " + status.getSpecialty());
			System.out.println("\tBoocking Status getNextAppointment: " + status.getNextAppointment());
			
			appointment = AppointmentInformationService.getInstance().makeAppointment(200, "Abeynayake");
			System.out.println("\ngetAppointmentNumber : " + appointment.getAppointmentNumber());
			System.out.println("getPatientName : " + appointment.getPatientName());
			System.out.println("getDoctorsName : " + appointment.getDoctorsName());
			System.out.println("getSpecialty : " + appointment.getSpecialty());
			
			status = AppointmentInformationService.getInstance().checkDoctorBookingStatus(200);
			System.out.println("\n\tBoocking Status getMessage: " + status.getMessage());
			System.out.println("\tBoocking Status getDoctorsName: " + status.getDoctorsName());
			System.out.println("\tBoocking Status getSpecialty: " + status.getSpecialty());
			System.out.println("\tBoocking Status getNextAppointment: " + status.getNextAppointment());
			
			appointment = AppointmentInformationService.getInstance().makeAppointment(140, "Abeynayake");
			System.out.println("\ngetAppointmentNumber : " + appointment.getAppointmentNumber());
			System.out.println("getPatientName : " + appointment.getPatientName());
			System.out.println("getDoctorsName : " + appointment.getDoctorsName());
			System.out.println("getSpecialty : " + appointment.getSpecialty());
			
			status = AppointmentInformationService.getInstance().checkDoctorBookingStatus(140);
			System.out.println("\n\tBoocking Status getMessage: " + status.getMessage());
			System.out.println("\tBoocking Status getDoctorsName: " + status.getDoctorsName());
			System.out.println("\tBoocking Status getSpecialty: " + status.getSpecialty());
			System.out.println("\tBoocking Status getNextAppointment: " + status.getNextAppointment());*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BookedAppointment makeAppointment(int doctorId, String patient) throws InvalidOperation {
		return AppointmentInformationService.getInstance().makeAppointment(doctorId, patient);
	}


	public BookingStatus checkDoctorBookingStatus(int doctorId) throws InvalidOperation {
		return AppointmentInformationService.getInstance().checkDoctorBookingStatus(doctorId);
	}

	public String[] findAllPatients(int doctorId) throws InvalidOperation {
		return AppointmentInformationService.getInstance().findAllPatients(doctorId);
	}
	
}
