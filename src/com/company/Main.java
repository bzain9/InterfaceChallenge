package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Create a simple interface that allows an object to be saved to some sort of storage medium.
        // The exact type of medium is not known to the interface (nor to the classes that implement it).
        // The interface will just specify 2 methods, one to return an ArrayList of values to be saved
        // and the other to populate the object's fields from an ArrayList.
        //
        // Create some sample classes that implement your saveable interface.
        //
        // Override the toString() method for each of your classes so that they can be easily printed to enable
        // the program to be tested easier.
        //
        // In Main, write a method that takes an object that implements the interface as a parameter and
        // "saves" the values.
        // Also in Main write a method that restores the values to a saveable object.
        // Use the readValues() method to simulate values from a file and not Java file I/O.

        Player zain = new Player("Zain", 10, 15);
        System.out.println(zain.toString());
        saveObject(zain);

        zain.setHitPoints(8);
        System.out.println(zain);
        zain.setWeapon("Stormbringer");
        saveObject(zain);
        //loadObject(zain);
        System.out.println(zain);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");
        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
        for (int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
