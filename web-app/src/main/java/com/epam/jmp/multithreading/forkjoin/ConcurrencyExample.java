package com.epam.jmp.multithreading.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Aleksei_Okhrimenko on 30.06.2017.
 */
public class ConcurrencyExample {
    public static void main(String[] args) {
        final int SIZE = 10000;

        List<Integer> list = new ArrayList<Integer>(SIZE);

        for (int i=0; i<SIZE; i++){
            int value = (int) (Math.random() * 100);
            list.add(value);
        }

        QuickSort<Integer> quickSort = new QuickSort<Integer>(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);
    }
}
