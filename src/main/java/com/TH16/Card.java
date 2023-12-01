package com.TH16;

import javafx.scene.paint.Color;

public class Card {

	private double sampleAverage;
	private int cardNum;
	private Color color;
	private String title;
	
	public Card(double sampleAverage, int cardNum, Color color, String title) {
		this.sampleAverage = sampleAverage;
		this.cardNum = cardNum;
		this.color = color;
		this.title = title;
	}
	
	public double getSampleAverage() {
		return sampleAverage;
	}
	public int getCardNum() {
		return cardNum;
	}
	public Color getColor() {
		return color;
	}
	public String getTitle() {
		return title;
	}
}
