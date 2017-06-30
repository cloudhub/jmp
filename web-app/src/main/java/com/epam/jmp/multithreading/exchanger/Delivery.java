package com.epam.jmp.multithreading.exchanger;
import java.util.concurrent.Exchanger;

/**
 * Created by Aleksei_Okhrimenko on 29.06.2017.
 */
public class Delivery {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {
        String[] p1 = new String[]{"{parcel A->D}", "{parcel A->C}"};
        String[] p2 = new String[]{"{parcel B->C}", "{parcel B->D}"};
        new Thread(new Truck(1, "A", "D", p1)).start();
        Thread.sleep(100);
        new Thread(new Truck(2, "B", "C", p2)).start();
    }

    public static class Truck implements Runnable {
        private int number;
        private String dep;
        private String dest;
        private String[] parcels;

        public Truck(int number, String departure, String destination, String[] parcels) {
            this.number = number;
            this.dep = departure;
            this.dest = destination;
            this.parcels = parcels;
        }

        @Override
        public void run() {
            try {
                System.out.printf("In the truck #%d loaded: %s and %s.\n", number, parcels[0], parcels[1]);
                System.out.printf("The truck #%d has left point %s and goes to point %s.\n", number, dep, dest);
                Thread.sleep(1000 + (long) Math.random() * 5000);
                System.out.printf("The truck #%d has arrived at point E.\n", number);
                parcels[1] = EXCHANGER.exchange(parcels[1]);//При вызове exchange() поток блокируется и ждет
                //пока другой поток вызовет exchange(), после этого произойдет обмен посылками
                System.out.printf("The parcel for point %s moved to the truck #%d.\n", dest, number);
                Thread.sleep(1000 + (long) Math.random() * 5000);
                System.out.printf("The truck #%d has arrived in %s and delivered: %s and %s.\n", number, dest, parcels[0], parcels[1]);
            } catch (InterruptedException e) {
            }
        }
    }
}
