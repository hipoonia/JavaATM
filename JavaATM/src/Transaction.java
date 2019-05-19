import java.util.Date;

public class Transaction {
	
	// the amount of this transaction
	private double amount;
	
	// the time and date of this transaction
	private Date timestamp;
	
	// a memo for this transaction
	private String memo;
	
	// the account in which the transaction was performed
	private Account inAccount;
	
	/*
	 * Create a transaction 
	 * @param amount 		the amount transacted
	 * @param inAccount 	the amount the transaction belongs to
	 * */
	public Transaction (double amount, Account inAccount) {
		
		this.amount = amount;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
		
	}
	
	/*
	 * Create a transaction 
	 * @param amount 		the amount transacted
	 * @param inAccount 	the amount the transaction belongs to
	 * @param memo			the memo for the transaction
	 * */
	
	public Transaction (double amount, String memo, Account inAccount) {
		
		// call the two-arg constructor first
		this(amount, inAccount);
		
		//set the memo
		this.memo = memo;
		
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getSummaryLine() {
		
		if (this.amount >= 0) {
			return String.format("%s : $%.02f : %s : %s", this.timestamp.toString(),
					this.amount, this.inAccount, this.memo);
		}
		
		else {
			return String.format("%s : $(%.02f) : %s : %s", this.timestamp.toString(),
					this.amount, this.inAccount, this.memo);
		}
		
	}
	
	

}
































