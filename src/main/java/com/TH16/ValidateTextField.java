package com.TH16;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ValidateTextField {
	private int currentCursorCaretPosition = 0;
	private int oldCursorCaretPosition = 0;
	private String oldTextFieldContents = "";
	
	static final int BACK_SPACE = 8;
	static final int CTRL_V = 22;
	static final int DEL = 127;
	static final int ENTER = 13;
	
	public ErrorMessage validateDigit(TextField textField, KeyEvent event, int textFieldMaxInput) {
		boolean error = false;
		String errorMsg = "";
		
		char currentKeyTyped = event.getCharacter().charAt(0);
		
		final Boolean PASTE_KEY = currentKeyTyped == CTRL_V;
		final Boolean INVALID_KEY
			= (!Character.isAlphabetic(currentKeyTyped))
			&& (currentKeyTyped != BACK_SPACE)
			&& (currentKeyTyped != DEL)
			&& (currentKeyTyped != ENTER)
			&& (!Character.isISOControl(currentKeyTyped));
		
		currentCursorCaretPosition = textField.getCaretPosition();
		
		try {
			if (PASTE_KEY) {
				error = true;
				errorMsg = "ERROR: Paste NOT allowed";
				
				textField.setText(oldTextFieldContents);
				textField.positionCaret(getOldCursorCaretPosition());;
			}
			else if (INVALID_KEY) {
				String replaceText = textField.getText().replace(Character.toString(currentKeyTyped), "");
				
				error = true;
				errorMsg = "ERROR: Input must be a letter";
				
				textField.setText(replaceText);
				textField.positionCaret(currentCursorCaretPosition - 1);
			}
			
			if(textField.getText().length() > textFieldMaxInput) {
				String textInput = textField.getText();
				
				error = true;
				errorMsg = "Error: Max Numper Input " + textFieldMaxInput;
				
				StringBuilder str = new StringBuilder(textInput);
				StringBuilder limitTextInput = str.deleteCharAt(currentCursorCaretPosition - 1);
				
				textField.setText(limitTextInput.toString());
				
				textField.positionCaret(currentCursorCaretPosition - 1);				
			}
			
			oldTextFieldContents = textField.getText();
			setOldCursorCaretPosition(textField.getCaretPosition());
			
			return new ErrorMessage(error, errorMsg);
		} catch (Exception e) {
			return new ErrorMessage(true, "Error: Exception Caught");
		}
	}
	public int getOldCursorCaretPosition() {
			return oldCursorCaretPosition;
	}
	public void setOldCursorCaretPosition(int oldCursorCaretPosition) {
		this.oldCursorCaretPosition = oldCursorCaretPosition;
	}
}