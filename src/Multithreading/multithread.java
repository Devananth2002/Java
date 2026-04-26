package Multithreading;

class multi2 implements Runnable{
    public void run(){
        for(int i=0;i<3;i++){
            Thread.yield();
            System.out.println("thread3");
        }
    }
}

public class multithread extends Thread{

    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("thread2");
        }
    }

    public static void multithread(String[] args) throws InterruptedException {

        multithread t2 = new multithread();
        t2.start();
        //t2.setPriority(2);
        t2.join();

        multi2 obj = new multi2();
        Thread t3 = new Thread(obj);
        t3.start();
        //t3.setPriority(10);
        //t3.join();

        //Thread.sleep(5000);
        //System.out.println(t3.getState());
        System.out.println(t3.isAlive());


        //System.out.println(t3.getPriority());

        // Assigning Thread names
//        t2.setName("2nd Thread");
//        t3.setName("3rd Thread");
//        Thread.currentThread().setName("Main Thread");

//        for(int i=0;i<3;i++){
//            System.out.println("Main thread");
//        }

//        System.out.println(Thread.activeCount());
//        System.out.println(t2.getName());
//        System.out.println(t3.getName());
//        System.out.println(Thread.currentThread().getName());


//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
    }
}