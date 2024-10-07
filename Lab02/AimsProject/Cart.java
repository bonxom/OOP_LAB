import javax.swing.*;

public class Cart {
    public static final int MAX_NUMBERS_ORERED = 20;
    private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORERED];
    private int qtyOrder = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        itemOrdered[qtyOrder] = disc;
        qtyOrder++;
        if (qtyOrder < MAX_NUMBERS_ORERED)
            JOptionPane.showMessageDialog(null,
                "The disc has been added");
        else {
            JOptionPane.showMessageDialog(null,
                    "The cast is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){

        int k = 0;
        for (k = 0; k < qtyOrder; k++){
            if (itemOrdered[k] == disc){
                break;
            }
        }
        for (int i = k; i < qtyOrder - 1; i++){
            itemOrdered[i] = itemOrdered[i + 1];
        }
        itemOrdered[qtyOrder - 1] = null;
        qtyOrder--;
    }

    public float totalCost(){
        float res = 0;
        for (int i = 0; i < qtyOrder; i++){
            res += itemOrdered[i].getCost();
        }
        JOptionPane.showMessageDialog(null, "Total cost: " + res);
        return res;
    }

    public void remove(){
        int option = JOptionPane.showConfirmDialog(null, "Remove a DVD?",
                "Full cart", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.NO_OPTION) System.exit(0);
        else{
            boolean invalid = true;
            while (invalid) {
                String removDisc = JOptionPane.showInputDialog(null, "Input DVD's name to remove");
                for (int i = 0; i < qtyOrder; i++) {
                    if (removDisc.equals(itemOrdered[i].getTilte())) {
                        removeDigitalVideoDisc(itemOrdered[i]);
                        invalid = false;
                    }
                }
                if (invalid){
                    int option1 = JOptionPane.showConfirmDialog(null, "Not existed DVD, Retry?", "Error", JOptionPane.YES_NO_OPTION);
                    if (option1 == JOptionPane.NO_OPTION) System.exit(0);
                }
            }

        }
    }

}
