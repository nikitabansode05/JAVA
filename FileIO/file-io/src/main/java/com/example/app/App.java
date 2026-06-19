package com.example.app;


public class App 
{
    public static void main( String[] args )
    {
        try{
             CSVFileIO csvFileIO=new CSVFileIO();
            csvFileIO.read(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
    }

