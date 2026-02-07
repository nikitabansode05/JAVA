import java.util.*;

public class CompareByName implements Comparator<Student>{

    public CompareByName(){

    }

    @Override
    public int compare(Student s1,Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}