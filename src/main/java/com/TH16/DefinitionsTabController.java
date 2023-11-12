/*
 * This File was written by Austin Bingham to implement the 
 * event handling of the definitions tab in Effort Logger
 */

package com.TH16;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DefinitionsTabController {
	
	@FXML
	private TextField keyWord1;
	@FXML
	private TextField keyWord2;
	@FXML
	private TextField keyWord3;
	@FXML
	private TextField keyWord4;
	@FXML
	private TextField keyWord5;
	@FXML
	private TextField keyWord6;
	@FXML
	private TextField keyWord7;
	@FXML
	private TextField keyWord8;
	@FXML
	private TextField keyWord9;
	@FXML
	private TextField keyWord10;
	@FXML
	private TextField keyWord11;
	@FXML
	private TextField keyWord12;
	@FXML
	private TextField keyWord13;
	@FXML
	private TextField keyWord14;
	@FXML
	private TextField keyWord15;
	@FXML
	private TextField keyWord16;
	@FXML
	private TextField keyWord17;
	@FXML
	private TextField keyWord18;
	@FXML
	private TextField keyWord19;
	@FXML
	private TextField keyWord20;
		
	public String[] keyWords = new String[20];
	
	/*
	 * The following methods add the keywords to the keyWords array
	 * when the user enters in the key words in the respective text fields
	 */
	
	public void addKeyWord1(ActionEvent e) {
		keyWords[0] = keyWord1.getText();
		System.out.println(keyWords[0]);
	}
	public void addKeyWord2(ActionEvent e) {
		keyWords[1] = keyWord2.getText();
		System.out.println(keyWords[1]);
	}
	public void addKeyWord3(ActionEvent e) {
		keyWords[2] = keyWord3.getText();
		System.out.println(keyWords[2]);
	}
	public void addKeyWord4(ActionEvent e) {
		keyWords[3] = keyWord4.getText();
		System.out.println(keyWords[3]);
	}
	public void addKeyWord5(ActionEvent e) {
		keyWords[4] = keyWord5.getText();
		System.out.println(keyWords[4]);
	}
	public void addKeyWord6(ActionEvent e) {
		keyWords[5] = keyWord6.getText();
		System.out.println(keyWords[5]);
	}
	public void addKeyWord7(ActionEvent e) {
		keyWords[6] = keyWord7.getText();
		System.out.println(keyWords[6]);
	}
	public void addKeyWord8(ActionEvent e) {
		keyWords[7] = keyWord8.getText();
		System.out.println(keyWords[7]);
	}
	public void addKeyWord9(ActionEvent e) {
		keyWords[8] = keyWord9.getText();
		System.out.println(keyWords[8]);
	}
	public void addKeyWord10(ActionEvent e) {
		keyWords[9] = keyWord10.getText();
		System.out.println(keyWords[9]);
	}
	public void addKeyWord11(ActionEvent e) {
		keyWords[10] = keyWord11.getText();
		System.out.println(keyWords[10]);
	}
	public void addKeyWord12(ActionEvent e) {
		keyWords[11] = keyWord12.getText();
		System.out.println(keyWords[11]);
	}
	public void addKeyWord13(ActionEvent e) {
		keyWords[12] = keyWord13.getText();
		System.out.println(keyWords[12]);
	}
	public void addKeyWord14(ActionEvent e) {
		keyWords[13] = keyWord14.getText();
		System.out.println(keyWords[13]);
	}
	public void addKeyWord15(ActionEvent e) {
		keyWords[14] = keyWord15.getText();
		System.out.println(keyWords[14]);
	}
	public void addKeyWord16(ActionEvent e) {
		keyWords[15] = keyWord16.getText();
		System.out.println(keyWords[15]);
	}
	public void addKeyWord17(ActionEvent e) {
		keyWords[16] = keyWord17.getText();
		System.out.println(keyWords[16]);
	}
	public void addKeyWord18(ActionEvent e) {
		keyWords[17] = keyWord18.getText();
		System.out.println(keyWords[17]);
	}
	public void addKeyWord19(ActionEvent e) {
		keyWords[18] = keyWord19.getText();
		System.out.println(keyWords[18]);
	}
	public void addKeyWord20(ActionEvent e) {
		keyWords[19] = keyWord20.getText();
		System.out.println(keyWords[19]);
	}
	
	/*
	 * This method returns the keyWords list to be used by other classes
	 */
	public String[] getKeyWords() {
		return keyWords;
	}
}
