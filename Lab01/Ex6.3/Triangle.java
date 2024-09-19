import java.util.Scanner;
import javax.swing.JOptionPane;

public class Triangle {
    public static boolean isInvalidInput(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))) return true;
        }
        return false;
    }
    
    public static int inputN(){
        String strN = JOptionPane.showInputDialog(null, "Input n");
        while (isInvalidInput(strN)){
            int option = JOptionPane.showConfirmDialog(null, 
                    "Invalid input\nDo you want to try again?", "Error", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) System.exit(0);
            strN = JOptionPane.showInputDialog(null, "Input n");
        }
        return Integer.parseInt(strN);
    }
    
    public static String drawTriangle(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n = inputN();
        JOptionPane.showMessageDialog(null, 
                "Input: " + n + "\nResult\n\n" + drawTriangle(n), "Result", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(drawTriangle(n));
    }
}
