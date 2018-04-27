<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Add Users using ajax</title>

   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script type="text/javascript">

        function doAjaxPost() {

        // get the form values

        var name = $('#name').val();

        var education = $('#education').val();

       alert("name "+name+"  "+education);

        $.ajax({
        	type : "POST",
        	url : "/SpringMVC-AjaxJquery/second.htm",
        data: "firstname=" + name + "&lastname=" + education, 
        success: function(response){
           alert(response);
        // we have the response

        $('#info').html(response);
        $('#add').val('data sent sent');
       // $('#info1').text();
        //empty the fild
        $('#name').val('');
        $('#education').val('');

        },

        error: function(e){
        alert('Error: ' + e);
        } 
        });
        }
        </script>
    </head>
    <body>
        <h1>Add Users using Ajax ........</h1>
        <table>
            <tr><td>Enter your name : </td><td> <input type="text" id="name"  name="firstname"><br/></td></tr>
            <tr><td>Education : </td><td> <input type="text" id="education" name="secondname"><br/></td></tr>
            <tr><td colspan="2"><input type="button" value="Add Users" onclick="doAjaxPost()"><br/></td></tr>
            <
        </table>
        
        <br><br>
        
        
   <div id="info" style="color: green;"></div>
   <br><br>
   DATA=<div id="add" style="color: green;"></div>
      
    </body>
</html>
