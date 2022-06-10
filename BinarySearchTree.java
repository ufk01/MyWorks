//-----------------------------------------------------
// Title: This class have binary search tree methods.
// Author:Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 3
// Description: This class tests the binary search tree methods.
//-----------------------------------------------------

import java.util.ArrayList;

public class BinarySearchTree {
	BTNode root, temp;
	ArrayList<String> arr = new ArrayList<String>();// Used inside Inorder Traversal method to keep items in ascending order.
	int count = 0;//defined to find the number of nodes in the tree.
	

	BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty(BTNode root) 
	 //--------------------------------------------------------
	 // Summary: Determines whether the received node is empty.
	 // Precondition:Root is a node value.
	 // Postcondition:It is the basic method that makes other methods work properly.
	 //--------------------------------------------------------
	{
		return root == null;
	}

	public BTNode addRecursive(BTNode root, String name, String surname, int transferFee) 
	 //--------------------------------------------------------
	 // Summary:It is used to add nodes to the tree.
	 // Precondition: root is a node value, name and surname are string values, transferFee is an integer value.
	 // Postcondition: Makes the tree skeleton ready for other methods.
	 //--------------------------------------------------------
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
	     //--------------------------------------------------------
		 // Summary:Invokes the addRecursive method and creates the skeleton of the tree.
		 // Precondition:Name and surname are string values, data is an integer value
		 // Postcondition:It calls the AddRecursive method and is ready to be called as a method 
		 //--------------------------------------------------------
	{
		root = addRecursive(root, name, surname, data);
	}

	public BTNode deleteRecursive(BTNode root, String name, String surname, int transferFee) 
	//--------------------------------------------------------
		 // Summary:Extracts the data (node) to be removed from the tree and returned removed value(node).
		 // Precondition:Root is a node value, name and surname are string value and transferFee is an integer value.
		 // Postcondition:After the desired data is output, it organizes the tree skeleton according to the extracted data.
		 //--------------------------------------------------------
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
	     //--------------------------------------------------------
		 // Summary:It calls the deleteRecursive method and removes the desired node.
		 // Precondition:Name and surname are string values, transferFee is an integer value.
		 // Postcondition:It calls the deleteRecursive method and performs its postcondition part.
		 //--------------------------------------------------------
	{
		root = deleteRecursive(root, name, surname, transferFee);
		// System.out.println(root.name +" "+root.surname +" "+ root.transferFee);

	}

	public BTNode FindingData(BTNode root, String name, String surname)
	     //--------------------------------------------------------
		 // Summary:It is used to find the transfer fee of a person whose name and surname is given.
		 // Precondition:Root is a node value, name and surname are string values. 
		 // Postcondition:The transfer fee of the requested person is reached.
		 //--------------------------------------------------------
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
	     //--------------------------------------------------------
		 // Summary:it called Inorder_traversal method and suppresses values at all nodes in the tree's structure.
		 // Precondition:There is no value.
		 // Postcondition:We will have printed all player information 
	     //and it kept all the values in the node in the array list, with the transfer fees of the players in ascending order.
		 //--------------------------------------------------------
	{
		sizeCount = 0;
		Inorder_traversal(root);
	}

	public void Inorder_traversal(BTNode root) 
         //--------------------------------------------------------
	     // Summary:It printed all of the values in nodes and held the elements in an array.
		 // Precondition:Root is a node value.
		 // Postcondition:We will had array list which is player's information(name and surname) 
	     //and printed player's information as an ascending order(according the transferFee).
		 //--------------------------------------------------------
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
	//--------------------------------------------------------
		 // Summary:The desired player data is found.
		 // Precondition:Root is a node value, name and surname are string values, transferFee is an integer value.
		 // Postcondition:The data of the desired person is accessed.
		 //--------------------------------------------------------
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
	//--------------------------------------------------------
		 // Summary:It calls SearchRecursive methods and the desired person is found.
		 // Precondition:Name and surname are string values and transferFee is an integer value.
		 // Postcondition:It has same postcondition with SearchRecursive postcondition's.
		 //--------------------------------------------------------
	{
		root = SearchRecursive(root, name, surname, transferFee);
		if (root != null) {
			return true;
		} else {
			return false;
		}

	}

	public BTNode SearchRange(BTNode root, int data)
	     //--------------------------------------------------------
		 // Summary:It has the same function as the search method, but the parameter is different.
	     //Finds nodes of players with transfer fees between given values
		 // Precondition:Root is a node value, data is an integer value.
		 // Postcondition:Finds players with transfer fees in the desired range.
		 //--------------------------------------------------------
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
