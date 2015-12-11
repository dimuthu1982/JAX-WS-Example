package org.dimuthu.jax_ws.channeling.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dimuthu.jax_ws.channeling.exception.InvalidOperation;
import org.dimuthu.jax_ws.channeling.model.BookingStatus;
import org.dimuthu.jax_ws.channeling.models.Appointment;
import org.dimuthu.jax_ws.channeling.models.BookedAppointment;

public class AppointmentInformationService {

	private static AppointmentInformationService service = new AppointmentInformationService();
	
	private Map<Integer,List<Appointment>> holder = new HashMap<>();
	
	private AppointmentInformationService(){}
	
	public static AppointmentInformationService getInstance(){
		return service;
	}
	
	public BookedAppointment makeAppointment(int doctorId, String patient) throws InvalidOperation{
		

		Appointment newAppointment = makeNewAppointment(doctorId, patient);

		if(holder.containsKey(doctorId) == false){
			List<Appointment> newApoinment =  new ArrayList<Appointment>();
			newApoinment.add(newAppointment);
			
			holder.put(doctorId, newApoinment);
			
		}else{
			holder.get(doctorId).add(newAppointment);
		}
		
		return prepareAppointmentInfor(newAppointment);
	}
	
	private void validateDoctor(int doctorId) throws InvalidOperation{
		if( DoctorInformationService.getInstance().isDoctorRegistered(doctorId) == false){
			throw new InvalidOperation("No Doctor Found By the ID " + doctorId);
		}

		if(isDoctorAvailable(doctorId) == false){
			throw new InvalidOperation("All Appointments Are Taken");
		}
	}
	
	
	public BookingStatus checkDoctorBookingStatus(int doctorId) throws InvalidOperation{
		
		validateDoctor(doctorId);
		
		if(isDoctorAvailable(doctorId)){
			int lastAppointment = holder.containsKey(doctorId) == false ? 0 : holder.get(doctorId).size();
			
			return new BookingStatus("Booking Available",
									  DoctorInformationService.getInstance().getDoctor(doctorId).getDoctorName(),
									  DoctorInformationService.getInstance().getDoctor(doctorId).getSpecialty().toString(),
									  (lastAppointment +1));
			
		}else{
			return new BookingStatus("No Booking Available");	
			
		}
		
	}
	
	boolean isDoctorAvailable(int doctorId){
		if(holder.containsKey(doctorId) == false) return true;
		
		return DoctorInformationService.getInstance().isDoctorAvailable(doctorId,holder.get(doctorId).size());
	}

	public String[] findAllPatients(int doctorId) throws InvalidOperation {
		validateDoctor(doctorId);
		List<Appointment> appoinments = holder.get(doctorId);
		
		String[] allPatients = new String[appoinments.size()];
		
		for (int i = 0; i < allPatients.length; i++) {
			allPatients[i] = appoinments.get(i).getPatient() + " Appoinment Number " + appoinments.get(i).getAppointmentNo();
		}
		
		return allPatients;
	}
	
	private BookedAppointment prepareAppointmentInfor(Appointment newAppointment) {
		return new BookedAppointment(newAppointment.getPatient(),
									 newAppointment.getAppointmentNo(),
									 newAppointment.getDoctor().getDoctorName(),
									 newAppointment.getDoctor().getSpecialty().toString());
	}

	private synchronized Appointment makeNewAppointment(int doctorId, String patient) {
		return new Appointment( (holder.containsKey(doctorId) == false ? 1 : holder.get(doctorId).size() +1),
							   patient,
							   DoctorInformationService.getInstance().getDoctor(doctorId));
	}

}
