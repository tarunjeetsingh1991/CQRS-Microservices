package com.Solid;

interface AccountActions {
    void deposit(double amount);
    void withdraw(double amount);
}

interface AccountInfo {
    void showDetails();
}

interface LoanService {
    void applyLoan(CustomerAccount account, double amount);
}

class CustomerAccount implements AccountActions, AccountInfo {

    private String name;
    private int accountNumber;
    private double balance;
    private int creditScore;

    public CustomerAccount(String name, int accountNumber, double balance, int creditScore) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditScore = creditScore;
    }

    public String getName() { return name; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public int getCreditScore() { return creditScore; }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public void showDetails() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Credit Score: " + creditScore);
        System.out.println("-------------------------");
    }
}

class StandardLoanApproval implements LoanService {

    @Override
    public void applyLoan(CustomerAccount acc, double amount) {

        if (amount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }

        if (acc.getCreditScore() > 700 && amount <= acc.getBalance() * 3) {
            System.out.println("Standard Loan approved for $" + amount + " for account " + acc.getAccountNumber());
        } else {
            System.out.println("Standard Loan denied for $" + amount + " for account " + acc.getAccountNumber());
        }
    }
}

class PremiumLoanApproval implements LoanService {

    @Override
    public void applyLoan(CustomerAccount acc, double amount) {

        if (amount <= 0) {
            System.out.println("Loan amount must be positive.");
            return;
        }

        if (acc.getCreditScore() > 750 && amount <= acc.getBalance() * 5) {
            System.out.println("Premium Loan approved for $" + amount + " for account " + acc.getAccountNumber());
        } else {
            System.out.println("Premium Loan denied for $" + amount + " for account " + acc.getAccountNumber());
        }
    }
}
public class BankingApplication {

    public static void main(String[] args) {

        CustomerAccount acc1 = new CustomerAccount("Tom", 123456, 10000, 720);
        CustomerAccount acc2 = new CustomerAccount("Bob", 777888, 6000, 780);

        LoanService standardLoan = new StandardLoanApproval();
        LoanService premiumLoan = new PremiumLoanApproval();

        acc1.deposit(6000);
        acc1.withdraw(12000);

        standardLoan.applyLoan(acc1, 20000);
        premiumLoan.applyLoan(acc1, 30000);

        acc1.showDetails();
        acc2.showDetails();
    }
}
