import javax.swing.JOptionPane;
public class DoubleCalculator{
	public static void main(String[] args){
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null, 
"Please input the first number: ","Input the first number",
JOptionPane.INFORMATION_MESSAGE);
		
		strNum2 = JOptionPane.showInputDialog(null,
"Please input the second number: ","Input the second number",
JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);

		String div = "";
		
		double sum = num1 + num2,
			diff = num1 - num2,
			prod = num1 * num2;
		if (num2 != 0) div = "Quotient: " + (num1/num2);
		else div = "Invalid input to caculated quotient";
		
		JOptionPane.showMessageDialog(null, 
"Sum: " + sum + "\nDifference: " + diff + "\nProduct: " + prod + "\n" + div,
"Result :3", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}