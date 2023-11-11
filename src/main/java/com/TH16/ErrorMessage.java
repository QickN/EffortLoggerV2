/*****
Entire File Written by Austin Bingham
*****/
package com.TH16;
public class ErrorMessage {
	static private boolean error = false;
	static private String errMsg = "";
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(boolean error, String errMsg) {//constructor for error message class
		ErrorMessage.error = error;
		ErrorMessage.errMsg = errMsg;
	}
	public static boolean isError() {
		return error;
	}
	public static String getErrMsg() {
		return errMsg;
	}
}
