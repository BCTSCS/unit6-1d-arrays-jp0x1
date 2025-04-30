package com.bcts.data;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class FileOperator {
    private Scanner fileReader;
    private String fileName;

    public FileOperator() {
        // Empty constructor needed for Spring
    }

    public void setFile(String filename) {
        // Close existing scanner if it's open

        if (fileReader != null) {
            fileReader.close();
        }

        try {
            fileName=filename;
            fileReader = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }

    public int[] toIntArray(String filepath, int size) {
        int[] arr = new int[size];
        this.setFile(filepath);
        for (int i = 0; i < size && fileReader.hasNextInt(); i++) {
            arr[i] = fileReader.nextInt();
        }
        fileReader.close();
        return arr;
    }

    public double[] toDoubleArray(String filepath, int size) {
        double[] arr = new double[size];
        this.setFile(filepath);
        for (int i = 0; i < size && fileReader.hasNextDouble(); i++) {
            arr[i] = fileReader.nextDouble();
        }
        fileReader.close();
        return arr;
    }

    public String[] toStringArray(String filepath, int size) {
        String[] arr = new String[size];
        this.setFile(filepath);
        // Skip any leftover line after previous operations if necessary
        if (fileReader.hasNextLine() && filepath.contains("teams.txt")) {
            fileReader.nextLine();
        }
        for (int i = 0; i < size && fileReader.hasNextLine(); i++) {
            arr[i] = fileReader.nextLine();
        }
        fileReader.close();
        return arr;
    }

    public ArrayList<String> toStringArray(String filepath) {
        ArrayList<String> arr = new ArrayList<String>();
        this.setFile(filepath);
        while (fileReader.hasNextLine()) {
            arr.add(fileReader.nextLine());
        }
        fileReader.close();
        return arr;
    }

    public ArrayList<Integer> toIntgArray(String filepath) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        this.setFile(filepath);
        while (fileReader.hasNextInt()) {
            arr.add(fileReader.nextInt());
        }
        fileReader.close();
        return arr;
    }

    public ArrayList<Double> toDoubleArray(String filepath) {
        ArrayList<Double> arr = new ArrayList<Double>();
        this.setFile(filepath);
        while (fileReader.hasNextDouble()) {
            arr.add(fileReader.nextDouble());
        }
        fileReader.close();
        return arr;
    }
}