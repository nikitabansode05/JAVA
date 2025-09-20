package com.transflower.Entity;

public class QuestionBank {
    private int subjectId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private char answerKey;
    private int evaluationCriteria;

    public QuestionBank(){
        subjectId=0;
        title="abc";
        optionA="a";
        optionB="b";
        optionC="c";
        optionD="d";
        answerKey='a';
        evaluationCriteria=5;
    }

    public QuestionBank(int subjectId,String title,String optionA,String optionB,String optionC,String optionD,char answerKey,int evaluationCriteria){
        this.subjectId=subjectId;
        this.title=title;
        this.optionA=optionA;
        this.optionB=optionB;
        this.optionC=optionC;
        this.optionD=optionD;
        this.answerKey=answerKey;
        this.evaluationCriteria=evaluationCriteria;
    }

    public void setId(int id){
        this.subjectId=id;
    }
    public int getId(){
        return subjectId;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }

    public void setOptionA(String A){
        this.optionA=A;
    }
    public String getOptionA(){
        return optionA;
    }

    public void setOptionB(String B){
        this.optionB=B;
    }
    public String getOptionB(){
        return optionB;
    }

    public void setOptionC(String C){
        this.optionC=C;
    }
    public String getOptionC(){
        return optionC;
    }

    public void setOptionD(String D){
        this.optionD=D;
    }
    public String getOptionD(){
        return optionD;
    }

    public void setAnswerKey(char answerKey){
        this.answerKey=answerKey;
    }
    public char getAnswerKey(){
        return answerKey;
    }

    public void setEvaluationCriteria(int evaluationCriteria){
        this.evaluationCriteria=evaluationCriteria;
    }
    public int getEvaluationCriteria(){
        return evaluationCriteria;
    }

    public String toString(){
        return ("Subject ID :"+subjectId+"\n"+
                "Title : "+title+"\n"+
                "Option A : "+optionA+"\n"+
                "Option B : "+optionB+"\n"+
                "Option C : "+optionC+"\n"+
                "Option D : "+optionD+"\n"+
                "Answer Key : "+answerKey+"\n"+
                "Evaluation Criteria : "+evaluationCriteria);
    }
}

