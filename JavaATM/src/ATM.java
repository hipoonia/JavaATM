// source youtube link : https://www.youtube.com/watch?v=k0BofouWX-o

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// init Bank
		Bank theBank = new Bank("Bank of Haryana");
		
		// add a user, which also creates a savings accounts
		User aUser = theBank.addUser("Pradeep", "Poonia", "1234");
		
		Account newAccount = new Account("Checking", aUser, theBank);
		aUser.addAccount(newAccount);
		theBank.addAccount(newAccount);

	}

}
