package org.example;
public class BSTNode {
    int key;
    String value;
    BSTNode left, right;

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }



    public void insert(int key, String value) {
        if (key < this.key) {
            if (left == null) {
                left = new BSTNode(key, value);
            } else {
                left.insert(key, value);
            }
        } else if (key > this.key) {
            if (right == null) {
                right = new BSTNode(key, value);
            } else {
                right.insert(key, value);
            }
        } else {
            this.value = value;
        }
    }

    public BSTNode delete(int key) {
        if (key < this.key) {
            if (left != null) {
                left = left.delete(key);
            }
        } else if (key > this.key) {
            if (right != null) {
                right = right.delete(key);
            }
        } else {
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }

            this.key = minValue(right);

            right = right.delete(this.key);
        }
        return this;
    }

    private int minValue(BSTNode node) {
        int minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }

    public String search(int key) {
        if (key == this.key) {
            return this.value;
        } else if (key < this.key && left != null) {
            return left.search(key);
        } else if (key > this.key && right != null) {
            return right.search(key);
        }
        return null;
    }

    public void traverse() {
        traverseInOrder(this);
    }

   private void traverseInOrder(BSTNode root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.println("Key: " + root.key + ", Value: " + root.value);
            traverseInOrder(root.right);
        }
    }

    public int countNodes() {
        return countNodes(this);
    }

    private int countNodes(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}


