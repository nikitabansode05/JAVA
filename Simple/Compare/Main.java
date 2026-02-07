import java.util.*;

public class Main {

    public static void main(String [] args){
    
        List<Student> students=new ArrayList<>();
        Student nikita=new Student("Nikita",1,34);
        Student sakshi=new Student("Sakshi",2,32);
        Student kajal=new Student("Kajal",3,43);

        students.add(nikita);
        students.add(sakshi);
        students.add(kajal);

        System.out.println("Natural order : ");
        Collections.sort(students);
        students.forEach(System.out::println);

        System.out.println("Order by name : ");
        Collections.sort(students,new CompareByName());
        students.forEach(System.out::println);
        
       System.out.println(nikita.compareTo(sakshi));
    }
}
