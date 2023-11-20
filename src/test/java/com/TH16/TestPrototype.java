package com.TH16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

import com.TH16.CSVScanner.ReferenceStory;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPrototype {
	 @Test
	    public void testCSVScannerWithStringFilename() {
	        // Set up
	        String filename = "stories.csv";  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(filename);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	        // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(0);
	        assertEquals("Game Setup", firstStory.getName());
	        assertEquals("\"Set up the basic structure of the game including the game board and player data and the initial game state.\"", firstStory.getDescription());
	        assertEquals("4 hours", firstStory.getEffort());
	    }
	 @Test
	    public void testCSVScannerWithStringFilename1() {
	        // Set up
	        String filename = "stories.csv";  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(filename);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	     // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(2);
	        assertEquals("Win Detection", firstStory.getName());
	        assertEquals("Create the logic to detect a winning move or a draw.", firstStory.getDescription());
	        assertEquals("8 hours", firstStory.getEffort());
	    }
	 @Test
	    public void testCSVScannerWithStringFilename2() {
	        // Set up
	        String filename = "stories.csv";  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(filename);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	     // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(3);
	        assertEquals("User Interface", firstStory.getName());
	        assertEquals("\"Design and implement the user interface for the game including the game board and feedback to the players.\"", firstStory.getDescription());
	        assertEquals("6 hours", firstStory.getEffort());
	    }

	    @Test
	    public void testCSVScannerWithFile() {
	        // Set up
	        File file = new File("stories.csv");  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(file);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	        // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(1);
	        assertEquals("Player Turns", firstStory.getName());
	        assertEquals("\"Implement the logic for players to take their turns alternating between X and O.\"", firstStory.getDescription());
	        assertEquals("6 hours", firstStory.getEffort());
	    }
	    @Test
	    public void testCSVScannerWithFile1() {
	        // Set up
	        File file = new File("stories.csv");  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(file);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	        // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(2);
	        assertEquals("Win Detection", firstStory.getName());
	        assertEquals("Create the logic to detect a winning move or a draw.", firstStory.getDescription());
	        assertEquals("8 hours", firstStory.getEffort());
	    }
	    @Test
	    public void testCSVScannerWithFile2() {
	        // Set up
	        File file = new File("stories.csv");  // Assuming testData.csv is in the test resources directory
	        CSVScanner csvScanner = new CSVScanner(file);

	        // Test
	        ArrayList<CSVScanner.ReferenceStory> referenceStories = csvScanner.getReferenceStoryList();

	        // Assertions
	        assertNotNull(referenceStories);
	        assertEquals(4, referenceStories.size());

	        // Check the content of the first reference story
	        CSVScanner.ReferenceStory firstStory = referenceStories.get(3);
	        assertEquals("User Interface", firstStory.getName());
	        assertEquals("\"Design and implement the user interface for the game including the game board and feedback to the players.\"", firstStory.getDescription());
	        assertEquals("6 hours", firstStory.getEffort());
	    }
	    
	    

	
}
