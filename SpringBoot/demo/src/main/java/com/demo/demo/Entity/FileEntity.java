package com.demo.demo.Entity;

public class FileEntity {
    private String id;
    private String concept;
    private String subject;
    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private String data5;
    private String data6;
    private String data7;
    private String data8;


    // ✅ Constructor with all fields
    public FileEntity(String id, String concept, String subject,
                      String data1, String data2, String data3, String data4,
                      String data5, String data6, String data7, String data8) {
        this.id = id;
        this.concept = concept;
        this.subject = subject;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data6 = data6;
        this.data7 = data7;
        this.data8 = data8;
    }

    // ✅ Default constructor
    public FileEntity() {
    }

    // ✅ Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }
    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getData1() {
        return data1;
    }
    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }
    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }
    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }
    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }
    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }
    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }
    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }
    public void setData8(String data8) {
        this.data8 = data8;
    }

    // ✅ toString method
    @Override
    public String toString() {
        return "DataRecord{" +
                "id=" + id +
                ", concept='" + concept + '\'' +
                ", subject='" + subject + '\'' +
                ", data1='" + data1 + '\'' +
                ", data2='" + data2 + '\'' +
                ", data3='" + data3 + '\'' +
                ", data4='" + data4 + '\'' +
                ", data5='" + data5 + '\'' +
                ", data6='" + data6 + '\'' +
                ", data7='" + data7 + '\'' +
                ", data8='" + data8 + '\'' +
                '}';
    }
}

