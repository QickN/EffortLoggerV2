/*****
Entire File Written by Ryan Leigh
*****/

package com.TH16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVScanner {
	private ReferenceStory referenceStory;
	private ArrayList<ReferenceStory> referenceStories;
	
	//scanner overload for filename
	public CSVScanner(String filename) {
        referenceStories = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            // Read the header line (assumed to contain column names) and ignore it
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                //assures csv is proper format
                if (data.length == 3) {
                    String name = data[0];
                    String description = data[1];
                    String effort = data[2];

                    referenceStory = new ReferenceStory(name, description, effort);
                    referenceStories.add(referenceStory);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display the imported data
        for (ReferenceStory referenceStory : referenceStories) {
            System.out.println("Name: " + referenceStory.getName());
            System.out.println("Description: " + referenceStory.getDescription());
            System.out.println("Effort: " + referenceStory.getEffort());
            System.out.println();
        }
    }
	//scanner overload for file input
	public CSVScanner(File file) {
        referenceStories = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            // Read the header line (assumed to contain column names) and ignore it
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length == 3) {
                    String name = data[0];
                    String description = data[1];
                    String effort = data[2];

                    referenceStory = new ReferenceStory(name, description, effort);
                    referenceStories.add(referenceStory);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Display the imported data
        for (ReferenceStory referenceStory : referenceStories) {
            System.out.println("Name: " + referenceStory.getName());
            System.out.println("Description: " + referenceStory.getDescription());
            System.out.println("Effort: " + referenceStory.getEffort());
            System.out.println();
        }
    }
	//getter for the controller
	public ArrayList<ReferenceStory> getReferenceStoryList() {
    	return referenceStories;
    }
//h1elper class to allow the foundation for all reference stories
    public class ReferenceStory {
        private String name;
        private String description;
        private String effort;

        public ReferenceStory(String name, String description, String effort) {
            this.name = name;
            this.description = description;
            this.effort = effort;
        }
//getters
        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getEffort() {
            return effort;
        }
    }
}
