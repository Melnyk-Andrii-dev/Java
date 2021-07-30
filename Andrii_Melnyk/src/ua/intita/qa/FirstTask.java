package ua.intita.qa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class FirstTask {

    public static void main(String[] args) {
        int[] numbers = setNumbers();

        String numbersStr = Arrays.toString(numbers);
        System.out.println("YOUR INPUT:");
        System.out.println(numbersStr);

        printEvenOdd(numbers);
        printMinMax(numbers);
        printMultipleOf3and9(numbers);
        printPrime(numbers);
        printSorted(numbers);
        printPolindrome(numbers);
        printShortestLongest(numbers);
        printSortedByLength(numbers);
    }

    public static int[] setNumbers() {
        int numberAmount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of numbers you wish to input (1 - 2kkk):");

        while (true) {

            if (scanner.hasNextInt())
                numberAmount = scanner.nextInt();
            else {
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
                continue;
            }

            if ((numberAmount < 1 || numberAmount > 2_000_000_000)) {
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
            } else {
                break;
            }
        }
        int[] numbers = new int[numberAmount];

        System.out.println("Enter " + numberAmount + " numbers (-2kkk - 2kkk):");

        for (int i = 0; i < numberAmount; i++) {
            if (scanner.hasNextInt()) {
                numbers[i] = scanner.nextInt();
            } else {
                i--;
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
                scanner.nextLine();
            }
            if (numbers[i] < -2_000_000_000 || numbers[i] > 2_000_000_000) {
                i--;
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
            }
        }
        return numbers;
    }


    private static void printEvenOdd(int[] numbers) {
        System.out.println("");
        System.out.print("Evens: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println("");
        System.out.print("Odds: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println("");
    }

    private static void printMinMax(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        System.out.println("");
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.println("Min: " + min + '\n' + "Max: " + max);
    }

    private static void printMultipleOf3and9(int[] numbers) {
        System.out.println("");
        System.out.print("Multiple of 3: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println("");
        System.out.print("Multiple of 9: ");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 9 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println("");
    }

    private static void printPrime(int[] numbers) {
        int candidate;
        boolean isPrime;
        System.out.println("");
        System.out.print("Primes:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 2) {
                candidate = numbers[i];
                isPrime = true;
                for (int j = 2; j <= candidate / 2; j++) {
                    if (candidate % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.print(candidate + " ");
                }
            }
        }
        System.out.println("");
    }

    private static void printSorted(int[] numbers) {

        Arrays.sort(numbers);
        System.out.println("");
        System.out.print("Sorted by increase: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
        System.out.print("Sorted by decrease: ");
        Integer[] integerMas = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integerMas[i] = numbers[i];
        }

        Collections.reverse(Arrays.asList(integerMas));
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(integerMas[i] + " ");
        }
        System.out.println("");
    }

    private static void printPolindrome(int[] numbers) {
        System.out.println("");
        System.out.print("Polindromes: ");
        for (int i = 0; i < numbers.length; i++) {
            String direct = String.valueOf(numbers[i]);
            StringBuilder reverse = new StringBuilder(direct).reverse();
            if (direct.equalsIgnoreCase(reverse.toString())) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println("");
    }

    private static void printShortestLongest(int[] numbers) {

        int shortestLength = String.valueOf(numbers[0]).length();
        int longestLength = String.valueOf(numbers[0]).length();
        int shortestNumber = numbers[0];
        int longestNumber = numbers[0];

        System.out.println("");
        for (int i = 0; i < numbers.length; i++) {
            if (shortestLength > String.valueOf(numbers[i]).length()) {
                shortestLength = String.valueOf(numbers[i]).length();
                shortestNumber = numbers[i];
            }
            if (longestLength < String.valueOf(numbers[i]).length()) {
                longestLength = String.valueOf(numbers[i]).length();
                longestNumber = numbers[i];
            }
        }
        System.out.println("");
        System.out.print("Longest: " + longestNumber + " (length: " + longestLength + " digit(s))");
        System.out.println("");
        System.out.print("Shortest: " + shortestNumber + " (length: " + shortestLength + " digit(s))");
        System.out.println("");
    }

    private static void printSortedByLength(int[] numbers) {

        int shortestLength = String.valueOf(numbers[0]).length();
        int longestLength = String.valueOf(numbers[0]).length();
        int shortestNumber = numbers[0];
        int longestNumber = numbers[0];
        int temp;

        System.out.println("");
        System.out.print("Sorted by length increase: ");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (String.valueOf(numbers[i]).length() > String.valueOf(numbers[j]).length()) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
        System.out.print("Sorted by length decrease: ");
        int j = numbers.length - 1;

        for (int i = 0; i < numbers.length / 2; i++) {
            temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            j--;
            if (j == i) break;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");
    }
}
