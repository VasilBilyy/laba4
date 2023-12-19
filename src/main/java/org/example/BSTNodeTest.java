package org.example;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class BSTNodeTest {
    @Test
    public void testBSTNode() {
        HashMap<Integer, String> mapData = new HashMap<>();


        BSTNode root = new BSTNode(0, "N0");
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            int key = random.nextInt(1, 21);
            String value = "N" + (i + 1);
            mapData.put(key, value);
            root.insert(key, value);
        }
    }
}
