package Multithreading;

class Web{

    // static synchronized void show (String name) throws InterruptedException {

    void show (String name) throws InterruptedException {

        synchronized (this){
            System.out.println("hello...");
        }

        for(int i=0;i<5;i++){
            System.out.print("Welcome ");
            Thread.sleep(1000);
            System.out.println(name);
        }

    }
}

class User extends Thread{

    String name;
    Web ob;

    User(Web ob, String name){
        this.ob = ob;
        this.name = name;
    }
    public void run(){
        try {
            ob.show(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class synch {

    public static void main(String[] args){
        Web ob = new Web();
        Web ob2 = new Web();
         User obj = new User(ob, "User1");
        User obj1 = new User(ob2, "User2");

        // All methods should be called in the same object for synchronization
        // Static synchronization -> block from class level (we can use multiple objects here)
        // synchronized can be used also for code block level

        obj.start();
        obj1.start();

    }

}
