
import javax.swing.JOptionPane;


public class MonthLength {
    public static boolean isInvalidYear(String year){
        for (int i = 0; i < year.length(); i++){
            if (!Character.isDigit(year.charAt(i))) return true;
        }
        return false;
    }
    
    public static int MonthInNums(String month){
        if (month.contains("Jan") || month.equals("1")) return 1;
        else if (month.contains("Feb") || month.equals("2")) return 2;
        else if (month.contains("Mar") || month.equals("3")) return 3;
        else if (month.contains("Apr") || month.equals("4")) return 4;
        else if (month.contains("May") || month.equals("5")) return 5;
        else if (month.contains("Jun") || month.equals("6")) return 6;
        else if (month.contains("Jul") || month.equals("7")) return 7;
        else if (month.contains("Aug") || month.equals("8")) return 8;
        else if (month.contains("Sep") || month.equals("9")) return 9;
        else if (month.contains("Oct") || month.equals("10")) return 10;
        else if (month.contains("Nov") || month.equals("11")) return 11;
        else return 12;
    }
    
    public static int Days(int month, boolean leapYear){
        switch (month){
                case 1: return 31;
                case 2: int x = leapYear ? 29 : 28; return x;
                case 3: return 31;
                case 4: return 30;
                case 5: return 31;
                case 6: return 30;
                case 7: return 31;
                case 8: return 31;
                case 9: return 30;
                case 10: return 31;
                case 11: return 30;
                case 12: return 31; 
        }
        return 0;
    }
    
    public static int monthCheck(){
        String[] validMonthString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
        "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec.",
        "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"}; 
        String month = JOptionPane.showInputDialog(null, "Input month");
        
        boolean checkMonth = false;
        int Month = 0;
        while (!checkMonth){
            for (String x : validMonthString){
                if (month.equals(x)){
                    checkMonth = true;
                    Month = MonthInNums(month);
                }
            }
            if (!checkMonth){
                int confirm = JOptionPane.showConfirmDialog(null, "Invalid month value!"
                        + "\nDo you want to try again?", "Invalid input", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.NO_OPTION) System.exit(0);
                month = JOptionPane.showInputDialog(null, "Input month");
            }
        }
        return Month;
    }
    
    public static int yearCheck(){
        String year = JOptionPane.showInputDialog(null, "Input year");
        
        while (isInvalidYear(year)){
            int confirm = JOptionPane.showConfirmDialog(null, "Invalid year value!"
                   + "\nDo you want to try again?", "Invalid input", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.NO_OPTION) System.exit(0);
            year = JOptionPane.showInputDialog(null, "Input year");
        }
        return Integer.parseInt(year);
    }
    public static void main(String[] args) {
        int Month = monthCheck();
        int Year = yearCheck();
        boolean leapYear = (Year % 400 == 0 || Year % 4 == 0 && Year % 100 != 0);
        
        int result = Days(Month, leapYear);
        
        JOptionPane.showMessageDialog(null,
                "Number of days: " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
