package com.shoebuddinsaiyed.dsa.lab;

import java.util.HashSet;
import java.util.Set;

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class BinarySearchTree {
	Node root;

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.root = tree.insert(tree.root, 40);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 10);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 50);
		tree.insert(tree.root, 70);
		System.out.println("InOrder Traverse");
		tree.inOrderTraverse(tree.root);
		System.out.println();

		int sum = 130;
		tree.find_Pair_With_Given_Sum(tree.root, sum);

	}

	private Node insert(Node node, int key) {

		if (node == null) {
			node = new Node(key);
			return node;
		}

		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		}
		return node;
	}

	private void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.key + " ");
		inOrderTraverse(node.right);
	}

	private void find_Pair_With_Given_Sum(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		if (!find_Pair_Util(root, sum, set))
			System.out.print("Pairs doesn't exit" + "\n");

	}

	private boolean find_Pair_Util(Node node, int sum, Set<Integer> set) {
		if (node == null) {
			return false;
		}
		if (find_Pair_Util(node.left, sum, set))
			return true;
		int diff = sum - node.key;
		if (set.contains(diff)) {
			System.out.println("Given Pair are (" + node.key + "," + diff + ")");
			return true;
		} else {
			set.add(node.key);
		}
		return find_Pair_Util(node.right, sum, set);
	}

}
