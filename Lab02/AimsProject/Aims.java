import javax.swing.*;

public class Aims {
    public static int inputNumberOfDVDs(){
        String s = JOptionPane.showInputDialog(null, "Input number of DVDS");
        boolean invalid = true;

        while (invalid){
            int i = 0;
            for (i = 0; i < s.length(); i++){
                if (!Character.isDigit(s.charAt(i))){
                    break;
                }
            }
            if (i == s.length()) invalid = false;
            else{
                int Option = JOptionPane.showConfirmDialog(null, "Invalid input!\n Retry?", "Error", JOptionPane.YES_NO_OPTION);
                if (Option == JOptionPane.NO_OPTION) invalid = false;
                else{
                    s = JOptionPane.showInputDialog(null, "Input number of DVDS");
                }
            }
        }

        return Integer.parseInt(s);
    }
    public static DigitalVideoDisc inputDVDs(){
        String s = JOptionPane.showInputDialog(null,
                "Input DVD infomation <seperated by %>\n"
                + "title%category%director%length%cost" + "\nLength just required in full-formed input");
        String[] info = s.trim().split("%");
        for (String x : info) System.out.println(x);

        if (info.length == 1){
            return new DigitalVideoDisc(info[0]);
        }
        else if (info.length == 3){
            return new DigitalVideoDisc(info[0], info[1], Float.parseFloat(info[2]));
        }
        else if (info.length == 4){
            return new DigitalVideoDisc(info[0], info[1], info[2], Float.parseFloat(info[3]));
        }
        else return new DigitalVideoDisc(info[0], info[1], info[2], Integer.parseInt(info[3]), Float.parseFloat(info[4]));
    }

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        int n = inputNumberOfDVDs();

        for (int i = 0; i < n; i++){
            DigitalVideoDisc DVD = inputDVDs();
            if (i >= Cart.MAX_NUMBERS_ORERED) anOrder.remove();
            anOrder.addDigitalVideoDisc(DVD);
        }
        System.out.println("Total cost is: " + anOrder.totalCost());
    }
}