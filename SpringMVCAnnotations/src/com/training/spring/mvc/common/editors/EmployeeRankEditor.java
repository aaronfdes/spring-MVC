package com.training.spring.mvc.common.editors;

import java.beans.PropertyEditorSupport;

public class EmployeeRankEditor extends PropertyEditorSupport {

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(Integer.parseInt(text) < 12){
			setValue("ASE");
		} else {
			setValue("Experienced");
		}
	}
	
}
