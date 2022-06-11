

import java.util.ArrayList;

public class BinarySearchTree {
	BTNode root, temp;
	ArrayList<String> arr = new ArrayList<String>();// Used inside Inorder Traversal method to keep items in ascending order.
	int count = 0;//defined to find the number of nodes in the tree.
	

	BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty(BTNode root) 

	{
		return root == null;
	}

	public BTNode addRecursive(BTNode root, String name, String surname, int transferFee) 
	 
	{

		if (isEmpty(root)) {
			root = new BTNode(name, surname, transferFee);
			count++;
		} else {
			if (root.transferFee > transferFee) {
				root.left = addRecursive(root.left, name, surname, transferFee);
				// System.out.println("Added left side ");
			} else if (root.transferFee < transferFee) {
				root.right = addRecursive(root.right, name, surname, transferFee);
				// System.out.println("Added right side");
			} else {
				return null;
			}
		}

		return root;
	}

	public void add(String name, String surname, int data)
	 
	{
		root = addRecursive(root, name, surname, data);
	}

	public BTNode deleteRecursive(BTNode root, String name, String surname, int transferFee) 
	
	{

		if (isEmpty(root)) {
			return null;
		}
		if (root.transferFee > transferFee) {
			root.left = deleteRecursive(root.left, name, surname, transferFee);

		} else if (root.transferFee < transferFee) {
			root.right = deleteRecursive(root.right, name, surname, transferFee);

		} else {  //This condition represents root.transferFee==transferFee
			if (root.left == null && root.right == null) {//There is no child condition.
				root = null;
				return root;

			} else if (root.left != null) {//there is one or two child condition.

				root = root.left;
				while (root.left != null) {
					root = root.right;
				}
				root.right = deleteRecursive(root.right, name, surname, transferFee);

			} else if (root.right != null) {//there is one or two child condition.
				root = root.right;
				while (root.left != null) {
					root = root.left;
				}
				root.left = deleteRecursive(root.left, name, surname, transferFee);
			}
		}
		count--;
		return root;
	}

	public void delete(String name, String surname, int transferFee) 
	    
	{
		root = deleteRecursive(root, name, surname, transferFee);
		// System.out.println(root.name +" "+root.surname +" "+ root.transferFee);

	}

	public BTNode FindingData(BTNode root, String name, String surname)
	     
	{

		if (isEmpty(root)) {
			return null;
		} else {
			if (root.name.equals(name) && root.surname.equals(surname)) {
				return root;
			}
			BTNode current = FindingData(root.left, name, surname);
			if (current != null) {

				return current;
			}
		}
		return FindingData(root.right, name, surname);
	}

	public static int sizeCount = 0; //The value I created to prevent the last comma after printing all the values.

	public void printAll()
	     
	{
		sizeCount = 0;
		Inorder_traversal(root);
	}

	public void Inorder_traversal(BTNode root) 
    
	{

		if (isEmpty(root)) {
			return;
		}
		Inorder_traversal(root.left);
		arr.add(root.name + " " + root.surname);
		sizeCount++;
		if (sizeCount != count) {
			System.out.print(root.name + " " + root.surname + " " + root.transferFee + ", ");
		} else {
			System.out.print(root.name + " " + root.surname + " " + root.transferFee + " ");
		}
		Inorder_traversal(root.right);
	}

	public BTNode SearchRecursive(BTNode root, String name, String surname, int transferFee)
	
	{

		if (isEmpty(root)) {
			return null;
		} else {
			if (root.transferFee == transferFee) {
				return root;
			} else if (root.transferFee > transferFee) {
				SearchRecursive(root.left, name, surname, transferFee);

			} else {
				SearchRecursive(root.right, name, surname, transferFee);

			}

		}
		return root;
	}

	public boolean Search(String name, String surname, int transferFee)
	
	{
		root = SearchRecursive(root, name, surname, transferFee);
		if (root != null) {
			return true;
		} else {
			return false;
		}

	}

	public BTNode SearchRange(BTNode root, int data)
	    
	{
		if (isEmpty(root)) {
			return null;
		} else {
			if (root.transferFee == data) {
				return root;
			}
			BTNode current = SearchRange(root.left, data);
			if (current != null) {
				return current;
			}
		}
		return SearchRange(root.right, data);
	}
}
