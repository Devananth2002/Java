package Multithreading;

public class deamonThrd {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            for(int i=0;i<20;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Lightening.....");
            }
        });

        t.setDaemon(true);
        t.start();

        for(int i=0;i<5;i++) {
            Thread.sleep(1000);
            System.out.println("Dancing.....");
        }
    }

}
