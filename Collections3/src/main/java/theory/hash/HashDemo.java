package theory.hash;

import java.util.HashMap;
import java.util.Map;

public class HashDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] keys = {"AaAaAaAa", "AaAaAaBB", "AaAaBBAa", "AaAaBBBB", "AaBBAaAa", "AaBBAaBB", "AaBBBBAa",
                "BBBBBBBB", "AaBBBBBB", "BBAaBBBB", "BBBBAaBB", "BBAaAaBB", "BBBBAaAa"};

        for (String key : keys) {
            int h = key.hashCode();
            int hash = h ^ (h >>> 16);
            int index = 15 & hash;

            System.out.println(key + ": " + hash + ", index: " + index);
        }

        map.put(keys[0], 1);
        map.put(keys[1], 2);
        map.put(keys[2], 3);
        map.put(keys[3], 4);
        map.put(keys[4], 5);
        map.put(keys[5], 6);
        map.put(keys[6], 7);
        map.put(keys[7], 8);
        map.put(keys[8], 9);
        map.put(keys[9], 10);
        map.put(keys[10], 11);
        map.put(keys[11], 12);
        map.put(keys[12], 13);

        for(String key : keys) {
            System.out.println(map.get(key));
        }
    }
}
