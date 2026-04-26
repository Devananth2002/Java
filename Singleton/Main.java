package Singleton;

class Singleton {

    private Singleton(){
        System.out.println("Object created...");
    }

    // Method 1 - Not thread safe
    private static final Singleton INSTANCE_METHOD1 = new Singleton();

    public static Singleton getInstanceMethod1(){
        return INSTANCE_METHOD1;
    }

    //Method 2 - Thread safe
    private static class Helper {
        private static final Singleton INSTANCE_METHOD2 = new Singleton();
    }

    public static Singleton getInstanceMethod2(){
        return Helper.INSTANCE_METHOD2;
    }

}


public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstanceMethod2();
        Singleton obj2 = Singleton.getInstanceMethod2();

        System.out.println(obj1 == obj2);

    }
}