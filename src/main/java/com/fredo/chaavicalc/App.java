package com.fredo.chaavicalc;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            double a = 0.0, b = 0.0;
            boolean running = true;

            while (running) {
                printMenu(a, b);
                System.out.print("Enter a command: ");
                String cmd = scanner.nextLine().trim();

                switch (cmd.toLowerCase()) {
                    case "a":
                        System.out.print("Enter value for A: ");
                        a = readDouble(scanner);
                        break;

                    case "b":
                        System.out.print("Enter value for B: ");
                        b = readDouble(scanner);
                        break;

                    case "+":
                        System.out.printf("Result: %.3f + %.3f = %.3f%n", a, b, a + b);
                        pause(scanner);
                        break;

                    case "-":
                        System.out.printf("Result: %.3f - %.3f = %.3f%n", a, b, a - b);
                        pause(scanner);
                        break;

                    case "*":
                        System.out.printf("Result: %.3f * %.3f = %.3f%n", a, b, a * b);
                        pause(scanner);
                        break;

                    case "/":
                        if (b == 0.0) {
                            System.out.println("Error: Division by zero.");
                        } else {
                            System.out.printf("Result: %.3f / %.3f = %.3f%n", a, b, a / b);
                        }
                        pause(scanner);
                        break;

                    case "c":
                        a = 0.0;
                        b = 0.0;
                        System.out.println("Cleared.");
                        pause(scanner);
                        break;

                    case "q":
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
        System.out.println("---------------------------------------------");
        System.out.println("Chaavi Calc");
        System.out.println("---------------------------------------------");
        System.out.printf("A = %.3f\tB = %.3f%n", a, b);
        System.out.println("---------------------------------------------");
        System.out.println("a   Enter a value for A");
        System.out.println("b   Enter a value for B");
        System.out.println("+   Add");
        System.out.println("-   Subtract");
        System.out.println("*   Multiply");
        System.out.println("/   Divide");
        System.out.println("C   Clear");
        System.out.println("q   Quit");
        System.out.println("---------------------------------------------");
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
