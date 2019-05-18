
import java.util.ArrayList;

public class Account {
	
	// name of the account
	private String name;
	
	//the account ID number
	private String uuid;
	
	//the user object that owns this account
	private User holder;
	
	//the list of transactions for this account
	private ArrayList<Transaction> transactions;
	
	/*
	 * Create a new Account
	 * @param name 			the name of the account
	 * @param holder 		the User object that holds this account
	 * @param theBank 		the bank that issues the account
	 * */
	public Account (String name, User holder, Bank theBank) {
		
		//set the account name and holder
		this.name = name;
		this.holder = holder;
		
		// get new account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		// init transactions
		this.transactions = new ArrayList<Transaction>();
		
		// add to holder and bank lists
//		holder.addAccount(this);
//		theBank.addAccount(this);
	}
	
	public String getUUID() {
		
		return this.uuid;
		
	}

}
