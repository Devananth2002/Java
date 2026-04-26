package test;

class Singleton {

    private Singleton(){
        System.out.println("Object created...");
    }

    public static int INSTANCE_METHOD1 = 0;

    public static Integer createInstance(int a, int b){
        INSTANCE_METHOD1 = a + b;
        return INSTANCE_METHOD1;
    }

}


public class test {
    public static void main(String[] args) {

        System.out.println(Singleton.createInstance(2,3));


    }
}