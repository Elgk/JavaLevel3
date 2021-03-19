package lesson4;

public class Main {
    private static final Object monitor = new Object();
    private volatile char curLetter = 'A';

    public static void main(String[] args) {
        Main m = new Main();
        Thread t1 = new Thread(()->{
            m.printA();
        });
        Thread t2 = new Thread(()->{
            m.printB();
        });
        Thread t3 = new Thread(()->{
            m.printC();
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AppEnd");
    }

    public void printA(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (curLetter !='A'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                curLetter = 'B';
                monitor.notifyAll();
            }
        }
    }

    public void printB(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (curLetter !='B'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                curLetter = 'C';
                monitor.notifyAll();
            }
        }
    }

    public void printC(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (curLetter !='C'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                curLetter = 'A';
                monitor.notifyAll();
            }
        }
    }

}
