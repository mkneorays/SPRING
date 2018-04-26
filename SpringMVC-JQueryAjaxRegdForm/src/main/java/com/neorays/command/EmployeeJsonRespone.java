package com.neorays.command;

import java.util.Map;

/*
 for exposing the mode data in JSON format to view using the
 @ResponseBody annotation.
 */
public class EmployeeJsonRespone {

	private Employee employee;
	private boolean validated;
	private Map<String, String> errorMessages;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
