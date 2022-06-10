//-----------------------------------------------------
// Title: This class have  PlayerDataBase methods.
// Author:Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 3
// Description: This class tests the methods and these methods uses the binary search tree methods .
//-----------------------------------------------------

// I used try-catch in methods. because to check if node is empty.
import java.util.ArrayList;

public class PlayerDatabaseMethods {
	BTNode current0, current1, current2, current3, current4, current5;
	BinarySearchTree BT = new BinarySearchTree();

	public void addPlayer(String name, String surname, int transferFee)
	 //--------------------------------------------------------
	 // Summary:Adds players' information received from the user
	 // Precondition:Name and surname are string values, transferFee is an integer value.
	 // Postcondition:Player data is saved with using binary search tree methods.
	 //--------------------------------------------------------
	{
		BT.add(name, surname, transferFee);
	}

	public void removePlayer(String name, String surname) 
	 //--------------------------------------------------------
	 // Summary:The requested player's information is deleted.
	 // Precondition:Name and surname are string values, current0 is a node value, temp is an integer value.
	 // Postcondition:Player data is removed with using binary search methods.
	 //--------------------------------------------------------
	{

		current0 = BT.FindingData(BT.root, name, surname);
		int temp = current0.transferFee;
		BT.delete(name, surname, temp);
	}

	public void searchByName(String name, String surname) 
	 //--------------------------------------------------------
	 // Summary:It is searched whether the name and surname of the player given in the parameter is in the player database.
	 // Precondition:Name and surname are string values, current1 is a node value, check is a boolean value, temp is an integer value.
	 // Postcondition:'true' or 'false' value is returned depending on whether the player is present or not.
	 //--------------------------------------------------------
	{
		try {
			current1 = BT.FindingData(BT.root, name, surname);
			int temp = current1.transferFee;
			boolean check = BT.Search(name, surname, temp);
			System.out.println(check);
		} catch (NullPointerException e) {
			System.out.println("false");
		}

	}

	public void searchByRange(int minFee, int maxFee) 
	 //--------------------------------------------------------
	 // Summary:Determines whether the received node is empty.It is searched whether there is a player in the range of min and max values received.
	 // Precondition:minFee and max Fee are integer value, current2 is a node value, arr is array list(String).
	 // Postcondition:It is the basic method that makes other methods work properly.
	 //--------------------------------------------------------
	{
		try {
			ArrayList<String> arr = new ArrayList<>();
			for (; minFee <= maxFee; minFee++) {
				current2 = BT.root;
				current2 = BT.SearchRange(current2, minFee);
				if (current2 != null) {
					arr.add(current2.name + " " + current2.surname + ", ");

				} else {
				}
			}
			for (int i = 0; i < arr.size(); i++) {
				if (i == arr.size() - 1) {
					System.out.print(arr.get(i).substring(0, arr.get(i).length() - 2));
					break;
				}
				System.out.print(arr.get(i));
			}
		} catch (NullPointerException e) {
			System.out.println("All of value are NULL in given range");
		}
		System.out.println();
	}

	public void printAllPlayers() 
	 //--------------------------------------------------------
	 // Summary:All players in the database are suppressed (according to the transfer fee - in ascending order).
	 // Precondition:Current3 is a node value.
	 // Postcondition:Players are sorted and printed according to their transfer fee (from smallest to largest).
	 //--------------------------------------------------------
	{
		current3 = BT.root;
		BT.Inorder_traversal(current3);
		System.out.println();

	}

	public void FindKSmallest(int k) 
	 //--------------------------------------------------------
	 // Summary:k.(parameter) reaches the transfer fee (according to the transfer fee in ascending order) and prints that player's first and last name.
	 // Precondition:k is an integer value, name_surname is a string value.
	 // Postcondition:it reached the player's name and surname.
	 //--------------------------------------------------------
	{
		try {
			String name_surname = BT.arr.get(k - 1);
			System.out.println(name_surname);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("There is no player in database or first list the players as an ascending order.");
		}
	}
}
