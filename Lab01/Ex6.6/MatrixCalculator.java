
import javax.swing.JOptionPane;

public class MatrixCalculator {
    public static boolean isInvalidInput(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') return true;
        }
        return false;
    }
    
    public static int[] sizesInput(){//input width and height
        String strSize = JOptionPane.showInputDialog(null,
                "Input size of matrices: Width and Height <separated by spaces>");
        String[] size = strSize.trim().split("\\s+");
        while (isInvalidInput(strSize) || size.length != 2){
            int option = JOptionPane.showConfirmDialog(null, 
                    "Invalid input!\nDo you want to try again?",
                    "Error", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) System.exit(0);
            strSize = JOptionPane.showInputDialog(null,
                "Input size of matrices: Width and Height <separated by spaces>");
            size = strSize.trim().split("\\s+");
        }
        int[] res = {Integer.parseInt(size[0]), Integer.parseInt(size[1])};
        return res;
    }
    
    public static int[] arrayInput(int i, int limit){//input a row
        String strArr = JOptionPane.showInputDialog(null, "Input row" + i
        + "<separated by spaces");
        String[] tmp = strArr.trim().split("\\s+");
        while (isInvalidInput(strArr) || tmp.length != limit){
            int option = JOptionPane.showConfirmDialog(null, 
                    "Invalid input!\nDo you want to try again?", 
                    "Error", JOptionPane.YES_NO_OPTION);
            strArr = JOptionPane.showInputDialog(null, "Input row" + i
            + "<separated by spaces");
            tmp = strArr.trim().split("\\s+");
        }
        
        int[] res = new int[limit];
        for (int idx = 0; idx < limit; idx++){
            res[idx] = Integer.parseInt(tmp[idx]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] width_height = sizesInput();
        int width = width_height[0], height = width_height[1];
        int[][] nums1 = new int[width][height];
        int[][] nums2 = new int[width][height];
        
        JOptionPane.showMessageDialog(null,"Input first Matrix");
        for (int i = 0; i < height; i++){
            nums1[i] = arrayInput(i, width);
        }
        
        JOptionPane.showMessageDialog(null,"Input second Matrix");
        for (int i = 0; i < height; i++){
            nums2[i] = arrayInput(i, width);
        }
        
        Matrix A = new Matrix(height, width, nums1);
        Matrix B = new Matrix(height, width, nums2);
        Matrix C = A.add(B);
        JOptionPane.showMessageDialog(null, "Matrix 1:\n"
                + A.toString() + "\nMatrix 2:\n" + B.toString()
                + "\nResult:\n" + C.toString(), 
                "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
