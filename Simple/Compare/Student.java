public class Student implements Comparable<Student>{
    String name;
    int roll_no;
    float marks;

    public Student(){
        name=" ";
        roll_no=0;
        marks=0;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public Student(String name,int roll_no,int marks){
        this.name=name;
        this.roll_no=roll_no;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student other){
        return Integer.compare(this.roll_no,other.roll_no);
    }



}