package Multithreading;

class shop{

    int availableStock = 20;

    synchronized public void order(int stockCount){
        if(availableStock >= stockCount){
            availableStock -= stockCount;
            System.out.println("Order confirmed... rem stock ==> " + availableStock);
        } else {
            try {
                System.out.println("Waiting for stock...");
                wait();
                order(stockCount);
            } catch (Exception e){

            }
        }
    }

    synchronized public void load(int loadStock){
        availableStock += loadStock;
        System.out.println("Stock loaded ==> " + availableStock);
        notify();
    }

}

public class interThread {

    public static void main(String[] args) throws InterruptedException {
        shop ob = new shop();
        new Thread(() ->  {
            try{
                ob.order(30);
            } catch(Exception e) {

            }
        }).start();
        Thread.sleep(1000);
        ob.load(100);
    }
}
