<%@page import="com.paf.model.PatientDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register</title>

<!-- Style -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="Views/style.css">
<link rel="stylesheet" href="Views/bootstrap.min.css">

<!-- jQuery -->
<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/script.js"></script>

</head>
<body>

	<div class="container">
        <fieldset>
            <h3>
                <span>Patient Management</span>
            </h3>

            <form id="registration-form" name="registration-form" action="patient-register.jsp">
            
            	<!-- NIC -->
                <div class="form-group row">
                    <label for="nic" class="col-sm-2 col-form-label">NIC <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="text" name="nic" id="nic" class="form-control">
                        <span class="error_message" id="nic_error"></span>
                    </div>
                </div>
                
                <!-- first name -->
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">First Name <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="text" name="firstName" class="form-control" id="first-name">
                        <span class="error_message" id="fName_error"></span>
                    </div>
                </div>
                
                <!-- last name -->
                <div class="form-group row">
                    <label for="last_name" class="col-sm-2 col-form-label">Last Name <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="text" name="lastName" class="form-control" id="last-name">
                        <span class="error_message" id="lName_error"></span>
                    </div>
                </div>
                
                <!-- DOB -->
                <div class="form-group row">
                    <label for="dob" class="col-sm-2 col-form-label">Date of Birth <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="date" name="dob" class="form-control" id="dob">
                        <span class="error_message" id="dob_error"></span>
                    </div>
                </div>
                
                <!-- gender -->
                <fieldset class="form-group">
                    <div class="row">
                      <legend class="col-form-label col-sm-2 pt-0">Gender <span class="required-sign">(*)</span></legend>
                      <div class="col-sm-10">
                        <div class="form-check">
                          <input class="form-check-input" id="genderMale" type="radio" name="gender" value="male" checked>
                          <label class="form-check-label" for="male">
                            Male
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" id="genderFemale" type="radio" name="gender" value="female">
                          <label class="form-check-label" for="female">
                            Female
                          </label>
                        </div>
                        <span class="error_message" id="gender_error"></span>
                      </div>
                    </div>
                </fieldset>
                
                <!-- email -->
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="email" name="email" id="email" class="form-control">
                        <span class="error_message" id="email_error"></span>
                    </div>
                </div>
                
                <!-- password -->
                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="password">
                        <span class="error_message" id="password_error"></span>
                    </div>
                </div>
                
                <!--retype password -->
                <div class="form-group row">
                    <label for="retype_password" class="col-sm-2 col-form-label">Retype Password <span class="required-sign">(*)</span></label>
                    <div class="col-sm-10">
                        <input type="password" name="retype_password" class="form-control" id="retype-password">
                        <span class="error_message" id="retype-password_error"></span>
                    </div>
                </div>
                
                <!-- hidden field -->
                <input type="hidden" id="hidField" name="hidField" value="">
                
                <!-- sign in button -->
                <div class="form-group row">
                    <div class="col-sm-10">
                      <input name="btnSave" type="button" value="save" class="btn btn-success" id="signin-button">
                    </div>
                </div>
                
            </form>
             
        </fieldset>

    </div>

	<hr>

	<div class="continer-fluid">
		<div class="row">
		
			<!-- Table -->
			<div class="col-sm-8" id="#divItemsGrid">
				<h3>Patient Details</h3>
				<%=PatientDAO.patientList() %>
			</div>
			
			<!-- Status -->
			<div class="col-sm-4">
				<div id="alertSuccess" class="alert alert-success alertArea"></div>
				<div id="alertError" class="alert alert-danger alertArea"></div>
			</div>
			
		</div>
	</div>

</body>
</html>