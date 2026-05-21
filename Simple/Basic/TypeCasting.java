public class TypeCasting{
    public static void main(String[] args) {
        byte number=10;
        int castedNumber=number;
        System.out.println(castedNumber);

        int intno =12890365;
        if (intno<=Byte.MAX_VALUE) {
            byte castedInt=(byte) intno;
            System.out.println(castedInt);
        }else{
            System.out.println("Data loss may occur!!");
        }
        
    }
}