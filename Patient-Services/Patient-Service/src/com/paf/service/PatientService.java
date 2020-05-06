package com.paf.service;

import com.paf.bean.Patient;
import com.paf.model.PatientDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/patient")
public class PatientService {

	@POST
	@Path("/patient_registration")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String registerPatient(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = null;
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		status = PatientDAO.registerPatient(p);
		
		return "<h2>" + status + "</h2><br><br>" + 
		"<a href=\"http://localhost:8080/HelthCare/api/doctor/doctor_list\" target=\"_blank\">Available Doctores</a>";
	}
	
	@POST
	@Path("/patient_registration_and_selectDoctor")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String registerPatient2(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = null;
		
		String patientNIC = "/" + nic + "\"";
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		status = PatientDAO.registerPatient(p);
		
		return "<h2>" + status + "</h2><br><br>" + 
		"<a href=\"http://localhost:8080/HelthCare/api/doctor/doctor_list" + patientNIC + ">Available Doctores</a>";
	}
	
	@POST
	@Path("/patient_login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String loginPatient(@FormParam("email") String email,
			@FormParam("password") String password) {
		
		String status = "Invalid user";
		
		Patient p = new Patient(email, password);
		
		status = PatientDAO.patientLogin(p);
		
		return status;
	}
	
	@PUT
	@Path("/patient_update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(@FormParam("nic") String nic,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("dob") String dob,
			@FormParam("gender") String gender,
			@FormParam("email") String email,
			@FormParam("password") String password) {
		
		Patient p = new Patient(nic, firstName, lastName, dob, gender, email, password);
		
		String output = PatientDAO.updatePatient(p);
		
		return output;
	}
	
	@GET
	@Path("/patient_list")
	@Produces(MediaType.TEXT_HTML)
	public String getPatientList() {
		
		return PatientDAO.patientList();
		
	}
	
	@DELETE
	@Path("/delete_patient")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(@FormParam("nic") String nic) {
		
		Patient p = new Patient();
		
		p.setNic(nic);
		
		String output = PatientDAO.deletePatient(p);
		
		return output;
	}
	
}
