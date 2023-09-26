

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private JTextField MinamountField;
private JTextField MaxamountField;
private  JButton ApplyAmountFilterBtn; 
  private List<Transaction> transactions = new ArrayList<>();
  private String selectedCategory;
   JComboBox<String> categoryFilterComboBox;


  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  public String getCategoryField() {
    return categoryField.getText();
  }
  public String getSelectedCategory() {
    selectedCategory = (String) categoryFilterComboBox.getSelectedItem();
    return selectedCategory;
  }


  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }
 public void setMinAmount(JTextField minAmount) {
this.MinamountField = MinamountField;
}
public void setMaxAmount(JTextField minAmount) {
this.MaxamountField = MaxamountField;
} 
public double getMinAmount() {
double Minamount = Double.parseDouble(MinamountField.getText());
return Minamount;
}
public double getMaxAmount() {
double MaxAmount = Double.parseDouble(MaxamountField.getText());
return MaxAmount;
}


 

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  public JButton getApplyAmountFilterbtn() {
return ApplyAmountFilterBtn;
}


  
  public DefaultTableModel getTableModel() {
    return model;
  }


  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");
    categoryFilterComboBox  = new JComboBox<>(new String[]{"All", "Food", "Travel", "Bills", "Entertainment", "Other"});

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
   
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    JLabel AmountMinLabel = new JLabel("AmountMin:");
    MinamountField = new JTextField(10);
    JLabel AmountMaxLabel = new JLabel("AmountMax:");
    MaxamountField = new JTextField(10);
    ApplyAmountFilterBtn = new JButton("Amount Filter Button ");

    

    
    transactionsTable = new JTable(model); 

  

  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(AmountMinLabel);
    inputPanel.add(MinamountField);
    inputPanel.add(AmountMaxLabel);
    inputPanel.add(MaxamountField);
    inputPanel.add(ApplyAmountFilterBtn);

    
    inputPanel.add(new JLabel("Filter by Category:"));
    inputPanel.add(categoryFilterComboBox);
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

  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }

   public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void applyCategoryFilter(String selectedCategory) {
    // Filter transactions based on the selected category
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction t : transactions) {
        if (t.getCategory().equalsIgnoreCase(selectedCategory)) {
            filteredTransactions.add(t);
        }
    }
    // Update the table to display the filtered transactions
    refreshTable(filteredTransactions);
}
public void applyAmountFilter(double minAmount, double maxAmount) {
    // Filter transactions based on the specified amount range
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction t : transactions) {
        double amount = t.getAmount();
        if (amount >= minAmount && amount <= maxAmount) {
            filteredTransactions.add(t);
        }
    }
    // Update the table to display the filtered transactions
    refreshTable(filteredTransactions);
}

  


  // Other view methods
}