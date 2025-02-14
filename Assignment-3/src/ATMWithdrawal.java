import java.util.Scanner;

public class ATMWithdrawalSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 3000;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin != CORRECT_PIN) {
                throw new IllegalArgumentException("Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();
            
            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            
            balance -= withdrawAmount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    }
}
