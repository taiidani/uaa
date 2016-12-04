package recursion;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    
    private T value;
    private Node left;
    private Node right;
    
    public Node(T value) {
	this.value = value;
    }

    public T getValue() {
	return value;
    }

    public Node getLeft() {
	return left;
    }

    public Node getRight() {
	return right;
    }

    public void addBranch(T left, T right) {
	addBranch(new Node(left), new Node(right));
    }
    
    public void addBranch(Node left, T right) {
	addBranch(left, new Node(right));
    }
    
    public void addBranch(T left, Node right) {
	addBranch(new Node(left), right);
    }
    
    public void addBranch(Node left, Node right) {
	this.left = left;
	this.right = right;
    }
    
    public String toString() {
	return getValue() + "";
    }
}
