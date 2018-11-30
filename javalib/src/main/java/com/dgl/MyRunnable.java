package com.dgl;


public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.print("this is myRunnable........");
    }
}

class Test {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}




