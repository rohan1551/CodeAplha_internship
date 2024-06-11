import java.util.Scanner;

public class SimpleBankingApp {

  private double balance;

  public SimpleBankingApp() {
    balance = 0.0;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited: $" + amount);
    } else {
      System.out.println("Invalid amount. Deposit must be greater than zero.");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
      System.out.println("Withdrew: $" + amount);
    } else if (amount > balance) {
      System.out.println("Insufficient funds. Withdrawal amount exceeds balance.");
    } else {
      System.out.println("Invalid amount. Withdrawal must be greater than zero.");
    }
  }

  public void checkBalance() {
    System.out.println("Current Balance: $" + balance);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SimpleBankingApp account = new SimpleBankingApp();

    while (true) {
      System.out.println("\nBanking Menu:");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Check Balance");
      System.out.println("4. Exit");
      System.out.print("Choose an option (1-4): ");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter amount to deposit: ");
          double depositAmount = scanner.nextDouble();
          account.deposit(depositAmount);
          break;
        case 2:
          System.out.print("Enter amount to withdraw: ");
          double withdrawAmount = scanner.nextDouble();
          account.withdraw(withdrawAmount);
          break;
        case 3:
          account.checkBalance();
          break;
        case 4:
          System.out.println("Exiting the program. Thank you for banking with us.");
          scanner.close();
          System.exit(0);
        default:
          System.out.println("Invalid option. Please choose a valid option (1-4).");
      }
    }
  }
}
