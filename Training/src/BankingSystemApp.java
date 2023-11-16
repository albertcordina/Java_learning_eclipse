import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Account {
	private int accountNumber;
	private String accountHolder;
	private double balance;
	private String accountType;

	public Account(int accountNumber, String accountHolder, double balance, String accountType) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposit successful. New balance: $" + balance);
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful. New balance: $" + balance);
		} else {
			System.out.println("Insufficient funds!");
		}
	}

	public void transfer(Account destinationAccount, double amount) {
		if (amount <= balance) {
			balance -= amount;
			destinationAccount.deposit(amount);
			System.out.println("Transfer successful. New balance: $" + balance);
		} else {
			System.out.println("Insufficient funds for transfer!");
		}

	}

	@Override
	public String toString() {
		return "Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: $" + balance + ", Type: "
				+ accountType;
	}
}

class Bank {
	private List<Account> accounts;
	private int nextAccountNumber;

	public Bank() {
		this.accounts = new ArrayList<>();
		this.nextAccountNumber = 1;
	}

	public void openAccount(String accountHolder, double initialBalance, String accountType) {
		Account newAccount = new Account(nextAccountNumber++, accountHolder, initialBalance, accountType);
		accounts.add(newAccount);
		System.out.println("Account opened successfully. Account number: " + newAccount.getAccountNumber());
	}

	/*
	 * public void displayAccounts() { System.out.println("Accounts in the Bank:");
	 * for (Account account : accounts) { System.out.println("Account Number: " +
	 * account.getAccountNumber() + " - Holder: " + account.getAccountHolder() +
	 * " - Balance: $" + account.getBalance() + " - Type: " +
	 * account.getAccountType());
	 */
	public void displayAccounts() {
		System.out.println("Accounts in the Bank:");
		accounts.forEach(account -> System.out
				.println("Account Number: " + account.getAccountNumber() + " - Holder: " + account.getAccountHolder()
						+ " - Balance: $" + account.getBalance() + " - Type: " + account.getAccountType()));
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public Optional<Account> findAccountByNumber(int accountNumber) {
		return accounts.stream().filter(account -> account.getAccountNumber() == accountNumber).findFirst();
	}

	public void removeAccount(int accountNumberToRemove) {
		accounts.removeIf(account -> account.getAccountNumber() == accountNumberToRemove);

	}
}

public class BankingSystemApp {
	private static String choice;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Bank bank = new Bank();
		do {
			displayMenu();
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				openAccount(bank);
				break;
			case "2":
				bank.displayAccounts();
				break;
			case "3":
				performTransaction(scanner, bank, "deposit");
				break;
			case "4":
				performTransaction(scanner, bank, "withdraw");
				break;
			case "5":
				performTransfer(scanner, bank);
				break;
			case "6":
				findAccount(scanner, bank);
				break;
			case "7":
				removeAccount(scanner, bank);
				break;
			case "0":
				System.out.println("Exiting the Banking System. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (!choice.equals("0"));
		scanner.close();
	}

	private static void displayMenu() {
		/*
		 * System.out.println("\nBanking System Menu:");
		 * System.out.println("1. Open Account");
		 * System.out.println("2. Display Accounts"); System.out.println("3. Deposit");
		 * System.out.println("4. Withdraw"); System.out.println("5. Transfer");
		 * System.out.println("6. Find Account");
		 * System.out.println("7. Remove Account"); System.out.println("0. Exit");
		 */
		System.out.print("\nBanking System Menu:\n1. Open Account\n2. Display Accounts"
				+ "\n3. Deposit\n4. Withdraw\n5. Transfer\n6. Find Account\n7. Remove Account\n0. Exit\nEnter a positive valid option: ");
	}

	private static void openAccount(Bank bank) {
		System.out.print("Enter account holder name: ");
		String accountHolder = scanner.nextLine();
		System.out.print("Enter initial balance $. ");
		// double initialBalance = scanner.nextDouble();
		// scanner.nextLine();
		double initialBalance = getNumberForDouble();
		System.out.print("Enter account type (Savings/Checking): ");
		String accountType = scanner.nextLine().toUpperCase();
		bank.openAccount(accountHolder, initialBalance, accountType);
	}

	private static void performTransaction(Scanner scanner, Bank bank, String transactionType) {
		
		System.out.print("Enter account number. ");
		// int accountNumber = scanner.nextInt();
		int accountNumber = getNumber();
		
		System.out.print("Enter amount $. ");
		// double amount = scanner.nextDouble();
		// scanner.nextLine(); // Consume newline
		double amount = getNumberForDouble();
		
		Optional<Account> account = bank.findAccountByNumber(accountNumber);
		account.ifPresentOrElse(acc -> {
			switch (transactionType) {
			case "deposit":
				acc.deposit(amount);
				break;
			case "withdraw":
				acc.withdraw(amount);
				break;
			}
		}, () -> System.out.println("Account not found!"));
	}

	private static void performTransfer(Scanner scanner, Bank bank) {
		
		System.out.print("Enter source account number. ");
		int sourceAccountNumber = getNumber();
		
		System.out.print("Enter destination account number. ");
		int destinationAccountNumber = getNumber();
		
		System.out.print("Enter transfer amount in $. ");
		// double transferAmount = scanner.nextDouble();
		// scanner.nextLine(); // Consume newline
		double transferAmount = getNumberForDouble();
		
		Optional<Account> sourceAccount = bank.findAccountByNumber(sourceAccountNumber);
		Optional<Account> destinationAccount = bank.findAccountByNumber(destinationAccountNumber);
		if (sourceAccount.isPresent() && destinationAccount.isPresent()) {
			sourceAccount.get().transfer(destinationAccount.get(), transferAmount);
		} else {
			System.out.println("One or both accounts not found!");
		}
	}

	private static void findAccount(Scanner scanner, Bank bank) {
		
		System.out.print("Enter account number to find. ");
		// int accountNumberToFind = scanner.nextInt();
		// scanner.nextLine(); // Consume newline
		int accountNumberToFind = getNumber();
		Optional<Account> foundAccount = bank.findAccountByNumber(accountNumberToFind);
		foundAccount.ifPresentOrElse(account -> System.out.println("Account found:\n" + account),
				() -> System.out.println("Account not found!"));
	}

	private static void removeAccount(Scanner scanner, Bank bank) {
		System.out.print("Enter account number to remove. ");
		// int accountNumberToRemove = scanner.nextInt();
		// scanner.nextLine(); // Consume newline
		int accountNumberToRemove = getNumber();
		
		Optional<Account> removedAccount = bank.findAccountByNumber(accountNumberToRemove);
		
		removedAccount.ifPresentOrElse(account -> {
			bank.removeAccount(accountNumberToRemove);
			System.out.println("Account removed:\n" + account);
		}, () -> System.out.println("Account not found!"));
	}

	private static int getNumber() {
		int number = 0;
		boolean validInput = false;

		do {
			try {
				System.out.print("Enter here: ");
				number = scanner.nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume newline
			}
		} while (!validInput);

		return number;
	}

	private static double getNumberForDouble() {
		double number = 0;
		boolean validInput = false;

		do {
			try {
				System.out.print("Enter here: ");
				number = scanner.nextDouble();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume newline
			}
		} while (!validInput);

		return number;
	}
}