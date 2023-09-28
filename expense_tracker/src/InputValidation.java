/**
 * This class performs input validation for a given amount and category.
 */
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * InputValidation class to validate the input given by the user
 */
public class InputValidation {

    /**
     * Validates the input amount and category.
     *
     * @param amount   The amount to be validated.
     * @param category The category to be validated.
     * @throws IllegalArgumentException If the amount or category is invalid.
     */
    public void intake_verify(double amount, String category) {
        /**
         * Checks if the amount is within the valid range (0.0 to 1000.0).
         */
        if (amount < 0.0 || amount > 1000.0) {
            JOptionPane.showMessageDialog((Component) null, "Error ! The amount should be greater than 0 and less than 1000");
            throw new IllegalArgumentException("Error! The amount should be greater than 0 and less than 1000");
        } else {
            List<String> valid_list_of_items = Arrays.asList("food", "travel", "bills", "entertainment", "other");
            /**
             * Checks if the category is one of the valid options.
             */
            if (!valid_list_of_items.contains(category)) {
                JOptionPane.showMessageDialog((Component) null, "Error! The category must be from this list \"food\", \"travel\", \"bills\", \"entertainment\",\"other\"");
                throw new IllegalArgumentException("Error! The category must be from this list \"food\",\"travel\", \"bills\", \"entertainment\", and \"other\"");
            }
        }
    }
}
