public class InputValidation{
    
    public static boolean isValidAmount(double amount){
        try {
            return amount > 0 && amount < 1000;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isValidCategory(String category) {
        String[] validCategories = {"food", "travel", "bills", "entertainment", "other"};
        for (String input : validCategories) {
            if (category.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

}