import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      if (!InputValidation.isValidAmount(amount)) {
          view.showMessage("Invalid amount. Amount should be greater than 0 and less than 1000.");
          return;
      }

      if (!InputValidation.isValidCategory(category)) {
           view.showMessage("Invalid category. Please choose from the list: food, travel, bills, entertainment, other.");
          return;
      }

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

        view.categoryFilterComboBox.addActionListener(e -> {
    String selectedCategory = view.getSelectedCategory();
    view.applyCategoryFilter(selectedCategory);
});  


    view.getApplyAmountFilterbtn().addActionListener(e -> {
    double minAmount = view.getMinAmount();
    double maxAmount = view.getMinAmount();
    view.applyAmountFilter(minAmount, maxAmount);
});

  }

}