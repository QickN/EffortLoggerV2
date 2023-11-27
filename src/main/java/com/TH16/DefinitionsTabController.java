/*
 * This File was written by Austin Bingham to implement the 
 * event handling of the definitions tab in Effort Logger
 */

package com.TH16;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DefinitionsTabController {
	/*
	 * The following TextFields are the TextFields used in scene builder. 
	 * Do not alter this code.
	 */
    @FXML
    private TextField defectCategory1;
    @FXML
    private TextField defectCategory10;
    @FXML
    private TextField defectCategory11;
    @FXML
    private TextField defectCategory12;
    @FXML
    private TextField defectCategory13;
    @FXML
    private TextField defectCategory14;
    @FXML
    private TextField defectCategory15;
    @FXML
    private TextField defectCategory2;
    @FXML
    private TextField defectCategory3;
    @FXML
    private TextField defectCategory4;
    @FXML
    private TextField defectCategory5;
    @FXML
    private TextField defectCategory6;
    @FXML
    private TextField defectCategory7;
    @FXML
    private TextField defectCategory8;
    @FXML
    private TextField defectCategory9;
    @FXML
    private TextField deliverable1;
    @FXML
    private TextField deliverable10;
    @FXML
    private TextField deliverable2;
    @FXML
    private TextField deliverable3;
    @FXML
    private TextField deliverable4;
    @FXML
    private TextField deliverable5;
    @FXML
    private TextField deliverable6;
    @FXML
    private TextField deliverable7;
    @FXML
    private TextField deliverable8;
    @FXML
    private TextField deliverable9;
    @FXML
    private TextField effortCategory1;
    @FXML
    private TextField effortCategory2;
    @FXML
    private TextField effortCategory3;
    @FXML
    private TextField effortCategory4;
    @FXML
    private TextField effortCategory5;
    @FXML
    private TextField interruption1;
    @FXML
    private TextField interruption10;
    @FXML
    private TextField interruption2;
    @FXML
    private TextField interruption3;
    @FXML
    private TextField interruption4;
    @FXML
    private TextField interruption5;
    @FXML
    private TextField interruption6;
    @FXML
    private TextField interruption7;
    @FXML
    private TextField interruption8;
    @FXML
    private TextField interruption9;
	@FXML
	public TextField keyWord1;
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
    @FXML
    private TextField lifeCycleStep1;
    @FXML
    private TextField lifeCycleStep10;
    @FXML
    private TextField lifeCycleStep11;
    @FXML
    private TextField lifeCycleStep12;
    @FXML
    private TextField lifeCycleStep13;
    @FXML
    private TextField lifeCycleStep14;
    @FXML
    private TextField lifeCycleStep15;
    @FXML
    private TextField lifeCycleStep16;
    @FXML
    private TextField lifeCycleStep17;
    @FXML
    private TextField lifeCycleStep18;
    @FXML
    private TextField lifeCycleStep19;
    @FXML
    private TextField lifeCycleStep2;
    @FXML
    private TextField lifeCycleStep20;
    @FXML
    private TextField lifeCycleStep21;
    @FXML
    private TextField lifeCycleStep22;
    @FXML
    private TextField lifeCycleStep23;
    @FXML
    private TextField lifeCycleStep24;
    @FXML
    private TextField lifeCycleStep25;
    @FXML
    private TextField lifeCycleStep26;
    @FXML
    private TextField lifeCycleStep27;
    @FXML
    private TextField lifeCycleStep28;
    @FXML
    private TextField lifeCycleStep29;
    @FXML
    private TextField lifeCycleStep3;
    @FXML
    private TextField lifeCycleStep30;
    @FXML
    private TextField lifeCycleStep31;
    @FXML
    private TextField lifeCycleStep32;
    @FXML
    private TextField lifeCycleStep33;
    @FXML
    private TextField lifeCycleStep34;
    @FXML
    private TextField lifeCycleStep35;
    @FXML
    private TextField lifeCycleStep36;
    @FXML
    private TextField lifeCycleStep37;
    @FXML
    private TextField lifeCycleStep38;
    @FXML
    private TextField lifeCycleStep39;
    @FXML
    private TextField lifeCycleStep4;
    @FXML
    private TextField lifeCycleStep40;
    @FXML
    private TextField lifeCycleStep41;
    @FXML
    private TextField lifeCycleStep42;
    @FXML
    private TextField lifeCycleStep43;
    @FXML
    private TextField lifeCycleStep44;
    @FXML
    private TextField lifeCycleStep45;
    @FXML
    private TextField lifeCycleStep46;
    @FXML
    private TextField lifeCycleStep47;
    @FXML
    private TextField lifeCycleStep48;
    @FXML
    private TextField lifeCycleStep49;
    @FXML
    private TextField lifeCycleStep5;
    @FXML
    private TextField lifeCycleStep50;
    @FXML
    private TextField lifeCycleStep6;
    @FXML
    private TextField lifeCycleStep7;
    @FXML
    private TextField lifeCycleStep8;
    @FXML
    private TextField lifeCycleStep9;
    @FXML
    private TextField p10LCS1;
    @FXML
    private TextField p10LCS10;
    @FXML
    private TextField p10LCS11;
    @FXML
    private TextField p10LCS12;
    @FXML
    private TextField p10LCS13;
    @FXML
    private TextField p10LCS14;
    @FXML
    private TextField p10LCS15;
    @FXML
    private TextField p10LCS16;
    @FXML
    private TextField p10LCS17;
    @FXML
    private TextField p10LCS18;
    @FXML
    private TextField p10LCS19;
    @FXML
    private TextField p10LCS2;
    @FXML
    private TextField p10LCS20;
    @FXML
    private TextField p10LCS21;
    @FXML
    private TextField p10LCS22;
    @FXML
    private TextField p10LCS23;
    @FXML
    private TextField p10LCS24;
    @FXML
    private TextField p10LCS25;
    @FXML
    private TextField p10LCS3;
    @FXML
    private TextField p10LCS4;
    @FXML
    private TextField p10LCS5;
    @FXML
    private TextField p10LCS6;
    @FXML
    private TextField p10LCS7;
    @FXML
    private TextField p10LCS8;
    @FXML
    private TextField p10LCS9;
    @FXML
    private TextField p1LCS1;
    @FXML
    private TextField p1LCS10;
    @FXML
    private TextField p1LCS11;
    @FXML
    private TextField p1LCS12;
    @FXML
    private TextField p1LCS13;
    @FXML
    private TextField p1LCS14;
    @FXML
    private TextField p1LCS15;
    @FXML
    private TextField p1LCS16;
    @FXML
    private TextField p1LCS17;
    @FXML
    private TextField p1LCS18;
    @FXML
    private TextField p1LCS19;
    @FXML
    private TextField p1LCS2;
    @FXML
    private TextField p1LCS20;
    @FXML
    private TextField p1LCS21;
    @FXML
    private TextField p1LCS22;
    @FXML
    private TextField p1LCS23;
    @FXML
    private TextField p1LCS24;
    @FXML
    private TextField p1LCS25;
    @FXML
    private TextField p1LCS3;
    @FXML
    private TextField p1LCS4;
    @FXML
    private TextField p1LCS5;
    @FXML
    private TextField p1LCS6;
    @FXML
    private TextField p1LCS7;
    @FXML
    private TextField p1LCS8;
    @FXML
    private TextField p1LCS9;
    @FXML
    private TextField p2LCS1;
    @FXML
    private TextField p2LCS10;
    @FXML
    private TextField p2LCS11;
    @FXML
    private TextField p2LCS12;
    @FXML
    private TextField p2LCS13;
    @FXML
    private TextField p2LCS14;
    @FXML
    private TextField p2LCS15;
    @FXML
    private TextField p2LCS16;
    @FXML
    private TextField p2LCS17;
    @FXML
    private TextField p2LCS18;
    @FXML
    private TextField p2LCS19;
    @FXML
    private TextField p2LCS2;
    @FXML
    private TextField p2LCS20;
    @FXML
    private TextField p2LCS21;
    @FXML
    private TextField p2LCS22;
    @FXML
    private TextField p2LCS23;
    @FXML
    private TextField p2LCS24;
    @FXML
    private TextField p2LCS25;
    @FXML
    private TextField p2LCS3;
    @FXML
    private TextField p2LCS4;
    @FXML
    private TextField p2LCS5;
    @FXML
    private TextField p2LCS6;
    @FXML
    private TextField p2LCS7;
    @FXML
    private TextField p2LCS8;
    @FXML
    private TextField p2LCS9;
    @FXML
    private TextField p3LCS1;
    @FXML
    private TextField p3LCS10;
    @FXML
    private TextField p3LCS11;
    @FXML
    private TextField p3LCS12;
    @FXML
    private TextField p3LCS13;
    @FXML
    private TextField p3LCS14;
    @FXML
    private TextField p3LCS15;
    @FXML
    private TextField p3LCS16;
    @FXML
    private TextField p3LCS17;
    @FXML
    private TextField p3LCS18;
    @FXML
    private TextField p3LCS19;
    @FXML
    private TextField p3LCS2;
    @FXML
    private TextField p3LCS20;
    @FXML
    private TextField p3LCS21;
    @FXML
    private TextField p3LCS22;
    @FXML
    private TextField p3LCS23;
    @FXML
    private TextField p3LCS24;
    @FXML
    private TextField p3LCS25;
    @FXML
    private TextField p3LCS3;
    @FXML
    private TextField p3LCS4;
    @FXML
    private TextField p3LCS5;
    @FXML
    private TextField p3LCS6;
    @FXML
    private TextField p3LCS7;
    @FXML
    private TextField p3LCS8;
    @FXML
    private TextField p3LCS9;
    @FXML
    private TextField p4LCS1;
    @FXML
    private TextField p4LCS10;
    @FXML
    private TextField p4LCS11;
    @FXML
    private TextField p4LCS12;
    @FXML
    private TextField p4LCS13;
    @FXML
    private TextField p4LCS14;
    @FXML
    private TextField p4LCS15;
    @FXML
    private TextField p4LCS16;
    @FXML
    private TextField p4LCS17;
    @FXML
    private TextField p4LCS18;
    @FXML
    private TextField p4LCS19;
    @FXML
    private TextField p4LCS2;
    @FXML
    private TextField p4LCS20;
    @FXML
    private TextField p4LCS21;
    @FXML
    private TextField p4LCS22;
    @FXML
    private TextField p4LCS23;
    @FXML
    private TextField p4LCS24;
    @FXML
    private TextField p4LCS25;
    @FXML
    private TextField p4LCS3;
    @FXML
    private TextField p4LCS4;
    @FXML
    private TextField p4LCS5;
    @FXML
    private TextField p4LCS6;
    @FXML
    private TextField p4LCS7;
    @FXML
    private TextField p4LCS8;
    @FXML
    private TextField p4LCS9;
    @FXML
    private TextField p5LCS1;
    @FXML
    private TextField p5LCS10;
    @FXML
    private TextField p5LCS11;
    @FXML
    private TextField p5LCS12;
    @FXML
    private TextField p5LCS13;
    @FXML
    private TextField p5LCS14;
    @FXML
    private TextField p5LCS15;
    @FXML
    private TextField p5LCS16;
    @FXML
    private TextField p5LCS17;
    @FXML
    private TextField p5LCS18;
    @FXML
    private TextField p5LCS19;
    @FXML
    private TextField p5LCS2;
    @FXML
    private TextField p5LCS20;
    @FXML
    private TextField p5LCS21;
    @FXML
    private TextField p5LCS22;
    @FXML
    private TextField p5LCS23;
    @FXML
    private TextField p5LCS24;
    @FXML
    private TextField p5LCS25;
    @FXML
    private TextField p5LCS3;
    @FXML
    private TextField p5LCS4;
    @FXML
    private TextField p5LCS5;
    @FXML
    private TextField p5LCS6;
    @FXML
    private TextField p5LCS7;
    @FXML
    private TextField p5LCS8;
    @FXML
    private TextField p5LCS9;
    @FXML
    private TextField p6LCS1;
    @FXML
    private TextField p6LCS10;
    @FXML
    private TextField p6LCS11;
    @FXML
    private TextField p6LCS12;
    @FXML
    private TextField p6LCS13;
    @FXML
    private TextField p6LCS14;
    @FXML
    private TextField p6LCS15;
    @FXML
    private TextField p6LCS16;
    @FXML
    private TextField p6LCS17;
    @FXML
    private TextField p6LCS18;
    @FXML
    private TextField p6LCS19;
    @FXML
    private TextField p6LCS2;
    @FXML
    private TextField p6LCS20;
    @FXML
    private TextField p6LCS21;
    @FXML
    private TextField p6LCS22;
    @FXML
    private TextField p6LCS23;
    @FXML
    private TextField p6LCS24;
    @FXML
    private TextField p6LCS25;
    @FXML
    private TextField p6LCS3;
    @FXML
    private TextField p6LCS4;
    @FXML
    private TextField p6LCS5;
    @FXML
    private TextField p6LCS6;
    @FXML
    private TextField p6LCS7;
    @FXML
    private TextField p6LCS8;
    @FXML
    private TextField p6LCS9;
    @FXML
    private TextField p7LCS1;
    @FXML
    private TextField p7LCS10;
    @FXML
    private TextField p7LCS11;
    @FXML
    private TextField p7LCS12;
    @FXML
    private TextField p7LCS13;
    @FXML
    private TextField p7LCS14;
    @FXML
    private TextField p7LCS15;
    @FXML
    private TextField p7LCS16;
    @FXML
    private TextField p7LCS17;
    @FXML
    private TextField p7LCS18;
    @FXML
    private TextField p7LCS19;
    @FXML
    private TextField p7LCS2;
    @FXML
    private TextField p7LCS20;
    @FXML
    private TextField p7LCS21;
    @FXML
    private TextField p7LCS22;
    @FXML
    private TextField p7LCS23;
    @FXML
    private TextField p7LCS24;
    @FXML
    private TextField p7LCS25;
    @FXML
    private TextField p7LCS3;
    @FXML
    private TextField p7LCS4;
    @FXML
    private TextField p7LCS5;
    @FXML
    private TextField p7LCS6;
    @FXML
    private TextField p7LCS7;
    @FXML
    private TextField p7LCS8;
    @FXML
    private TextField p7LCS9;
    @FXML
    private TextField p8LCS1;
    @FXML
    private TextField p8LCS10;
    @FXML
    private TextField p8LCS11;
    @FXML
    private TextField p8LCS12;
    @FXML
    private TextField p8LCS13;
    @FXML
    private TextField p8LCS14;
    @FXML
    private TextField p8LCS15;
    @FXML
    private TextField p8LCS16;
    @FXML
    private TextField p8LCS17;
    @FXML
    private TextField p8LCS18;
    @FXML
    private TextField p8LCS19;
    @FXML
    private TextField p8LCS2;
    @FXML
    private TextField p8LCS20;
    @FXML
    private TextField p8LCS21;
    @FXML
    private TextField p8LCS22;
    @FXML
    private TextField p8LCS23;
    @FXML
    private TextField p8LCS24;
    @FXML
    private TextField p8LCS25;
    @FXML
    private TextField p8LCS3;
    @FXML
    private TextField p8LCS4;
    @FXML
    private TextField p8LCS5;
    @FXML
    private TextField p8LCS6;
    @FXML
    private TextField p8LCS7;
    @FXML
    private TextField p8LCS8;
    @FXML
    private TextField p8LCS9;
    @FXML
    private TextField p9LCS1;
    @FXML
    private TextField p9LCS10;
    @FXML
    private TextField p9LCS11;
    @FXML
    private TextField p9LCS12;
    @FXML
    private TextField p9LCS13;
    @FXML
    private TextField p9LCS14;
    @FXML
    private TextField p9LCS15;
    @FXML
    private TextField p9LCS16;
    @FXML
    private TextField p9LCS17;
    @FXML
    private TextField p9LCS18;
    @FXML
    private TextField p9LCS19;
    @FXML
    private TextField p9LCS2;
    @FXML
    private TextField p9LCS20;
    @FXML
    private TextField p9LCS21;
    @FXML
    private TextField p9LCS22;
    @FXML
    private TextField p9LCS23;
    @FXML
    private TextField p9LCS24;
    @FXML
    private TextField p9LCS25;
    @FXML
    private TextField p9LCS3;
    @FXML
    private TextField p9LCS4;
    @FXML
    private TextField p9LCS5;
    @FXML
    private TextField p9LCS6;
    @FXML
    private TextField p9LCS7;
    @FXML
    private TextField p9LCS8;
    @FXML
    private TextField p9LCS9;
    @FXML
    private TextField plan1;
    @FXML
    private TextField plan10;
    @FXML
    private TextField plan2;
    @FXML
    private TextField plan3;
    @FXML
    private TextField plan4;
    @FXML
    private TextField plan5;
    @FXML
    private TextField plan6;
    @FXML
    private TextField plan7;
    @FXML
    private TextField plan8;
    @FXML
    private TextField plan9;
    @FXML
    private TextField project1;
    @FXML
    private TextField project10;
    @FXML
    private TextField project2;
    @FXML
    private TextField project3;
    @FXML
    private TextField project4;
    @FXML
    private TextField project5;
    @FXML
    private TextField project6;
    @FXML
    private TextField project7;
    @FXML
    private TextField project8;
    @FXML
    private TextField project9;
		
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
	 * The following methods can be called from other sections of the code that require these lists
	 * For example, a DefinitionsTabController object can be made and can be used to call these methods.
	 */
	public String[] getKeyWords() {
		return keyWords;
	}
	public String[] getProjects() {
		String[] projects = { project1.getText(), project2.getText(), project3.getText(), project4.getText(),
				project5.getText(), project6.getText(), project7.getText(), project8.getText(), 
				project9.getText(), project10.getText() };
		return projects;
	}
	public String[] getEffortCategories() {
		String[] effortCategories = { effortCategory1.getText(), effortCategory2.getText(), effortCategory3.getText(), 
				effortCategory4.getText(), effortCategory5.getText() };
		return effortCategories;
	}
	public String[] getPlans() {
		String[] plans = { plan1.getText(), plan2.getText(), plan3.getText(), plan4.getText(), plan5.getText(),
				plan6.getText(), plan7.getText(), plan8.getText(), plan9.getText(), plan10.getText() };
		return plans;
	}
	public String[] getDefectCategories() {
		String[] defectCategories = { defectCategory1.getText(), defectCategory2.getText(), defectCategory3.getText(),
				defectCategory4.getText(), defectCategory5.getText(), defectCategory6.getText(), defectCategory7.getText(),
				defectCategory8.getText(), defectCategory9.getText(), defectCategory10.getText(), defectCategory11.getText(),
				defectCategory12.getText(), defectCategory13.getText(), defectCategory14.getText(), defectCategory15.getText() };
		return defectCategories;
	}
	public String[] getDeliverables() {
		String[] deliverables = { deliverable1.getText(), deliverable2.getText(), deliverable3.getText(), deliverable4.getText(), deliverable5.getText(),
				deliverable6.getText(), deliverable7.getText(), deliverable8.getText(), deliverable9.getText(), deliverable10.getText() };
		return deliverables;
	}
	public String[] getInterruptions() {
		String[] interruptions = { interruption1.getText(), interruption2.getText(), interruption3.getText(), interruption4.getText(), interruption5.getText(),
				interruption6.getText(), interruption7.getText(), interruption8.getText(), interruption9.getText(), interruption10.getText() };
		return interruptions;
	}
	public String[] getLifeCycleSteps() {
		String[] lifeCycleSteps = { lifeCycleStep1.getText(), lifeCycleStep2.getText(), lifeCycleStep3.getText(), lifeCycleStep4.getText(),
				lifeCycleStep5.getText(), lifeCycleStep6.getText(), lifeCycleStep7.getText(), lifeCycleStep8.getText(), lifeCycleStep9.getText(),
				lifeCycleStep10.getText(), lifeCycleStep11.getText(), lifeCycleStep12.getText(), lifeCycleStep13.getText(), lifeCycleStep14.getText(),
				lifeCycleStep15.getText(), lifeCycleStep16.getText(), lifeCycleStep17.getText(), lifeCycleStep18.getText(), lifeCycleStep19.getText(),
				lifeCycleStep20.getText(), lifeCycleStep21.getText(), lifeCycleStep22.getText(), lifeCycleStep23.getText(), lifeCycleStep24.getText(),
				lifeCycleStep25.getText(), lifeCycleStep26.getText(), lifeCycleStep27.getText(), lifeCycleStep28.getText(), lifeCycleStep29.getText(),
				lifeCycleStep30.getText(), lifeCycleStep31.getText(), lifeCycleStep32.getText(), lifeCycleStep33.getText(), lifeCycleStep34.getText(),
				lifeCycleStep35.getText(), lifeCycleStep36.getText(), lifeCycleStep37.getText(), lifeCycleStep38.getText(), lifeCycleStep39.getText(),
				lifeCycleStep40.getText(), lifeCycleStep41.getText(), lifeCycleStep42.getText(), lifeCycleStep43.getText(), lifeCycleStep44.getText(), 
				lifeCycleStep45.getText(), lifeCycleStep46.getText(), lifeCycleStep47.getText(), lifeCycleStep48.getText(), lifeCycleStep49.getText(),
				lifeCycleStep50.getText() };
		return lifeCycleSteps;
	}
	public String[] getP1LCS() {
		String[] p1LCS = { p1LCS1.getText(), p1LCS2.getText(), p1LCS3.getText(), p1LCS4.getText(), p1LCS5.getText(), p1LCS6.getText(), p1LCS7.getText(),
				p1LCS8.getText(), p1LCS9.getText(), p1LCS10.getText(), p1LCS11.getText(), p1LCS12.getText(), p1LCS13.getText(), p1LCS14.getText(), p1LCS15.getText(),
				p1LCS16.getText(), p1LCS17.getText(), p1LCS18.getText(), p1LCS19.getText(), p1LCS20.getText(), p1LCS21.getText(), p1LCS22.getText(), p1LCS23.getText(),
				p1LCS24.getText(), p1LCS25.getText() };
		return p1LCS;
	}
	public String[] getP2LCS() {
		String[] p2LCS = { p2LCS1.getText(), p2LCS2.getText(), p2LCS3.getText(), p2LCS4.getText(), p2LCS5.getText(), p2LCS6.getText(), p2LCS7.getText(),
				p2LCS8.getText(), p2LCS9.getText(), p2LCS10.getText(), p2LCS11.getText(), p2LCS12.getText(), p2LCS13.getText(), p2LCS14.getText(), p2LCS15.getText(),
				p2LCS16.getText(), p2LCS17.getText(), p2LCS18.getText(), p2LCS19.getText(), p2LCS20.getText(), p2LCS21.getText(), p2LCS22.getText(), p2LCS23.getText(),
				p2LCS24.getText(), p2LCS25.getText() };
		return p2LCS;
	}
	public String[] getP3LCS() {
		String[] p3LCS = { p3LCS1.getText(), p3LCS2.getText(), p3LCS3.getText(), p3LCS4.getText(), p3LCS5.getText(), p3LCS6.getText(), p3LCS7.getText(),
				p3LCS8.getText(), p3LCS9.getText(), p3LCS10.getText(), p3LCS11.getText(), p3LCS12.getText(), p3LCS13.getText(), p3LCS14.getText(), p3LCS15.getText(),
				p3LCS16.getText(), p3LCS17.getText(), p3LCS18.getText(), p3LCS19.getText(), p3LCS20.getText(), p3LCS21.getText(), p3LCS22.getText(), p3LCS23.getText(),
				p3LCS24.getText(), p3LCS25.getText() };
		return p3LCS;	
	}
	public String[] getP4LCS() {
		String[] p4LCS = { p4LCS1.getText(), p4LCS2.getText(), p4LCS3.getText(), p4LCS4.getText(), p4LCS5.getText(), p4LCS6.getText(), p4LCS7.getText(),
				p4LCS8.getText(), p4LCS9.getText(), p4LCS10.getText(), p4LCS11.getText(), p4LCS12.getText(), p4LCS13.getText(), p4LCS14.getText(), p4LCS15.getText(),
				p4LCS16.getText(), p4LCS17.getText(), p4LCS18.getText(), p4LCS19.getText(), p4LCS20.getText(), p4LCS21.getText(), p4LCS22.getText(), p4LCS23.getText(),
				p4LCS24.getText(), p4LCS25.getText() };
		return p4LCS;
	}
	public String[] getP5LCS() {
		String[] p5LCS = { p5LCS1.getText(), p5LCS2.getText(), p5LCS3.getText(), p5LCS4.getText(), p5LCS5.getText(), p5LCS6.getText(), p5LCS7.getText(),
				p5LCS8.getText(), p5LCS9.getText(), p5LCS10.getText(), p5LCS11.getText(), p5LCS12.getText(), p5LCS13.getText(), p5LCS14.getText(), p5LCS15.getText(),
				p5LCS16.getText(), p5LCS17.getText(), p5LCS18.getText(), p5LCS19.getText(), p5LCS20.getText(), p5LCS21.getText(), p5LCS22.getText(), p5LCS23.getText(),
				p5LCS24.getText(), p5LCS25.getText() };
		return p5LCS;
	}
	public String[] getP6LCS() {
		String[] p6LCS = { p6LCS1.getText(), p6LCS2.getText(), p6LCS3.getText(), p6LCS4.getText(), p6LCS5.getText(), p6LCS6.getText(), p6LCS7.getText(),
				p6LCS8.getText(), p6LCS9.getText(), p6LCS10.getText(), p6LCS11.getText(), p6LCS12.getText(), p6LCS13.getText(), p6LCS14.getText(), p6LCS15.getText(),
				p6LCS16.getText(), p6LCS17.getText(), p6LCS18.getText(), p6LCS19.getText(), p6LCS20.getText(), p6LCS21.getText(), p6LCS22.getText(), p6LCS23.getText(),
				p6LCS24.getText(), p6LCS25.getText() };
		return p6LCS;
	}
	public String[] getP7LCS() {
		String[] p7LCS = { p7LCS1.getText(), p7LCS2.getText(), p7LCS3.getText(), p7LCS4.getText(), p7LCS5.getText(), p7LCS6.getText(), p7LCS7.getText(),
				p7LCS8.getText(), p7LCS9.getText(), p7LCS10.getText(), p7LCS11.getText(), p7LCS12.getText(), p7LCS13.getText(), p7LCS14.getText(), p7LCS15.getText(),
				p7LCS16.getText(), p7LCS17.getText(), p7LCS18.getText(), p7LCS19.getText(), p7LCS20.getText(), p7LCS21.getText(), p7LCS22.getText(), p7LCS23.getText(),
				p7LCS24.getText(), p7LCS25.getText() };
		return p7LCS;
	}
	public String[] getP8LCS() {
		String[] p8LCS = { p8LCS1.getText(), p8LCS2.getText(), p8LCS3.getText(), p8LCS4.getText(), p8LCS5.getText(), p8LCS6.getText(), p8LCS7.getText(),
				p8LCS8.getText(), p8LCS9.getText(), p8LCS10.getText(), p8LCS11.getText(), p8LCS12.getText(), p8LCS13.getText(), p8LCS14.getText(), p8LCS15.getText(),
				p8LCS16.getText(), p8LCS17.getText(), p8LCS18.getText(), p8LCS19.getText(), p8LCS20.getText(), p8LCS21.getText(), p8LCS22.getText(), p8LCS23.getText(),
				p8LCS24.getText(), p8LCS25.getText() };
		return p8LCS;
	}
	public String[] getP9LCS() {
		String[] p9LCS = { p9LCS1.getText(), p9LCS2.getText(), p9LCS3.getText(), p9LCS4.getText(), p9LCS5.getText(), p9LCS6.getText(), p9LCS7.getText(),
				p9LCS8.getText(), p9LCS9.getText(), p9LCS10.getText(), p9LCS11.getText(), p9LCS12.getText(), p9LCS13.getText(), p9LCS14.getText(), p9LCS15.getText(),
				p9LCS16.getText(), p9LCS17.getText(), p9LCS18.getText(), p9LCS19.getText(), p9LCS20.getText(), p9LCS21.getText(), p9LCS22.getText(), p9LCS23.getText(),
				p9LCS24.getText(), p9LCS25.getText() };
		return p9LCS;
	}
	public String[] getP10LCS() {
		String[] p10LCS = { p10LCS1.getText(), p10LCS2.getText(), p10LCS3.getText(), p10LCS4.getText(), p10LCS5.getText(), p10LCS6.getText(), p10LCS7.getText(),
				p10LCS8.getText(), p10LCS9.getText(), p10LCS10.getText(), p10LCS11.getText(), p10LCS12.getText(), p10LCS13.getText(), p10LCS14.getText(), p10LCS15.getText(),
				p10LCS16.getText(), p10LCS17.getText(), p10LCS18.getText(), p10LCS19.getText(), p10LCS20.getText(), p10LCS21.getText(), p10LCS22.getText(), p10LCS23.getText(),
				p10LCS24.getText(), p10LCS25.getText() };
		return p10LCS;
	}
}
