package org.dimuthu.jax_ws.channeling.sei;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.dimuthu.jax_ws.channeling.exception.InvalidOperation;
import org.dimuthu.jax_ws.channeling.model.BookingStatus;
import org.dimuthu.jax_ws.channeling.models.BookedAppointment;

@WebService(name="docChanelling", targetNamespace="http://www.chanelling.com")
public interface DocChanellingInterface {

	@WebMethod(operationName="makeAppointment")
	@WebResult(name="BookingInformation")
	public BookedAppointment makeAppointment(@WebParam(name="doctorId")int doctorId, @XmlElement(required=true) @WebParam(name="patientName") String patient) throws InvalidOperation;
	
	@WebMethod(operationName="checkDoctorBookingStatus")
	@WebResult(name="bookingStatus")
	public BookingStatus checkDoctorBookingStatus(@WebParam(name="doctorId") int doctorId) throws InvalidOperation;
	
	@WebMethod(operationName="findBookedPatients")
	@WebResult(name="patientNames")
	public String[] findAllPatients(@WebParam(name="doctorId") int doctorId) throws InvalidOperation;
}
