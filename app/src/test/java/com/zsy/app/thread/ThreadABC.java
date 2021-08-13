package com.zsy.app.thread;

import org.junit.Test;

public class ThreadABC {

    @Test
    public void test() throws InterruptedException {
        PrintABC printABC = new PrintABC(1);
        Thread threadA = new Thread(new ThreadA(printABC));
        Thread threadB = new Thread(new ThreadB(printABC));
        Thread threadC = new Thread(new ThreadC(printABC));

        threadC.start();
        threadB.start();
        threadA.start();
    }

}

class PrintABC{

    private int num;

    public PrintABC(int num) {
        this.num = num;
    }

    public synchronized void printA() throws InterruptedException {
        while (num != 1){
            this.wait();
        }

        System.out.print("A");
        num = 2;
        this.notifyAll();
    }

    public synchronized void printB() throws InterruptedException {
        while (num != 2){
            this.wait();
        }
        System.out.print("B");

        num = 3; //通知打印C
        this.notifyAll();
    }
    public synchronized void printC() throws InterruptedException {
        while (num != 3){
            this.wait();
        }

        System.out.print("C");

        num = 1; //通知打印A
        this.notifyAll();
    }
}

class ThreadA implements Runnable{

    private PrintABC printABC;

    public ThreadA(PrintABC printABC) {
        this.printABC = printABC;
    }

    @Override
    public void run() {
        try {
            printABC.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadB implements Runnable{

    private PrintABC printABC;

    public ThreadB(PrintABC printABC) {
        this.printABC = printABC;
    }

    @Override
    public void run() {
        try {
            printABC.printB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadC implements Runnable{

    private PrintABC printABC;

    public ThreadC(PrintABC printABC) {
        this.printABC = printABC;
    }

    @Override
    public void run() {
        try {
            printABC.printC();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
