import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
//        Object[] options = {"YES", "NO"};
//        int option = JOptionPane.showOptionDialog(null,
//                "Do you want to change the first class ticket?",
//                "Confirm",
//                JOptionPane.YES_NO_OPTION, // Option type (Yes/No only)
//                JOptionPane.QUESTION_MESSAGE, // Message type
//                null, // Icon (null uses default icon)
//                options, // Array of buttons
//                options[0]); // Default button (optional)
        int option = JOptionPane.showConfirmDialog(null, 
                "Do you want to change the first class ticket?", "Confirm", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " + 
                (option == JOptionPane.YES_OPTION?"YES":"NO"));
        System.exit(0);
    }
}
