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

        // Тесткейс 3
        for (int key : mapData.keySet()) {
            String expectedValue = mapData.get(key);
            String actualValue = root.search(key);
            Assert.assertEquals(expectedValue, actualValue);
        }

        int nonExistingKey = 100;
        Assert.assertNull(root.search(nonExistingKey));

        // Тесткейс 4
        int keyToRemove = 10;
        root.delete(keyToRemove);

        String newValue = "NewValue";
        root.insert(keyToRemove, newValue);
        Assert.assertEquals(newValue, root.search(keyToRemove));

        int existingKey = mapData.keySet().iterator().next();
        String differentValue = "DifferentValue";
        root.insert(existingKey, differentValue);
        Assert.assertEquals(20, root.countNodes());

        // Тесткейс 5
        root.delete(keyToRemove);
        Assert.assertNull(root.search(keyToRemove));
        Assert.assertEquals(19, root.countNodes());
    }
}