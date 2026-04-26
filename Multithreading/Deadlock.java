package Multithreading;

class One{

    synchronized void method1(Two obj){
        System.out.println("Method 1");
        obj.method4();
    }

    synchronized void method2(){
        System.out.println("Method 2");
    }

}

class Two{

    synchronized void method3(One ob){
        System.out.println("Method 3");
        ob.method2();
    }

    synchronized void method4(){
        System.out.println("Method 4");
    }

}

class childthrd extends Thread{

    One ob;
    Two obj;

    childthrd(One ob, Two obj){
        this.ob = ob;
        this.obj = obj;
    }

    public void run(){
        obj.method3(ob);
    }

}

public class Deadlock extends Thread {

    One ob;
    Two obj;

    Deadlock(One ob, Two obj){
        this.ob = ob;
        this.obj = obj;
    }

    public void run(){
        ob.method1(obj);
    }

    public static void main(String[] args){

        One d = new One();
        Two d2 = new Two();

        childthrd t = new childthrd(d, d2);
        Deadlock t2 = new Deadlock(d, d2);

        t.start();
        t2.start();

    }
}
