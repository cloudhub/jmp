package com.epam.jmp.troubleshooting.deadlock;

/**
 * Created by alexei.okhrimenko on 18.02.2017.
 */
public class ThreadDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();

        Thread thread1 = new Thread(new SyncThread(object1, object2), "thread1");
        Thread thread2 = new Thread(new SyncThread(object2, object3), "thread2");
        Thread thread3 = new Thread(new SyncThread(object3, object1), "thread3");

        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        Thread.sleep(5000);
        thread3.start();
    }
}
