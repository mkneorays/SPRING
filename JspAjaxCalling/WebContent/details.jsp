
<%
  String namesDictionary[]={"raja","rani","jani","phani","anil","anitha",
		                                            "sony","ghani","gajani","dhoni","charan","chitti",
		                                            "somi","pomi","rajani","baba","ram",
		                                            "raheem","om","raderam","nachoram",
		                                            "sadguru","modi","rahul","pappu","sindhu",
		                                             "saina","sania","sonia","mahesh","tarak","kattapa",
		                                             "bahubhali","bharhimi","ali","sunil","subbu"};
   //read req param  value 
   String hint=request.getParameter("q").trim();
  // out.println("<h3>"+hint+"</h3>");
   String suggestion="";
   
   // Thread.sleep(20000);
   
   //send names suggestions
   for(String name:namesDictionary){
	   if(name.toUpperCase().startsWith(hint.toUpperCase())){
		   suggestion=suggestion+name+",";
	   }
   }//for
   
   if(suggestion.length()==0 ||suggestion.equalsIgnoreCase("")){
	   out.println("<b> No Suggestions</b>");
   }
   else{
	   out.println("<b>"+suggestion+"</b>");
   }
%>