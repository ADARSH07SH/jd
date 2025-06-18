package oopsMain;

class b extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("hi");
        }
    }
}

class c extends Thread {
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("hello");
        }
    }
}

public class A {
    public static void main(String[] args) {

        b b = new b();
        c c = new c();

        b.start();
       
        c.start();

    }
}