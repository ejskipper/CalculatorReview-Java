package training.calculatorreview;

import java.util.Scanner;

public class Main {

    private static Scanner in;

    public static void main(String[] args) {
        printWelcomeMessage();

        in = new Scanner(System.in);

        while (true) {
            performOneCalculation();
        }
    }

    private static void performOneCalculation() {
        String op = askForOperator();
        int[] n = askForNumberArray(op);
        int a = calculateAnswer(op, n);

        System.out.println("The answer is: " + a);
        System.out.println();
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to the calculator!");
        System.out.println("==========================");
    }

    private static String askForOperator() {
        String[] allowedOperators = { "+", "-", "*", "/" };
        System.out.print("Please enter the operator: ");
        String op = in.nextLine();
        return op;
    }

    private static int[] askForNumberArray(String op) {
        System.out.print("How many numbers do you want to " + op + "? ");
        int count = Integer.parseInt(in.nextLine());
        int numbers[] = new int[]{count};

        for(int index = 0; index < count; index++) {
            numbers[index] = addNumber("Please enter number " + (index + 1) + ": ");
        }
        return numbers;
    }

    private static int addNumber(String message) {
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

    private static int calculateAnswer(String op, int[] numbers) {
        // Returns 0 if there aren't any numbers.
        int answer = numbers[0];

        int index = 0;
        for (int number : numbers) {
            if (index == 0)
            {
                // Skip this one.
            }
            else
            {
                if (op == "/")
                    answer = answer / number;
                else if (op == "+")
                    answer = answer + number;
                else if (op == "-")
                    answer = answer - number;
                else
                    System.out.println("Invalid operator");
            }

            index++;
        }
        return answer;
    }
}
