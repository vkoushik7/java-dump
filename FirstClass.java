class A{
    static{
        System.out.println("A static");
    }
    {
        System.out.println("A instance");
    }
    A(){
        System.out.println("A constructor");
    }
    public void fun(){
        System.out.println("A fun function");
    }
}
public class FirstClass{
    public static void main(String[] args){
        //A a = new A();
    }
}