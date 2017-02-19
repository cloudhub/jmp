package com.epam.jmp.troubleshooting.memoryleak;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexei.okhrimenko on 19.02.2017.
 */
public class KeylessEntry {

    public static void main(String[] args) {
        Map map = new HashMap();
        while (true)
            for (int i = 0; i < 10000; i++) {
                if (!map.containsKey(i)) {
                    map.put(new Key(i), "Number: " + i);
                }
            }
    }

    static class Key {
        Integer id;

        public Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        /**
         @Override public boolean equals(Object o) {
         boolean response = false;
         if (o instanceof Key) {
         response = (((Key)o).id).equals(this.id);
         }
         return response;
         }
         */
    }
}
