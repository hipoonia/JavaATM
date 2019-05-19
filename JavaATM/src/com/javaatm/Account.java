package com.javaatm;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	// name of the account
	private String name;
	
	//the account ID number
	private String uuid;
	
	//the user object that owns this account
	private User holder;
	
	//the list of transactions for this account
	private List<Transaction> transactions;
	
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
	
	public String getSummaryLine() {
		
		//get the account's balance
		double balance = this.getBalance();
		
		//format summary line, depending on the weather the balance is negetive
		
		if(balance >= 0) {
			return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
		} else {
			return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
		}
	}
	
	public double getBalance() {
		double balance = 0;
		
		for (Transaction t : this.transactions) {
			balance += t.getAmount();
		}
		return balance;
	}
	
	

	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n", this.uuid);
		
		for (int t= this.transactions.size()-1; t>=0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
	}
	
	
	public void addTransaction(double amount, String memo)  {
		
		//creating new transaction object and adding it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
	

}





















