package com.epam.jmp.multithreading.countdownlatch;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Aleksei_Okhrimenko on 29.06.2017.
 */
public class Race {

    private static final CountDownLatch START = new CountDownLatch(8);

    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(1000);
        }

        while (START.getCount() > 3)
            Thread.sleep(100);

        Thread.sleep(1000);
        System.out.println("Ready!");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Set!");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Go!");
        START.countDown();
    }

    public static class Car implements Runnable {

        private int carNumber;

        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {

            try {

                System.out.printf("The car #%d has come to the start line.\n", carNumber);

                START.countDown();

                START.await();
                Thread.sleep(trackLength / carSpeed);
                System.out.printf("The car #%d has finished!\n", carNumber);
            } catch (InterruptedException e) {

            }
        }
    }
}
