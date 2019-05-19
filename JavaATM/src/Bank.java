import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
	
	private String name;
	
	private List<User> users;
	
	private List<Account> accounts;
	
	/*
	 * Create a new Bank object with empty lists of users and accounts 
	 * @param	name	the name of the bank
	 * 
	 * */
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
	}
	
	
	/*
	 * Generate a new universally unique ID for a user
	 * @return the uuid
	 * */
	public String getNewUserUUID() {
		
		//inits
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		// continue looping until we get a unique ID
		do {
			
			//generate the number
			uuid ="";
			for (int c=0; c<len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID())==0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
		
	}
	
	
	public String getNewAccountUUID() {
		
		//inits
		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique;
		
		// continue looping until we get a unique ID
		do {
			
			//generate the number
			uuid ="";
			for (int c=0; c<len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			nonUnique = false;
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID())==0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
	
		return uuid;
		
	}
	
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	
	public User addUser(String firstName, String lastName, String pin)  {
		
		// create a new User object and add it to our list
		User newUser= null;
		try {
			newUser = new User(firstName, lastName, pin, this);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR: Unable to create user : " + e.getMessage());
//			
//			System.out.println("--------");
//			
//			//System.out.println(e.getStackTrace());
//			
//			System.out.println("------.----");
//			
//			e.printStackTrace();
//			
			throw new UserCreationException ("Unable to create user");
		}
		this.users.add(newUser);
		
		//create a savings account for the user and add to User and Bank accounts lists
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		
		return newUser;
		
	}
	
	
	/*
	 * Get the User object associated with a particular userID and pin, if they are valid
	 * @param userID		the UUID of the user to log in
	 * @param pin			the pin of the user
	 * @return 				the user object, if the login is successful, or null if its not
	 * */
	public User userLogin(String userID, String pin) {
		
		 // search through list of users
		for (User u : this.users) {
			
			// check user ID is correct
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			} 
		}
		// if we havent found the user or have an incorrect pin
		return null;
		
	}
	
	public String getName() {
		return this.name;
	}
	

}



















