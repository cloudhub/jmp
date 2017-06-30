package com.epam.jmp.multithreading.cyclicbarrier;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Aleksei_Okhrimenko on 29.06.2017.
 */
public class Ferry {
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("The ferry has smuggled the cars!");
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("The car #%d has come to the ferry.\n", carNumber);

                BARRIER.await();
                System.out.printf("The car #%d continued.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }

}
