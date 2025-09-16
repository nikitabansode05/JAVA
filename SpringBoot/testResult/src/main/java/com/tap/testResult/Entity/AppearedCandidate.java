package com.tap.testResult.Entity;

public class AppearedCandidate {
    private int testId;
    private int candidateId;
    private String firstName;
    private String lastName;

    public AppearedCandidate(){
        testId=0;
        candidateId=0;
        firstName="abc";
        lastName="xyz";
    }

    public AppearedCandidate(int testId,int candidateId,String firstName,String lastName){
        this.testId=testId;
        this.candidateId=candidateId;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void setTestId(int id){
        this.testId=id;
    }
    public int getTestId(){
        return testId;
    }

    public void setCandidateId(int id){
        this.candidateId=id;
    }
    public int getCandidateId(){
        return candidateId;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return("Test ID : "+testId+"\n"+"Candidate Id : "+candidateId+"\n"+"Name : "+firstName+" "+lastName);
    }


}
