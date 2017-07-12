package com.epam.jmp.troubleshooting.gc;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * Created by Aleksei_Okhrimenko on 12.07.2017.
 */
public class GCExample {
    private static final int OBJECT_SIZE           = Integer.getInteger("obj.size", 192);
    private static final int BUFFER_SIZE           = Integer.getInteger("buf.size", 64 * 1024);
    private static final boolean WEAK_REFS_FOR_ALL = Boolean.getBoolean("weak.refs");

    private static Object makeObject() {
        return new byte[OBJECT_SIZE];
    }

    public static volatile Object sink;

    public static void main(String[] args) throws InterruptedException {

        System.out.printf("Buffer size: %d; Object size: %d; Weak refs for all: %s%n", BUFFER_SIZE, OBJECT_SIZE, WEAK_REFS_FOR_ALL);

        final Object substitute = makeObject();
        final Object[] refs = new Object[BUFFER_SIZE];

        System.gc();

        for (int index = 0;;) {
            Object object = makeObject();
            sink = object;

            if (!WEAK_REFS_FOR_ALL) {
                object = substitute;
            }

            refs[index++] = new WeakReference<>(object);

            if (index == BUFFER_SIZE) {
                Arrays.fill(refs, null);
                index = 0;
            }
        }
    }
}
