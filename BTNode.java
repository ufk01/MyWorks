//-----------------------------------------------------
// Title: Node class for binary search tree.
// Author:Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 3
// Description: This class have attributes which are necessary to implement to whole code. 
//-----------------------------------------------------
public class BTNode {
int transferFee;
String name,surname;
BTNode left,right;
    public BTNode(String name, String surname, int transferFee) {
    	this.name=name;                                                         // Each node has 3 data. These are name, surname and transfer fee.
    	this.surname=surname;
    	this.transferFee=transferFee;
    	right=left=null;
    }
}
