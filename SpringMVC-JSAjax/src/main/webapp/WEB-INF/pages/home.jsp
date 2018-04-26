
<h1 style="color:red;text-align:center">Ajax Based web application Development</h1>

<form >
  Enter  u  r letters : <input type="text"  name="txt1"  onKeyUp="showHint(this.value)"><br> 
  Suggestions :: <span id="sgt" style="color:red"></span> 
</form>

<script lanaguage="JavaScript">
 var aengg;
  function showHint(hint){
	//  alert(hint);
	  if(hint==""){
		   document.getElementById("sgt").innerHTML="";
		  return;
      }
	  //create AjaxEngine having Cross Browser compatiblity 
	  if(window.XMLHttpRequest){
		  //for modern browsers 
		  aengg=new XMLHttpRequest();
	  }
	  else{
		  //for old IE browser
		  aengg=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  // alert("a-->"+aengg.readyState); //a=0  (1)
	  //sepcify callback function name
	  aengg.onreadystatechange=display;
	 // alert("d-->"+aengg.readyState); //d=0     (2)
	  //frame requst url and send request
	  aengg.open("GET","/Spring-JSAjax/second.htm?q="+hint,true);  //(2.1)
	 // alert("b-->"+aengg.readyState); //b=1    (4)
	  aengg.send();                    //  (6)
	 // alert("c-->"+aengg.readyState); //c=4  (7)
  }
   function display(){
	 //  alert("display-->"+aengg.readyState);//display=1 (3)//display=4  (5)
	   if(aengg.readyState==4 && aengg.status==200){
		   //write recieved output to web page
		   document.getElementById("sgt").innerHTML=aengg.responseText;
	   }//if
   }//display()
</script>