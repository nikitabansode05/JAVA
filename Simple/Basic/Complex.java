public class Complex {
    private int real,imaginary;

    Complex(){
        real=0;
        imaginary=0;
    }

    Complex(int real,int img){
        this.real=real;
        imaginary=img;
    }

    Complex(Complex c1,Complex c2){
        c1.real=0;
        c1.imaginary=0;
        c2.real=0;
        c2.imaginary=0;
    }

    public void setreal(int r){
        this.real=r;
    }

    public void setimaginary(int img){
        this.imaginary=img;
    }

    public int getreal(){
        return real;
    }

    public int getimaginary(){
        return imaginary;
    }

    public Complex sum(Complex c1,Complex c2)
    {
        Complex temp=new Complex();
        temp.real=c1.real+c2.real;
        temp.imaginary=c1.imaginary+c2.imaginary;
        return temp;
    }
    public void display()
    {
        System.out.println("The Complex number is :"+ real +"+"+ imaginary +"i");
    }

    public static void main(String [] args){
        Complex c1=new Complex(5,2);
        Complex c2=new Complex(3,8);
        Complex c3=new Complex();

        c1.display();
        c2.display();    
        c3=c3.sum(c1,c2);
        c3.display();

    }
}
