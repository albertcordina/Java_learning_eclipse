package abstract_class;

abstract class BankAccount {

	String accountNumber;
	String accountHolder;
	double balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void displayAccountInfo();
}

class SavingsAccount extends BankAccount {

	double interestRate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited $" + amount + " into Savings Account.");
	}

	@Override
	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Withdrawn $" + amount + " from Savings Account.");
		} else {
			System.out.println("Insufficient balance for withdrawal.");
		}
	}

	@Override
	public void displayAccountInfo() {
		System.out.println("The info: \n\nThe account number: " + accountNumber + "\nThe account holder: "
				+ accountHolder + "\nThe balance: " + balance + "\nInterest Rate: " + interestRate + "%");
	}

}

class CheckingAccount extends BankAccount {

	double overdraftLimit;

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited $" + amount + " into Savings Account.");
	}

	@Override
	public void withdraw(double amount) {
		if (balance + overdraftLimit >= amount) {
			balance -= amount;
			System.out.println("Withdrawn $" + amount + " from Checking Account.");
		} else {
			System.out.println("Insufficient balance for withdrawal.");
		}
	}

	@Override
	public void displayAccountInfo() {
		System.out.println("\n\nThe info: \n\nThe account number: " + accountNumber + "\nThe account holder: "
				+ accountHolder + "\nThe balance: " + balance + "\nOverdraft Limit: $" + overdraftLimit);
	}

}

public class Abstract_override2 {
	public static void main(String[] args) {

		SavingsAccount save = new SavingsAccount();
		CheckingAccount check = new CheckingAccount();

		save.setAccountNumber("12211");
		save.setAccountHolder("John");
		save.setBalance(1000.00);
		save.setInterestRate(1.5);
		save.displayAccountInfo();
		save.deposit(200);
		save.withdraw(20);

		check.setAccountNumber("22562");
		check.setAccountHolder("Marta");
		check.setBalance(2000.00);
		check.setOverdraftLimit(200);
		check.displayAccountInfo();
		check.deposit(300);
		check.withdraw(3000);

	}
}
