/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nihansa
 */
public class AVLTree {

    class Node {
        int data, height;
        Node left, right;

        Node(int value) {
            data = value;
            height = 1;
        }
    }

    Node root;

    // Get height
    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    // Right rotate
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Get balance factor
    int getBalance(Node n) {
        if (n == null)
            return 0;
        return height(n.left) - height(n.right);
    }

    // Insert
    Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.data)
            node.left = insert(node.left, value);
        else
            node.right = insert(node.right, value);

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.data)
            return leftRotate(node);

        return node;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);

        System.out.print("AVL Tree Inorder: ");
        tree.inorder(tree.root);
    }
}
