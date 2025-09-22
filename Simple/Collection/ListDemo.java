import java.util.ArrayList;
import java.util.List;

public class ListDemo{
    String name;
    int age;
    
    ListDemo(){
        name="";
        age=0;
    }

    ListDemo(String name,int age){
        this.name=name;
        this.age=age;
    }
   
    public static void main(String[]args){
        List<String> nameList= new ArrayList<String>();
        nameList.add("Samruddhi");
        nameList.add("Sai");
        nameList.add("Chaitrali");

        for(String s: nameList){
            System.out.println(s);
        }
        

    }
}