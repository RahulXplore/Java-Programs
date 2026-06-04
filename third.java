import java.util.Scanner;

// Custom Exception Class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter withdrawal amount: ");
            double withdrawal = sc.nextDouble();

            if (withdrawal > balance) {
                throw new InsufficientFundsException(
                    "Insufficient funds! Withdrawal amount exceeds balance."
                );
            }

            balance = balance - withdrawal;
            System.out.println("Withdrawal successful.");
            System.out.println("Updated Balance: " + balance);

        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
