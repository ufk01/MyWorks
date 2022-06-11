
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
