package org.dimuthu.jax_ws.channeling.service;

import java.util.HashMap;
import java.util.Map;

import org.dimuthu.jax_ws.channeling.models.DocSpecialty;
import org.dimuthu.jax_ws.channeling.models.Doctor;

public class DoctorInformationService {

	private static DoctorInformationService service = new DoctorInformationService();
	
	private Map<Integer,Doctor> holder = new HashMap<>();

	private DoctorInformationService(){

		holder.put(200, new Doctor(200,"A.A Perera",DocSpecialty.DERMATOLOGIST,3));
		holder.put(230, new Doctor(230,"Kamal Gunarathne",DocSpecialty.DERMATOLOGIST,3));

		holder.put(130, new Doctor(130,"M.T Guruge",DocSpecialty.PEDIATRICIAN,2));
		holder.put(140, new Doctor(140,"Ajith Bandara",DocSpecialty.PEDIATRICIAN,3));
	}
	
	
	public static DoctorInformationService getInstance(){
		return service;
	}


	boolean isDoctorRegistered(int doctorId) {
		return holder.containsKey(doctorId);
	}


	boolean isDoctorAvailable(int doctorId, int appointmentsTaken) {
		return getDoctor(doctorId).getMaxAppoinments() > appointmentsTaken;
	}


	public Doctor getDoctor(int doctorId) {
		return holder.get(doctorId);
	}

}
