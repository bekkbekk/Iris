import java.util.Scanner;

// superclass
abstract class Button {
	abstract void clicked();
}

// subclass
class LoginButton extends Button {

	ExitButton exitButton = new ExitButton();

	void clicked() {
		Scanner scanner = new Scanner(System.in);
		String username, password;

		System.out.print("Username: ");
		username = scanner.nextLine().trim();
		System.out.print("Password: ");
		password = scanner.nextLine().trim();

		System.out.println("\nLogged in successfully.");

		System.out.println("\nWelcome to Homepage");
		System.out.print("\nPress enter to exit");
		scanner.nextLine();
		exitButton.clicked();

	}

}

// subclass
class RegisterButton extends Button {

	void clicked() {
		Scanner scanner = new Scanner(System.in);
		ExitButton exitButton = new ExitButton();
		String username, password, confirmPassword;
		String firstName, lastName;

		System.out.print("First Name: ");
		firstName = scanner.nextLine().trim();
		System.out.print("Last Name: ");
		lastName = scanner.nextLine().trim();
		System.out.print("Username: ");
		username = scanner.nextLine().trim();

		while (true) {
			System.out.print("Password: ");
			password = scanner.nextLine().trim();
			System.out.print("Confirm Password: ");
			confirmPassword = scanner.nextLine().trim();
			if (password.equals(confirmPassword)) {
				break;
			} else {
				System.out.println("\nPassword does not match.\n");
			}
		}

		System.out.println("\nRegistered successfully.");

		System.out.println("\nWelcome to Homepage");
		System.out.print("\nPress enter to exit");
		scanner.nextLine();
		exitButton.clicked();

	}

}

// subclass
class ExitButton extends Button {

	void clicked() {
		System.out.println("Iris is now closing...");
		System.out.println("Closed.");
		System.exit(0);
	}

}

public class Iris {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String clicked;

		// objects of different subclass of Button Class
		LoginButton loginButton = new LoginButton();
		RegisterButton registerButton = new RegisterButton();
		ExitButton exitButton = new ExitButton();

		while (true) {
			System.out.println("------- Welcome to Iris! -------\n");
			System.out.println("Buttons:");
			System.out.println("\tLOGIN  |  REGISTER  |  EXIT");
			System.out.print("\nButton clicked: ");
			clicked = scanner.nextLine().trim();

			System.out.println(); // new line

			if (clicked.equalsIgnoreCase("LOGIN")) {
				loginButton.clicked();
			} else if (clicked.equalsIgnoreCase("REGISTER")) {
				registerButton.clicked();
			} else if (clicked.equalsIgnoreCase("EXIT")) {
				exitButton.clicked();
			} else {
				System.out.println("Invalid button! Try again.\n");
			}
		}

	}

}
