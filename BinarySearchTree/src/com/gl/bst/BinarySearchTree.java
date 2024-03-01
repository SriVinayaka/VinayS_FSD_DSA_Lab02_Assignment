/**
 * 
 */
package com.gl.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 */
public class BinarySearchTree {

    private Node root;
    private static Queue<Integer> skewed_tree;
    private static Integer no_of_elements;

    public static void main(String[] string) {
        BinarySearchTree tree = new BinarySearchTree();
        skewed_tree = new LinkedList<>();
        no_of_elements = 0;
        
        Scanner scr = new Scanner(System.in);
        Integer element = 0;
        
        System.out.println("Enter the Number of Elements to be inserted into the Tree:");
        no_of_elements = scr.nextInt();
        
        if(no_of_elements == 0)
        {
        	System.out.println("No of Elements cannot be zero.");
        	System.out.println("Please try again.");
        	//String[] string = ["", "", ""];
        	System.exit(1);
        }
        
        for(int i = 0; i < no_of_elements; i++)
        {
        	System.out.printf("Enter element %d:\n", i+1);
        	element = scr.nextInt();
        	tree.insert(element);
        }
        /*
         *
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(10);
	        tree.insert(60);
	        tree.insert(55);
		 *
         */
        
        //System.out.print("In order traversal: ");
        tree.inorder(tree.root);
        
        System.out.println("Skewed Tree:");
        for(int i = 0; i < no_of_elements; i++)
        {
        	System.out.print(skewed_tree.poll());
        	System.out.print(" ");
        }
        
        scr.close();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            //System.out.print(node.data + " ");
            skewed_tree.add(node.data);
            inorder(node.right);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
