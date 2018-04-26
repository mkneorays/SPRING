package com.neorays.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavatoJsonUtil {

	public static String convertJavaToJson(Object obj){
		ObjectMapper mapper=null;
		String jsonString=null;
		//create object
		mapper=new ObjectMapper();
		try {
			jsonString=mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
		   throw new IllegalArgumentException("Internal Problem to convert java to json  "+e.getMessage());
		}
		
		return jsonString;
	}//method
}
