package Multithreading;

class bank{

    private int balance = 10000;
    static private int reward  = 100;

    public void deposit(){
        int amount = 100;
        balance += amount;
        System.out.println("Available balance ==> " + balance);
    }

    // Member inner class
    class gpay{

        public void tran(){
            balance -= 200;
            System.out.println("Transaction completed.... available balance " + balance);
        }

    }

    // Method local inner class
    void netbanking(){

        class cashback{
            public void payment(){
                balance += 5;
                System.out.println("Cash back received.... Available balance " + balance);
            }
        }

        cashback c = new cashback();
        c.payment();

    }

    // Static inner class
    static class Rewards{
        public void getRewards(){
            System.out.println("Available Rewards...." + reward);
        }

        public static void updateRewards(){
            System.out.println("Rewards updated....");
        }
    }

}

abstract class dummy{

    public void print(){
        System.out.println("Printing....");
    }

}

public class InnerClass {

    public static void main(String[] args){
        bank b = new bank();
        b.deposit();

        bank.gpay bg = b.new gpay();
        bg.tran();
        b.netbanking();

        // Anonymous class
        bank b1 = new bank(){
            public void deposit(){
                int amount = 500;
                int balance = amount;
                System.out.println("Available balance ==> " + balance); 
            }
        };
        b1.deposit();

        dummy d = new dummy(){  // ex: class $Multithreading.dummy extends Multithreading.dummy
            public void print(){
                System.out.println("Printing1....");
            }
        };
        d.print();


        bank.Rewards br = new bank.Rewards();
        br.getRewards();   // accessing non-static method in static class

        bank.Rewards.updateRewards();  // accessing static method in static class

    }

}