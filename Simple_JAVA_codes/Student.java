class Student{

    private int roll_no;  //Data Members
    private String name;
    private float result;
    private int standard;

    //Default Constructor
    Student(){
        roll_no=1;
        name="abc";
        result=50;
        standard=3;
    }

    //Parametrised Constructor
    Student(int roll_no,String name,float result,int standard){
        this.roll_no=roll_no;
        this.name=name;
        this.result=result;
        this.standard=standard;
    }

    //Copy Constructor
    Student(Student student){
       this.roll_no=student.roll_no;
       this.name=student.name;
       this.result=student.result;
       this.standard=student.standard;

    }

    public void setRollNo(int number){
        this.roll_no=number;
    }

    public int getRollNo(){
        return roll_no;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setResult(float result){
        this.result=result;
    }

    public float getResult(){
        return result; 
    }

    public void setStandard(int Standard){
        this.standard=standard;
    }

    public int getStandard(){
        return standard;
    }

    @Override
    public String toString(){
        return ("Roll No :"+roll_no+" "+"Name : "+name+" "+"Result : "+result+" "+"Standard : "+standard);
    }

    public static void main(String []args){
        Student student1=new Student(); //Invoked using default Constructor
        Student student2=new Student(11,"Nikita Bansode",45,15);

        System.out.println("******************************");
        System.out.println("The data of first Student is :");
        System.out.println(student1);

        System.out.println("******************************");
        System.out.println("The data of second Student is : ");
        System.out.println(student2);

        System.out.println("******************************");
        System.out.println("Student 3 printed using copy constructor");
        Student student3=new Student(student2);
        System.out.println(student3);

        System.out.println("******************************");
        System.out.println("Student 3 printed after using set function");
        student3.setRollNo(15);
        student3.setResult(80);
        System.out.println(student3);

        String stuName=student3.getName();
        System.out.println(stuName);
    }
}

