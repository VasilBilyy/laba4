package org.example;
import org.junit.Test;

import java.util.*;

import  org.junit.Assert;

public class BSTNodeTest {
    @Test
    public void testBSTNode() {
        HashMap<Integer, String> mapData = new HashMap<>();
        BSTNode root = new BSTNode(1, "N0");
        Random random = new Random();
        Set<Integer> usedKeys = new HashSet<>();

        // Тесткейс 1
        for (int i = 1; i <= 20; i++) {
            int key;
            do {
                key = random.nextInt(1, 22);
            } while (!usedKeys.add(key));

            String value = "N" + (i + 1);
            mapData.put(key, value);
            root.insert(key, value);
            System.out.println("Key - " + key + ", Value - " + value);
        }

        // Тесткейс 2
        Assert.assertEquals(20, root.countNodes());
    }
}