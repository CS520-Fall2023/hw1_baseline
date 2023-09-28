import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The Transaction class represents a financial transaction with an amount, category, and timestamp.
 */
public class Transaction {

  /** declaring a double variable amount */
  private double amount; 
  /** declaring a String variable category */
  private String category;

  /** declaring timestamp as string */ 
  private String timestamp;

  /**
   * Constructs a new Transaction object with the given amount and category.
   *
   * @param amount The amount of the transaction given by the user from the UI.
   * @param category The category of the transaction given by the user from the UI.
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /**
   * Gets the amount of the transaction.
   *
   * @return The amount of the transaction.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Sets the amount of the transaction.
   *
   * @param amount The new amount to set for the transaction.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Gets the category of the transaction.
   *
   * @return The category of the transaction.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category of the transaction.
   *
   * @param category The new category to set for the transaction.
   */
  public void setCategory(String category) {
    this.category = category;
  }
  
  /**
   * Gets the timestamp of the transaction.
   *
   * @return The timestamp of the transaction.
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Generates and returns a timestamp in the format "dd-MM-yyyy HH:mm".
   *
   * @return The generated timestamp.
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}
