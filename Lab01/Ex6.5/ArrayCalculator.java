
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArrayCalculator {
    public static boolean isInvalidN(String s){//check N
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))) return true;
        }
        return false;
    }
    
    public static boolean isInvalidE(String s){//check array's elements
        for (int i = 0; i < s.length(); i++){
            if (!(Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')) return true;
        }
        return false;
    }
    
    public static int[] ArrayConverter(String[] a){//String[] to int[]
        int n = a.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(a[i]);
        }
        return nums;
    }
    
    public static int ArraySum(int[] a){//sum
        int sum = 0;
        for (int x : a) sum += x;
        return sum;
    }
    public static void main(String[] args) {
        String strN = JOptionPane.showInputDialog(null, "Input length of array");
        
        while (isInvalidN(strN)){//check input array's length
            int option = JOptionPane.showConfirmDialog(null,
                    "Invalid input!\nDo you want to try again?"
                    , "Error", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) return;
            strN = JOptionPane.showInputDialog(null, "Input length of array");
        }
        
        int n = Integer.parseInt(strN);
        
        String strArray = JOptionPane.showInputDialog(null, "Input array's elements <each seprated by spaces>");
        strArray = strArray.trim();
        String[] a = strArray.split("\\s+");
        while (a.length != n || isInvalidE(strArray)){//check input array's elements
            int option = JOptionPane.showConfirmDialog(null,
                    "Invalid input!\nDo you want to try again?"
                    , "Error", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) return;
            strArray = JOptionPane.showInputDialog(null, "Input array's elements <each seprated by spaces>");
            strArray = strArray.trim();
            a = strArray.split("\\s+");
        }
        
        //result
        int[] nums = ArrayConverter(a);
        Arrays.sort(nums);
        StringBuilder strNums = new StringBuilder(),
                strOriginal = new StringBuilder();
        for (int i = 0; i < n; i++){
            strNums.append(nums[i]); strNums.append(" ");
            strOriginal.append(a[i]); strOriginal.append(" ");
        }
        int sum = ArraySum(nums);
        double avg = (double)sum/n;
        
        JOptionPane.showMessageDialog(null,
                "Input array: " + strOriginal.toString()
                + "\nSorted array: " + strNums.toString()
                + "\nSum: " + sum + "\nAvarage: " + avg, 
                "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
