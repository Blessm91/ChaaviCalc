package com.fredo.chaavicalc;

import java.util.Locale;
import java.util.Scanner;

public class App {

    private static final String LINE = "---------------------------------------------";

    public static void main(String[] args) {
        // Ensure '.' as decimal separator everywhere (e.g., 3.142)
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            double a = 0.0, b = 0.0;
            boolean running = true;

            while (running) {
                printMenu(a, b);
                System.out.print("Enter a command: ");
                String cmd = scanner.nextLine().trim().toLowerCase();

                switch (cmd) {
                    case "a":
                        System.out.print("Enter value for A: ");
                        a = readDouble(scanner);
                        break;

                    case "b":
                        System.out.print("Enter value for B: ");
                        b = readDouble(scanner);
                        break;

                    case "+": // A = A + B
                        a = a + b;
                        System.out.printf("A = %.3f (after A + B)%n", a);
                        pause(scanner);
                        break;

                    case "-": // A = A - B
                        a = a - b;
                        System.out.printf("A = %.3f (after A - B)%n", a);
                        pause(scanner);
                        break;

                    case "*": // A = A * B
                        a = a * b;
                        System.out.printf("A = %.3f (after A * B)%n", a);
                        pause(scanner);
                        break;

                    case "/": // A = A / B with zero check
                        if (b == 0.0) {
                            System.out.println("Error: Division by zero.");
                        } else {
                            a = a / b;
                            System.out.printf("A = %.3f (after A / B)%n", a);
                        }
                        pause(scanner);
                        break;

                    case "c": // Clear both
                        a = 0.0;
                        b = 0.0;
                        System.out.println("Cleared (A = 0.000, B = 0.000).");
                        pause(scanner);
                        break;

                    case "q": // Quit
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid command.");
                        pause(scanner);
                }
            }
            System.out.println("Goodbye!");
        }
    }

    private static void printMenu(double a, double b) {
        System.out.println(LINE);
        System.out.println("Chaavi Calc");
        System.out.println(LINE);
        System.out.printf("A = %.3f\tB = %.3f%n", a, b);
        System.out.println(LINE);
        System.out.println("a   Enter a value for A");
        System.out.println("b   Enter a value for B");
        System.out.println("+   Add (A = A + B)");
        System.out.println("-   Subtract (A = A - B)");
        System.out.println("*   Multiply (A = A * B)");
        System.out.println("/   Divide (A = A / B)");
        System.out.println("c   Clear (A = 0, B = 0)");
        System.out.println("q   Quit");
        System.out.println(LINE);
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    private static void pause(Scanner scanner) {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }
}
