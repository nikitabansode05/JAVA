package com.demo.demo.Entity;

import com.opencsv.bean.CsvBindByName;

public class SampleEntity {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private int age;
    @CsvBindByName
    private String city;
    @CsvBindByName
    private String course;
    @CsvBindByName
    private int score;
    @CsvBindByName
    private String status;

}
