package com.example.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

public class CSVFileIO {
    public CSVFileIO(){

    }
    public void read() throws FileNotFoundException{
        try{       
        String[] line;

        InputStream input = getClass().getClassLoader().getResourceAsStream("data.csv");
        if (input == null) {
            throw new FileNotFoundException("data.csv not found in resources");
        }
        CSVReader reader = new CSVReader(new InputStreamReader(input));

        while ((line = reader.readNext()) != null) {
            for (String value : line) {
                System.out.print(value + " | ");
            }
            System.out.println();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
