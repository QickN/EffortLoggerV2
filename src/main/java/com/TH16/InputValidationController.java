package com.TH16;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InputValidationController {
		static final int TEXT_FIELD_MAX_INPUT = 6;
		
		ValidateTextField validateTextField = new ValidateTextField();
		
		ErrorMessage errorMessage = new ErrorMessage();
		
		
	    @FXML
	    private Label labelErrorMsg;

	    @FXML
	    private TextField textFieldInput;

	    @FXML
	    void textFieldClicked(MouseEvent event) {
	    	displayErrMsg("");
	    	
	    	validateTextField.setOldCursorCaretPosition(textFieldInput.getCaretPosition());
	    }

	    @FXML
	    void validateTextFieldKeyTyped(KeyEvent event) {
	    	displayErrMsg("");
	    	
	    	errorMessage = validateTextField.validateDigit(textFieldInput, event, TEXT_FIELD_MAX_INPUT);
	    	if(ErrorMessage.isError()) {
	    		displayErrMsg(ErrorMessage.getErrMsg());
	    	}
	    }

	    void displayErrMsg(String msg) {
	    	labelErrorMsg.setText(msg);
	    }
	}

