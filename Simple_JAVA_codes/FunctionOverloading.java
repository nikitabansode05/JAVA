public class FunctionOverloading {

    public void sum(){
        int a=5;
        int b=5;
        int sum=a+b;
        System.out.println(sum);
    }

    public int sum(int a,int b,int c){
        return a+b+c;
    }

    public int sum(int a,int b){
        return a+b;
    }
}
