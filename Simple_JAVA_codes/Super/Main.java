class Animal{
    int legs;
    String type;
    String habitat;

    public Animal(){
        legs=2;
        type="herbivore";
        habitat="land";
    }

    public Animal(int legs,String type,String habitat){
        this.legs=legs;
        this.type=type;
        this.habitat=habitat;
    }

    public void setLegs(int legs){
        this.legs=legs;
    }
    public int getLegs(){
        return legs;
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }

    public void setHabitat(String habitat){
        this.habitat=habitat;
    }
    public String getHabitat(){
        return habitat;
    }

    public void walk(){
        System.out.println("Generally animal walks on 4 legs");
    }

    public String toString(){
        return ("Legs : "+legs+" "+"Type : "+type+" "+"Habitat : "+habitat);
    }
}


class Dog extends Animal{
    public void walk(){
        System.out.println("Dog walks on 4 leg");
    }

    public void AnimalWalk(){
         super.walk();
    }

    public void AnimalLegs(){
        int getLeg=super.getLegs();
        System.out.println(getLeg);
    }
}


public class Main {
    public static void main(String [] args){
       Animal animal=new Animal(2,"Carnivore","Land");
       Dog husky =new Dog();
       husky.walk();
       husky.AnimalWalk();
       husky.AnimalLegs();
    }
}
