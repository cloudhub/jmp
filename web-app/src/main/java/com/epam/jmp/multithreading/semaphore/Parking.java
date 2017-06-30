package com.epam.jmp.multithreading.semaphore;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

/**
 * Created by Aleksei_Okhrimenko on 29.06.2017.
 */
public class Parking {

    private static final Logger LOGGER = Logger.getLogger(Parking.class);

    private static final boolean[] PARKING_PLACES = new boolean[5];

    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 7; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.printf("The car #%d has come to parking lot.\n", carNumber);

            try {
                SEMAPHORE.acquire();
                int parkingNumber = -1;
                synchronized (PARKING_PLACES) {
                    for (int i = 0; i < 5; i++) {
                        if (! PARKING_PLACES[i]) {
                            PARKING_PLACES[i] = true;
                            parkingNumber = i;
                            System.out.printf("The car #%d has parked on %d spot.\n", carNumber, i);
                            break;
                        }
                    }
                    Thread.sleep(5000);

                    synchronized (PARKING_PLACES) {
                        PARKING_PLACES[parkingNumber] = false;
                    }

                    SEMAPHORE.release();
                    System.out.printf("The car #%d has left the parking lot.\n", carNumber);
                }
            } catch (InterruptedException e) {

            }
        }
    }
}
