

// I used try-catch in methods. because to check if node is empty.
import java.util.ArrayList;

public class PlayerDatabaseMethods {
	BTNode current0, current1, current2, current3, current4, current5;
	BinarySearchTree BT = new BinarySearchTree();

	public void addPlayer(String name, String surname, int transferFee)
	 
	{
		BT.add(name, surname, transferFee);
	}

	public void removePlayer(String name, String surname) 
	
	{

		current0 = BT.FindingData(BT.root, name, surname);
		int temp = current0.transferFee;
		BT.delete(name, surname, temp);
	}

	public void searchByName(String name, String surname) 

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
	
	{
		current3 = BT.root;
		BT.Inorder_traversal(current3);
		System.out.println();

	}

	public void FindKSmallest(int k) 
	
	{
		try {
			String name_surname = BT.arr.get(k - 1);
			System.out.println(name_surname);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("There is no player in database or first list the players as an ascending order.");
		}
	}
}
