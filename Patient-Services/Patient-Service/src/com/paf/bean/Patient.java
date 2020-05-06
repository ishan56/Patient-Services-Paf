package com.paf.bean;

public class Patient {

	private String nic;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String email;
	private String password;
	
	public Patient() {
		
	}
	
	public Patient(String nic) {
		this.nic = nic;
	}



	public Patient(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Patient(String nic, String firstName, String lastName, String dob, String gender, String email,
			String password) {
		this.nic = nic;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
