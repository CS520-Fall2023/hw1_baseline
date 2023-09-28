import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  /**
   * Main function that been called when we excecute the code
   * @param args default call of arguments
   */
  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel(); // Create a DefaultTableModel instance to manage table data.
    tableModel.addColumn("Serial"); // Add a column named "Serial" to the table model.
    tableModel.addColumn("Amount"); // Add a column named "Amount" to the table model.
    tableModel.addColumn("Category"); // Add a column named "Category" to the table model.
    tableModel.addColumn("Date"); // Add a column named "Date" to the table model.
    
    InputValidation input_valid = new InputValidation(); // Create an InputValidation instance.

    // initiating expense tracker object
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel); // Create an ExpenseTrackerView instance with the table model.

    // Initialize view
    view.setVisible(true); // Set the view to be visible.

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); // Get the transaction amount from the view.
      String category = view.getCategoryField(); // Get the transaction category from the view.

      input_valid.intake_verify(amount, category); // Validate the input data.

      // Create transaction object
      Transaction t = new Transaction(amount, category); // Create a Transaction object with the provided amount and category.

      // Call controller to add transaction
      view.addTransaction(t); // Add the transaction to the view.
    });

  }

}
