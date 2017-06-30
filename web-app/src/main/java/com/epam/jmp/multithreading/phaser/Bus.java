package com.epam.jmp.multithreading.phaser;
import java.util.ArrayList;
import java.util.concurrent.Phaser;

/**
 * Created by Aleksei_Okhrimenko on 29.06.2017.
 */
public class Bus {
    private static final Phaser PHASER = new Phaser(1);

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, i + 1));

            if ((int) (Math.random() * 2) > 0)
                passengers.add(new Passenger(i, 5));
        }

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("The bus left the park.");
                    PHASER.arrive();
                    break;
                case 6:
                    System.out.println("The bus went to the park.");
                    PHASER.arriveAndDeregister();
                    break;
                default:
                    int currentBusStop = PHASER.getPhase();
                    System.out.println("The bus stop # " + currentBusStop);

                    for (Passenger p : passengers)
                        if (p.departure == currentBusStop) {
                            PHASER.register();
                            p.start();
                        }

                    PHASER.arriveAndAwaitAdvance();
            }
        }
    }

    public static class Passenger extends Thread {
        private int departure;
        private int destination;

        public Passenger(int departure, int destination) {
            this.departure = departure;
            this.destination = destination;
            System.out.println(this + " is waiting on the bus stop # " + this.departure);
        }

        @Override
        public void run() {
            try {
                System.out.println(this + " got on the bus.");

                while (PHASER.getPhase() < destination)
                    PHASER.arriveAndAwaitAdvance();

                Thread.sleep(1);
                System.out.println(this + " got off the bus.");
                PHASER.arriveAndDeregister();
            } catch (InterruptedException e) {
            }
        }

        @Override
        public String toString() {
            return "The passenger{" + departure + " -> " + destination + '}';
        }
    }
}
