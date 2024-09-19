import javax.swing.JOptionPane;

public class EquationCalculator{
	public static void LinearEquation(){
		String str_a = JOptionPane.showInputDialog(null, "Input a",
		JOptionPane.INFORMATION_MESSAGE);
		String str_b = JOptionPane.showInputDialog(null, "Input b",
		JOptionPane.INFORMATION_MESSAGE);
		double a = Double.parseDouble(str_a);
		double b = Double.parseDouble(str_b);
		if (a != 0)
			JOptionPane.showMessageDialog(null, 
			"Input: " + str_a + "x + " + str_b + " = 0\n"
			+ "Result: x = " + (-b/a),
			"Result", JOptionPane.INFORMATION_MESSAGE);
		else{
			if (b == 0) 
				JOptionPane.showMessageDialog(null, 
				"Input: " + str_a + "x + " + str_b + " = 0\n"
				+ "Result: Infinite solutions",
				"Result", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, 
				"Input: " + str_a + "x + " + str_b + " = 0\n"
				+ "Result: No solution",
				"Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void LinearSystem(){
		JOptionPane.showMessageDialog(null, 
		"Input first equation", "First Equation", JOptionPane.INFORMATION_MESSAGE);
		String str_a11 = JOptionPane.showInputDialog(null, "Input a11",
		JOptionPane.INFORMATION_MESSAGE);
		String str_a12 = JOptionPane.showInputDialog(null, "Input a12",
		JOptionPane.INFORMATION_MESSAGE);
		String str_b1 = JOptionPane.showInputDialog(null, "Input b1",
		JOptionPane.INFORMATION_MESSAGE);
		//hihihihi
		JOptionPane.showMessageDialog(null, 
		"Input second equation", "Second Equation", JOptionPane.INFORMATION_MESSAGE);
		String str_a21 = JOptionPane.showInputDialog(null, "Input a21",
		JOptionPane.INFORMATION_MESSAGE);
		String str_a22 = JOptionPane.showInputDialog(null, "Input a22",
		JOptionPane.INFORMATION_MESSAGE);
		String str_b2 = JOptionPane.showInputDialog(null, "Input b2",
		JOptionPane.INFORMATION_MESSAGE);
		//convert
		double a11 = Double.parseDouble(str_a11), a12 = Double.parseDouble(str_a12),
		b1 = Double.parseDouble(str_b1), a21 = Double.parseDouble(str_a21),
		a22 = Double.parseDouble(str_a22), b2 = Double.parseDouble(str_b2);
		//caculate
		double D = a11*a22 - a21*a12,
		D1 = b1*a22 - b2*a12,
		D2 = a11*b2 - a21*b1;
		//result
		if (D != 0)
			JOptionPane.showMessageDialog(null, 
			"Input: " + str_a11 + "x1 + " + str_a12 + "x2 = " + str_b1 +"\n           " 
			+ str_a21 + "x1 + " + str_a22 + "x2 = " + str_b2 
			+ "\nResult: x1 = " + (D1/D) + "; x2 = " + (D2/D), "Result", 
			JOptionPane.INFORMATION_MESSAGE);
		else{
			if (D1 == 0 && D2 == 0)
				JOptionPane.showMessageDialog(null, 
				"Input: " + str_a11 + "x1 + " + str_a12 + "x2 = " + str_b1 +"\n           " 
				+ str_a21 + "x1 + " + str_a22 + "x2 = " + str_b2 
				+ "\nResult: Infinite solutions", "Result", 
				JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, 
				"Input: " + str_a11 + "x1 + " + str_a12 + "x2 = " + str_b1 +"\n           " 
				+ str_a21 + "x1 + " + str_a22 + "x2 = " + str_b2 
				+ "\nResult: No solution", "Result", 
				JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void SecondDegreeEquation(){
		String str_a = JOptionPane.showInputDialog(null, "Input a",
		JOptionPane.INFORMATION_MESSAGE);
		if (str_a.equals("0")){
			JOptionPane.showMessageDialog(null, "Liner Equation :))");
			LinearEquation();
			return;
		}
		String str_b = JOptionPane.showInputDialog(null, "Input b",
		JOptionPane.INFORMATION_MESSAGE);
		String str_c = JOptionPane.showInputDialog(null, "Input c",
		JOptionPane.INFORMATION_MESSAGE);

		double a = Double.parseDouble(str_a),
		b = Double.parseDouble(str_b),
		c = Double.parseDouble(str_c);

		double delta = b * b - 4 * a * c;
		if (delta < 0){
			JOptionPane.showMessageDialog(null, 
			"Input: " + str_a + "x^2  + " + str_b + "x + " + str_c + " = 0\n" + 
			"Result: No solutions", 
			"Result",
			JOptionPane.INFORMATION_MESSAGE);
		}
		else if (delta == 0){
			JOptionPane.showMessageDialog(null, 
			"Input: " + str_a + "x^2  + " + str_b + "x + " + str_c + " = 0\n" + 
			"Result: x = " + (-b/(2*a)), 
			"Result",
			JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			double x1 = (-b + Math.sqrt(delta)) / (2*a);
			double x2 = (-b - Math.sqrt(delta)) / (2*a);
			JOptionPane.showMessageDialog(null, 
			"Input: " + str_a + "x^2  + " + str_b + "x + " + str_c + " = 0\n" + 
			"Result: x1 = " + x1 + "; x2 = " + x2, 
			"Result",
			JOptionPane.INFORMATION_MESSAGE);
		}
	}//dai qua di!!!!!!!!!
	public static void main(String[] args){
		String typeE = JOptionPane.showInputDialog(null,
		"Select type of Equation(Type wanted number at the TextArea) \n"
		+ "1: Linear Equation\n"
		+ "2: Linear System\n"
		+ "3: Second-degree Equation", 
		"Select Equation", JOptionPane.INFORMATION_MESSAGE);

		if (typeE.equals("1")) LinearEquation();
		else if (typeE.equals("2")) LinearSystem();
		else if (typeE.equals("3")) SecondDegreeEquation();
		else JOptionPane.showMessageDialog(null, "Invalid input!!!");

		System.exit(0);
	}
}