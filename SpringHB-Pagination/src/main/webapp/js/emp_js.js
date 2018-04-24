"use strict";
function validate_form() {
       
			if (document.emp.ename.value == "") {
                alert("Please fill in the 'Your Employee Name' box.");
                return false;
            }

            if (document.emp.eage.value == "") {
                alert("Enter Employee Age");
                return false;
            }

            //alert("sucessfully Submitted");
			 if (document.emp.email.value == "") {
                alert("Enter Employee  Email");
                return false;
            }
           
            if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(document.emp.email.value)) {
                alert("You have entered an invalid email address!")
                return false;
            }
			
        }//function
 
        function isNumberKey(evt) {
            var charCode = (evt.which) ? evt.which : event.keyCode;
            if (charCode != 46 && charCode > 31 &&
                (charCode < 48 || charCode > 57)) {
                alert("Enter Number Only boss");
                return false;
            }
            return true;
        }