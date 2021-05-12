package edu.miracosta.cs113;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable; 
import java.util.Scanner;

import edu.miracosta.cs113.BinaryTree.Node;



public class BinaryTree<E>{
	//instance variable which is the root Node (TOP)
		protected Node<E> root;
//		//data fields
		protected boolean addReturn;
		
		public BinaryTree() {
			this.root = null;
		}
		
		/*
		 * this method is here because client classes do not know about the Node Class. This 
		 * constructor can be used only in methods internal to the BinaryTree class and its subclasses
		 */
		protected BinaryTree(Node<E> root) {
			this.root = root;
		}
		
		/*
		 * @param data
		 * @param BinaryTree<E> leftTree
		 * @param BinaryTree<E> rightTree
		 */
		public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
			//using the Node constructor to give the root node data
			this.root = new Node<E>(data);
			
			if(leftTree != null) {
				this.root.left = leftTree.root;
			}else {
				this.root.left = null; 
			}
			
			if(rightTree != null) {
				this.root.right = rightTree.root;
			}else {
				this.root.right = null;
			}
			
			
		} 
		
		
		public BinaryTree<E> getLeftSubtree(){
			if(this.root != null && this.root.left != null) {
				return new BinaryTree<E>(this.root.left);
			}else {
				return null;
			}
		}
		
		
		public BinaryTree<E> getRightSubtree(){
			if(this.root != null && this.root.right != null) {
				return new BinaryTree<>(this.root.right);
			}else {
				return null;
			}
		}
		
		public E getData() {
			return this.root.data;
		}
		
		/*
		 * determines whether this tree is a leaf
		 * @return true if the root has no children
		 */
		public boolean isLeaf() {
			return (this.root.left == null && this.root.right == null);
		}
		
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			preOrderTraverse(this.root, 1, sb);
			return sb.toString();
		}
		
		/*
		 * perform the pre-order traversal
		 * @param Node the local root
		 * @param depth the Depth
		 * @param sb the string buffer to save the output
		 */
		private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
			for(int i = 1; i < depth; i++) {
				sb.append(" ");
			}
			
			if(node == null) {
				sb.append("null\n");
			}else {
				sb.append(node.toString());
				sb.append("\n");
				preOrderTraverse(node.left, depth + 1, sb);
				preOrderTraverse(node.right, depth + 1, sb);
			}
		}
		
		
		public static BinaryTree<String> readBinaryTree(Scanner scan){
			String data = scan.next();
			
			if(data.equals("null")){
				return null;
			}else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data, leftTree, rightTree);
			}
		}
		

	

		

		
		
		
		//node class
		protected static class Node<E>{
			//data field
			protected E data;
			//reference to left child Node
			protected Node<E> left;
			//reference to right child Node
			protected Node<E> right;
			
			/*
			 * construct a Node with the given data and no children.
			 * @param data The data to store in this node
			 */
			public Node(E data) {
				this.data = data;
				this.left = null;
				this.right = null;
			}
			
			/*
			 * return a string representation of the node.
			 * @return a string representation of the data
			 */
			public String toString() {
				return this.data.toString();
			}
		}

}
