import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n Calculator ");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic(sc);
                    break;
                case 2:
                    scientificCalculations(sc);
                    break;
                case 3:
                    unitConversions(sc);
                    break;
                case 4:
                    System.out.println("Exiting the calculator. Goodbye!");
                    sc.close(); 
                    break; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice == 4) {
                break; 
            }
        }
    }

    // Basic Arithmetic Operations
    private static void basicArithmetic(Scanner sc) {
        System.out.println("\n--- Basic Arithmetic ---");
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose an operation: +, -, *, /");
        char operation = sc.next().charAt(0);

        try {
            switch (operation) {
                case '+':
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case '/': {
                    if (num2 == 0) throw new ArithmeticException("Division by zero is not allowed.");
                    System.out.println("Result: " + (num1 / num2));
                }
                break;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Scientific Calculations
    private static void scientificCalculations(Scanner scanner) {
        System.out.println("\n--- Scientific Calculations ---");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation (Power)");
        System.out.print("Choose an option (1-2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 :
             {
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                System.out.println("Square Root: " + Math.sqrt(num));
            }
            break;
            case 2 :
             {
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
            }
            break;
            default :
             System.out.println("Invalid choice. Please try again.");
        }
    }

    // Unit Conversions
    private static void unitConversions(Scanner scanner) {
        System.out.println("\n--- Unit Conversions ---");
        System.out.println("1. Temperature (Celsius to Fahrenheit / Fahrenheit to Celsius)");
        System.out.println("2. Currency (USD to EUR / EUR to USD)");
        System.out.print("Choose an option (1-2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 :
             {
                System.out.print("Enter temperature: ");
                double temp = scanner.nextDouble();
                System.out.print("Convert to (1) Celsius or (2) Fahrenheit? ");
                int tempChoice = scanner.nextInt();

                if (tempChoice == 1) {
                    System.out.println("Temperature in Celsius: " + ((temp - 32) * 5 / 9));
                } else if (tempChoice == 2) {
                    System.out.println("Temperature in Fahrenheit: " + ((temp * 9 / 5) + 32));
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            break;
            case 2 :
             {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                System.out.print("Convert to (1) USD or (2) EUR? ");
                int currChoice = scanner.nextInt();
                double conversionRate = 0.85; // Example rate: 1 USD = 0.85 EUR

                if (currChoice == 1) {
                    System.out.println("Amount in USD: " + (amount / conversionRate));
                } else if (currChoice == 2) {
                    System.out.println("Amount in EUR: " + (amount * conversionRate));
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            default :
             System.out.println("Invalid choice. Please try again.");
        }
    }
}
