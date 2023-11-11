package com.TH16;
/*****
Entire File Written by Austin Bingham
*****/
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InputValidationController {
		static final int TEXT_FIELD_MAX_INPUT = 6; //set length of max input
		
		ValidateTextField validateTextField = new ValidateTextField(); //create new validation text field object
		
		ErrorMessage errorMessage = new ErrorMessage(); //create new error message object
		
		
	    @FXML
	    private Label labelErrorMsg;

	    @FXML
	    private TextField textFieldInput;

	    @FXML
	    void textFieldClicked(MouseEvent event) {
	    	displayErrMsg("");
	    	
	    	validateTextField.setOldCursorCaretPosition(textFieldInput.getCaretPosition()); //keep track of cursor
	    }

	    @FXML
	    void validateTextFieldKeyTyped(KeyEvent event) {
	    	displayErrMsg("");
	    	
	    	errorMessage = validateTextField.validateAlpha(textFieldInput, event, TEXT_FIELD_MAX_INPUT);
	    	if(ErrorMessage.isError()) {
	    		displayErrMsg(ErrorMessage.getErrMsg()); //display error
	    	}
	    }

	    void displayErrMsg(String msg) {
	    	labelErrorMsg.setText(msg); //error message
	    }
	}

