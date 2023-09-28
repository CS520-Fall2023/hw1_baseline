// Import necessary Java Swing libraries
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

/**
 * The ExpenseTrackerView class represents the graphical user interface (GUI) for an expense tracker application.
 * It extends the JFrame class to create a window for managing expenses.
 */
public class ExpenseTrackerView extends JFrame {

  /** Declare instance variables */
  private JTable transactionsTable;
  /** User allow transaction field is declared */
  private JButton addTransactionBtn;
  /** This fields allows the user to add transaction value */
  private JTextField amountField;
  /** This  field has the user amount field to be entered */
  private JTextField categoryField;
  /** This field has the categorie listed */
  private DefaultTableModel model;
  /** This field has the model value */
  private List<Transaction> transactions = new ArrayList<>();

  /** Create an instance of the InputValidation class */
  InputValidation input_valid = new InputValidation();

  /**
   * Getter method for the transactionsTable.
   *
   * @return The JTable representing the list of transactions.
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /**
   * Getter method for the amountField, which returns a double.
   *
   * @return The amount entered in the amount field as a double.
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    } else {
      double amount = Double.parseDouble(amountField.getText());
      return amount;
    }
  }

  /**
   * Setter method for the amountField.
   *
   * @param amountField The JTextField to set as the amount field.
   */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  /**
   * Getter method for the categoryField, which returns a String.
   *
   * @return The text entered in the category field as a String.
   */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /**
   * Setter method for the categoryField.
   *
   * @param categoryField The JTextField to set as the category field.
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /**
   * Getter method for the addTransactionBtn.
   *
   * @return The JButton used to add a transaction.
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  /**
   * Getter method for the DefaultTableModel.
   *
   * @return The DefaultTableModel used for the transactions table.
   */
  public DefaultTableModel getTableModel() {
    return model;
  }

  /**
   * Constructor for ExpenseTrackerView class.
   *
   * @param model The DefaultTableModel used for the transactions table.
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set the title of the JFrame
    setSize(600, 400); // Set the size of the JFrame
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  /**
   * Method to refresh the table with a list of transactions.
   *
   * @param transactions The list of transactions to display in the table.
   */
  public void refreshTable(List<Transaction> transactions) {
      model.setRowCount(0); // Clear the existing table
      int rowNum = model.getRowCount();
      double totalCost = 0;
      for(Transaction t : transactions) {
        totalCost += t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum += 1, t.getAmount(), t.getCategory(), t.getTimestamp()});
      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Update the table UI
      transactionsTable.updateUI();
  }  

  /**
   * Method to refresh the entire view.
   */
  public void refresh() {

    // Get transactions from the model
    List<Transaction> transactions = getTransactions();
  
    // Pass them to the view to refresh the table
    refreshTable(transactions);
  }

  /**
   * Getter method to retrieve the list of transactions.
   *
   * @return The list of transactions stored in the view.
   */
  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  /**
   * Method to add a new transaction to the list and update the table.
   *
   * @param t The Transaction object to add to the list and table.
   */
  public void addTransaction(Transaction t) {
    transactions.add(t); // Add the transaction to the list
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()}); // Add the transaction to the table
    refresh(); // Refresh the view
  }

  // Other view methods can be added here
}
