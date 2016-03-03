// validate the username field.
window.Parsley.addValidator('usernamecheck',
	{
		requirementType: 'regexp',
     	validateString: function(value, requirement) {
	     	return requirement.test(value);
	     },
	     messages: {
	     	en: 'The user name must be at least 6 characters long and up to 35 characters. Only lower case letters, numbers, an underscore, or hyphen are allowed!'
	     }
	}
);

// validate the password field.
window.Parsley.addValidator('passwordcheck',
	{
		requirementType: 'regexp',
     	validateString: function(value, requirement) {
	     	return requirement.test(value);
	     },
	     messages: {
	     	en: 'The password must have at least one number, one lower and upper case letter, and one of the special symbols: \'@\', \'#\', \'$\', \'%\'.<br/>The length must be between 6 to 20 characters.'
	     }
	}
);

// for registration page, to validate the username by querying the database?
function checkForUserName() {
	var usernameValue = document.getElementById('userName').value; 
	
	$.ajax( 
	{ 
		type: "GET",
		url: "/userNameCheckDB",
		data: 'userName=' + usernameValue,
		success: function(msg)
		{	
			//document.getElementById("userNameError").show();
			$("#userNameError").show();
			document.getElementById("userNameError").innerHTML=usernameValue + " is taken";
			document.getElementById("register").disabled = true;
		},
		error: function() {
			document.getElementById("userNameError").innerHTML='';
			document.getElementById("register").disabled = false;
			$("#userNameError").hide();
			//document.getElementById("userNameError").hide();
		}

	});	

}