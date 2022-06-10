//-----------------------------------------------------
// Title: This class have PlayerDatabaseMethods class's methods.
// Author:Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 3
// Description: This class tests PlayerDatabaseMethods methods and it is main class.
//-----------------------------------------------------
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerDatabase {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int number, minFee, maxFee;
		int transferFee;
		String name, surname, transferFee2;
		ArrayList<String> sentence;
		PlayerDatabaseMethods pd = new PlayerDatabaseMethods();
		System.out.println("Enter Operation Number");
		do {
			 //--------------------------------------------------------
			 // Summary:specifies the method to call.
			 // Precondition:Number is an integer value.
			 // Postcondition:The methods in the PlayerDataBaseMethods class are accessed.
			 //--------------------------------------------------------
			number = keyboard.nextInt();

			if (number == 1) {      //it takes input from user and calls addPlayer method
				do {
					name = keyboard.next();
					surname = keyboard.next();
					transferFee2 = keyboard.next();
					sentence = new ArrayList<>(Arrays.asList(transferFee2.split(",")));
					transferFee = Integer.parseInt(sentence.get(0));
					pd.addPlayer(name, surname, transferFee);

				}while(transferFee2.substring(transferFee2.length()-1).equals(","));
			}
			if (number == 2) {    // it calls removePlayer method.
				name = keyboard.next();
				surname = keyboard.next();
				pd.removePlayer(name, surname);

			}
			if (number == 3) {      // it calls searchByName method.
				name = keyboard.next();
				surname = keyboard.next();
				pd.searchByName(name, surname);
			}
			if (number == 4) {      // it calls searchByRange method.
				minFee = keyboard.nextInt();
				maxFee = keyboard.nextInt();
				keyboard.nextLine();
				pd.searchByRange(minFee, maxFee);
			}
			if (number == 5) {       // it calls printAllPlayers method.
				pd.printAllPlayers();
			}
			if (number == 6) {        // it calls FindKSmallest method.
				int numberFee = 0;
				numberFee = keyboard.nextInt();
				pd.FindKSmallest(numberFee);
			}
			if (number == 7) {       // End of the loop(Exit).
				break;
			}

		} while (number > 0);

		keyboard.close();

	}

}
