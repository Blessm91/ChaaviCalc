package com.fredo.chaavicalc;

import java.util.Locale;
import java.util.Scanner;

public class App {

    private static final String LINE = "---------------------------------------------";

    public static void main(String[] args) {
        // Ensure '.' as decimal separator everywhere (e.g., 3.142)
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            float a = 0.0f, b = 0.0f;
            boolean running = true;

            while (running) {
                printMenu(a, b);
                System.out.print("Enter a command: ");
                String cmd = scanner.nextLine().trim().toLowerCase();

                switch (cmd) {
                    case "a":
                        System.out.print("Enter value for A: ");
                        a = readFloat(scanner);
                        break;

                    case "b":
                        System.out.print("Enter value for B: ");
                        b = readFloat(scanner);
                        break;

                    case "+": // A = A + B
                        a = a + b;
                        System.out.printf("A = %.3f (after A + B)%n", (double) a);
                        pause(scanner);
                        break;

                    case "-": // A = A - B
                        a = a - b;
                        System.out.printf("A = %.3f (after A - B)%n", (double) a);
                        pause(scanner);
                        break;

                    case "*": // A = A * B
                        a = a * b;
                        System.out.printf("A = %.3f (after A * B)%n", (double) a);
                        pause(scanner);
                        break;

                    case "/": // A = A / B with zero check
                        if (Float.compare(b, 0.0f) == 0) {
                            System.out.println("Error: Division by zero.");
                        } else {
                            a = a / b;
                            System.out.printf("A = %.3f (after A / B)%n", (double) a);
                        }
                        pause(scanner);
                        break;

                    case "=": // Show current values
                        System.out.printf("A = %.3f, B = %.3f%n", (double) a, (double) b);
                        pause(scanner);
                        break;

                    case "c": // Clear both
                        a = 0.0f;
                        b = 0.0f;
                        System.out.println("Cleared (A = 0.000, B = 0.000).");
                        pause(scanner);
                        break;

                    case "q": // Quit
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid command. Valid: a b + - * / = c q");
                        pause(scanner);
                }
            }
            System.out.println("Goodbye!");
        }
    }

    private static void printMenu(float a, float b) {
        System.out.println(LINE);
        System.out.println("Chaavi Calc");
        System.out.println(LINE);
        System.out.printf("A = %.3f\tB = %.3f%n", (double) a, (double) b);
        System.out.println(LINE);
        System.out.println("a   Enter a value for A");
        System.out.println("b   Enter a value for B");
        System.out.println("+   Add (A = A + B)");
        System.out.println("-   Subtract (A = A - B)");
        System.out.println("*   Multiply (A = A * B)");
        System.out.println("/   Divide (A = A / B)");
        System.out.println("=   Show current A and B");
        System.out.println("c   Clear (A = 0, B = 0)");
        System.out.println("q   Quit");
        System.out.println(LINE);
    }

    private static float readFloat(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                float v = Float.parseFloat(input);
                if (!Float.isFinite(v)) {
                    System.out.print("Invalid number (NaN/Infinity). Try again: ");
                    continue;
                }
                return v;
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
