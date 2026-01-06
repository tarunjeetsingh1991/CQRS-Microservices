package demo;

interface AccountActions
{
	void deposit(double amount);
	void withdraw(double amount);
}

interface AccountInfo
{
	void showDetails();
}

class CustomerAccount implements AccountActions, AccountInfo
{
	String name;
	int accountNumber, creditScore;
	double balance;
	

	public CustomerAccount(String name, int accountNumber, int creditScore, double balance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.creditScore = creditScore;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void showDetails() 
	{
		 	System.out.println("Account Holder: " + name);
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Credit Score: " + creditScore);
	        System.out.println("Balance: $" + balance);
	        System.out.println("-------------------------");
	}

	@Override
	public void deposit(double amount) 
	{
		if(amount > 0)
		{
			balance += amount;
			System.out.println("Deposited: $" + amount);
		}
		else
		{
			System.out.println("Invalid amount.");
		}
		
	}

	@Override
	public void withdraw(double amount) 
	{
		if(amount > 0 && amount <= balance)
		{
			balance -= amount;
			System.out.println("Withdrawn: $" + amount);
		}
		else
		{
			System.out.println("Invalid amount or imsufficient balance.");
		}
	}
	
}
public class SolidPrinciples 
{
	public static void main(String[] args) 
	{
		CustomerAccount acc1 = new CustomerAccount("Tarunjeet", 12345999, 792, 12000.48);
		acc1.showDetails();
		
		CustomerAccount acc2 = new CustomerAccount("Gurchintan", 45665496, 684, 42000.24);
		acc2.showDetails();
		
		acc1.deposit(3000);
		acc2.withdraw(7200);
		
		acc1.showDetails();
		acc2.showDetails();
	}

}
