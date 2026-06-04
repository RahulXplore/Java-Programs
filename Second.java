import java.util.Scanner;

// Custom Exception Class
class InvalidPasswordException extends Exception {
    InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidation {

    static void validatePassword(String password)
            throws InvalidPasswordException {

        if (password.length() < 8) {
            throw new InvalidPasswordException(
                "Password must be at least 8 characters long.");
        }

        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit) {
            throw new InvalidPasswordException(
                "Password must contain at least one digit.");
        }

        System.out.println("Password is valid.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
        }

        sc.close();
    }
}
