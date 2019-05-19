
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.*;

public class User  {

	//First name of the user
	private String firstName;

	// last name of the user
	private String lastName;
	
	//the ID number of the user
	private String uuid;
	
	// the MD5 hash of the user's pin
	private byte pinHash[];
	
	//the list of accounts for this user
	private List<Account> accounts;
	
	private static final String PIN_HASH_ALGO = "MD5";

	/** Create a new user	
	*	@param firstName the user's first name
	*	@param lastName the user's last name
	*	@param pin the user's account pin number
	*	@param theBank the bank object that the user is a customer of
	*/
	public User(String firstName, String lastName, String pin, Bank theBank) throws NoSuchAlgorithmException {
		
		//set user's name
		this.firstName = firstName;
		this.lastName = lastName;
		
		// store the pin's MD5 hash, rather than the original value, for security reasons.
//		try {
//			MessageDigest md = MessageDigest.getInstance(PIN_HASH_ALGO);
//			this.pinHash = md.digest(pin.getBytes());
//		} catch (NoSuchAlgorithmException e) {
//			System.out.println("error, caught NoSuchAlgorithmException");
//			e.printStackTrace();
//			System.exit(1);
//		}
		MessageDigest md = MessageDigest.getInstance(PIN_HASH_ALGO);
		this.pinHash = md.digest(pin.getBytes());
		// get a new, unique universal ID for the user
		this.uuid = theBank.getNewUserUUID();
		
		// create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		//print log message
		System.out.printf("New User %s, %s with ID %s created.\n ", lastName, firstName, this.uuid);
	}
	/*
	 * Add an account for the user
	 * @param anAcct		the account to add
	 * */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public String getUUID() {
		return this.uuid;
	}
	
	public boolean validatePin(String aPin) {
		
		try {
			MessageDigest md = MessageDigest.getInstance(PIN_HASH_ALGO);
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		return false;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void printAccountSummary() {
		System.out.printf("\nIn %s's accounts summary\n", this.firstName);
		
		for (int a=0; a<this.accounts.size(); a++) {
			System.out.printf("%d) %s\n",a+1, this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
	}
	
	public int numAccounts() {
		return this.accounts.size();
	}
	
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	
	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
	
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
	
	
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
}























