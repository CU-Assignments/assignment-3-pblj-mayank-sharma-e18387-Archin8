import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ATM {
    private int correctPIN;
    private double balance;

    public ATM(int correctPIN, double balance) {
        this.correctPIN = correctPIN;
        this.balance = balance;
    }

    public void withdraw(int enteredPIN, double amount) throws InvalidPINException, InsufficientBalanceException {
        if (enteredPIN != correctPIN) {
            throw new InvalidPINException("Invalid PIN entered.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1234, 3000);
        
        System.out.print("Enter PIN: ");
        int enteredPIN = scanner.nextInt();
        System.out.print("Withdraw Amount: ");
        double amount = scanner.nextDouble();
        
        try {
            atm.withdraw(enteredPIN, amount);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current Balance: " + atm.getBalance());
        }
        
        scanner.close();
    }
}
