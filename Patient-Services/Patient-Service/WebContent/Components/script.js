$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	
	$("#alertError").hide();
	
	// hide area of error messages
	$("#nic_error").hide();
	$("#fName_error").hide();
	$("#lName_error").hide();
	$("#dob_error").hide();
	$("#gender_error").hide();
	$("#email_error").hide();
	$("#password_error").hide();
	$("#retype-password_error").hide();
	
	// check number of characters for nic
	$("#nic").focusout(function() {
		vNic = checkNic();
	});

	// check email is valid or not
	$("#email").focusout(function() {
		vEmail = checkEmail();
	});

	// check minimum requirement of password
	$("#password").focusout(function() {
		vPassword = checkPassword();
	});

	// check matching password
	$("#retype-password").focusout(function() {
		vRetypePassword = checkRetypePassword();
	});
});

$(document).on("click", "#signin-button", function(event) {

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();


	var status = validateItemForm();

	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var method = ($("#hidField").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "PatientAPI",
		type : method,
		data : $("#registration-form").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});
});

$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidField").val(
					$(this).closest("tr").find('#hidFieldUpdate').val());
			$("#nic").val($(this).closest("tr").find('td:eq(0)').text());
			$("#first-name").val($(this).closest("tr").find('td:eq(1)').text());
			$("#last-name").val($(this).closest("tr").find('td:eq(2)').text());
			$("#dob").val($(this).closest("tr").find('td:eq(3)').text());
		//	$("#genderMale").val($(this).closest("tr").find('td:eq(3)').text());
			$("#email").val($(this).closest("tr").find('td:eq(5)').text());
			$("#password").val($(this).closest("tr").find('td:eq(6)').text());
		});

function onItemSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	
	$("#hidField").val("");
	$("#registration-form")[0].reset();
}

$(document).on("click", ".btnRemove", function(event)
		{
			$.ajax(
			{
				url : "PatientAPI",
				type : "DELETE",
				data : "nic=" + $(this).data("nic"),
				dataType : "text",
				complete : function(response, status)
				{
					onItemDeleteComplete(response.responseText, status);
				}
			});
		});

// Delete
function onItemDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} 
		else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} 
	else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}


// Validation
function validateItemForm()
{
	// nic is required
	if ($("#nic").val().trim() == "")
	{
		return "Insert Nic";
	}
	
	// name is required
	if ($("#first-name").val().trim() == "")
	{
		return "Insert First Name";
	}
	
	// last name is required
	if ($("#last-name").val().trim() == "")
	{
		return "Insert Last Name";
	}
	
	// dob is required
	if ($("#dob").val().trim() == "")
	{
		return "Insert DOB";
	}
	
	// email is required
	if ($("#email").val().trim() == "")
	{
		return "Insert Email";
	}
	
	// password is required
	if ($("#password").val().trim() == "")
	{
		return "Insert Password";
	}
	
	return true;
}

// NIC validation
function checkNic() {
	let nicLength = $("#nic").val().length;

	if (nicLength == 10 || nicLength == 12) {
		$("#nic_error").hide();
	} else {
		$("#nic_error").html("NIC should be 10 or 12 characters");
		$("#nic_error").show();
	}
}

// email validation
function checkEmail() {
	let email = $("#email").val().trim();
	let regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (regex.test(email)) {
		$("#email_error").hide();
	} else {
		$("#email_error").html("Enter valid email");
		$("#email_error").show();
	}
}

// password validation
function checkPassword() {
	let passwordLength = $("#password").val().length;

	if (passwordLength >= 8) {
		$("#password_error").hide();
	} else {
		$("#password_error").html("Password have at least 8 characters");
		$("#password_error").show();
	}
}

// retype password validation
function checkRetypePassword() {
	let passwordLength = $("#password").val();
	let retypePasswordLength = $("#retype-password").val();

	if (passwordLength == retypePasswordLength) {
		$("#retype-password_error").hide();
	} else {
		$("#retype-password_error").html("Passwords don't match");
		$("#retype-password_error").show();
	}
}