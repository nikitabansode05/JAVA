package com.tap.assessment.Entity;

public class SubjectModel implements Cloneable{

    private int id;
    private String subject;

    public SubjectModel() {}

    public SubjectModel(int id, String subject) {
        this.id = id;
        this.subject = subject;
    }
    
    // Getters and Setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getsubject(){
        return subject;
    }
    public void setsubject(String subject){
        this.subject=subject;
    }

    @Override
    public String toString(){
        return "SubjectModel{id="+id+",subject='"+subject+"'}";
    }

    // @Override
    // public boolean equals(Object obj){
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     SubjectModel other = (SubjectModel) obj;
    //     return id==other.id &&
    //             Objects.equals(subject, other.subject);
    // }

    // @Override
    // public int hashCode(){
    //     return Objects.hash(id,subject);
    // }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
