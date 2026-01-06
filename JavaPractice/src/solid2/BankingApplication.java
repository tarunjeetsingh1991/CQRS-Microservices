package solid2;

/*
=====================================================
INTERFACES (ISP + DIP)
=====================================================
Each interface has a SINGLE responsibility
and higher-level modules depend on abstractions.
*/

/*
Follows:
✔ Interface Segregation Principle (ISP)
✔ Dependency Inversion Principle (DIP)
Only account-related actions
*/
interface AccountActions {
    void deposit(double amount);
    void withdraw(double amount);
}

/*
Follows:
✔ Interface Segregation Principle (ISP)
Only exposes read-only account info
*/
interface AccountInfo {
    String getAccountSummary();
}

/*
Follows:
✔ Interface Segregation Principle (ISP)
✔ Dependency Inversion Principle (DIP)
Loan services depend on this abstraction,
not on a concrete CustomerAccount class
*/
interface LoanEligibleAccount {
    double getBalance();
    int getCreditScore();
    int getAccountNumber();
}

/*
Follows:
✔ Open/Closed Principle (OCP)
✔ Dependency Inversion Principle (DIP)
New loan types can be added without modifying existing code
*/
interface LoanService {
    void applyLoan(LoanEligibleAccount account, double amount);
}

/*
=====================================================
ENTITY CLASS
=====================================================
*/

/*
Follows:
✔ Single Responsibility Principle (SRP)
✔ Liskov Substitution Principle (LSP)
✔ Dependency Inversion Principle (DIP)

Responsible ONLY for:
- Holding account data
- Deposit & withdraw behavior
Implements multiple small interfaces (ISP)
*/
class CustomerAccount implements AccountActions, AccountInfo, LoanEligibleAccount {

    private final String name;
    private final int accountNumber;
    private double balance;
    private final int creditScore;

    public CustomerAccount(String name, int accountNumber,
                           double balance, int creditScore) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.creditScore = creditScore;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException("Invalid withdrawal");
        balance -= amount;
    }

    @Override
    public String getAccountSummary() {
        return """
                Account Holder : %s
                Account Number : %d
                Balance        : $%.2f
                Credit Score   : %d
                -----------------------------
                """.formatted(name, accountNumber, balance, creditScore);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

/*
=====================================================
LOAN IMPLEMENTATIONS
=====================================================
*/

/*
Follows:
✔ Open/Closed Principle (OCP)
✔ Liskov Substitution Principle (LSP)

Can replace LoanService anywhere without breaking behavior
*/
class StandardLoanApproval implements LoanService {

    @Override
    public void applyLoan(LoanEligibleAccount acc, double amount) {
        validateAmount(amount);

        if (acc.getCreditScore() > 700 &&
                amount <= acc.getBalance() * 3) {
            System.out.println("STANDARD LOAN APPROVED: $" + amount +
                    " | Account: " + acc.getAccountNumber());
        } else {
            System.out.println("STANDARD LOAN DENIED: $" + amount +
                    " | Account: " + acc.getAccountNumber());
        }
    }

    private void validateAmount(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Loan amount must be positive");
    }
}

/*
Follows:
✔ Open/Closed Principle (OCP)
✔ Liskov Substitution Principle (LSP)

New loan rules without modifying existing code
*/
class PremiumLoanApproval implements LoanService {

    @Override
    public void applyLoan(LoanEligibleAccount acc, double amount) {
        validateAmount(amount);

        if (acc.getCreditScore() > 750 &&
                amount <= acc.getBalance() * 5) {
            System.out.println("PREMIUM LOAN APPROVED: $" + amount +
                    " | Account: " + acc.getAccountNumber());
        } else {
            System.out.println("PREMIUM LOAN DENIED: $" + amount +
                    " | Account: " + acc.getAccountNumber());
        }
    }

    private void validateAmount(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Loan amount must be positive");
    }
}

/*
=====================================================
PRESENTATION LAYER
=====================================================
*/

/*
Follows:
✔ Single Responsibility Principle (SRP)
Handles ONLY printing / presentation logic
*/
class AccountPrinter {

    public void print(AccountInfo account) {
        System.out.println(account.getAccountSummary());
    }
}

/*
=====================================================
MAIN APPLICATION
=====================================================
*/

/*
Follows:
✔ Dependency Inversion Principle (DIP)

High-level module depends ONLY on interfaces,
not concrete implementations
*/
public class BankingApplication {

    public static void main(String[] args) {

        LoanService standardLoan = new StandardLoanApproval();
        LoanService premiumLoan = new PremiumLoanApproval();

        AccountPrinter printer = new AccountPrinter();

        CustomerAccount acc1 = new CustomerAccount("Tom", 123456, 10000, 720);
        CustomerAccount acc2 = new CustomerAccount("Bob", 777888, 6000, 780);

        acc1.deposit(6000);
        acc1.withdraw(5000);

        standardLoan.applyLoan(acc1, 20000);
        premiumLoan.applyLoan(acc2, 25000);

        printer.print(acc1);
        printer.print(acc2);
    }
}