package Day_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task_1_Java_Console_Calculator {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("____Welcome To Console Calculator____\n");

		while (true) {
			showOperations();
			int choice = getChoice();

			if (choice == 9) {
				System.out.println("\n* Thanks for using the Calculator. GoodBye! *");
				break;
			}
			try {
				switch (choice) {
					case 1 -> add();
					case 2 -> subtract();
					case 3 -> division();
					case 4 -> multiply();
					case 5 -> modulus();
					case 6 -> power();
					case 7 -> squareRoot();
					case 8 -> factorial();
					default -> System.out.println("Invalid Choice ! Please select from 1-9\n");
				}
			}
			catch (ArithmeticException e) {
			    System.err.println("Error: " + e.getMessage());
			}
		}
	}

	private static void factorial() {
		try {
			System.out.print("Enter the Non Negative whole number : ");
			int num = scanner.nextInt();
			if (num < 0) throw new ArithmeticException("factorial of Negative number is not defined!\n");
			int result = 1;
			for (int i = 2; i <= num; i++) {
				result *= i;
			}
			System.out.println("Result : " + result + "\n");
		}
		catch(InputMismatchException e) {
			System.out.println("Oops! That was not a valid number. Try again\n");
			scanner.nextLine();
		}
		
	}

	private static void squareRoot() {
		
		try {
			System.out.print("Enter the Non Negative number : ");
			double num = scanner.nextDouble();
			if (num < 0) throw new ArithmeticException("Square root of Negative number is not allowed!\n");
			System.out.println("Result : " + (Math.sqrt(num)) + "\n");
		}
		catch(InputMismatchException e) {
			System.out.println("Oops! That was not a valid number. Try again\n");
			scanner.nextLine();
		}
	}

	private static void power() {
		try {
			System.out.print("Enter base : ");
			double base = scanner.nextDouble();
			System.out.print("Enter power : ");
			double power = scanner.nextDouble();
			System.out.println("Result : " + (Math.pow(base, power)) + "\n");
		}
		catch(InputMismatchException e) {
			System.out.println("Oops! That was not a valid number. Try again\n");
			scanner.nextLine();
		}
	}

	private static void modulus() {
		double nums[] = getTwoNums();
		if(nums == null) return;
		if (nums[1] == 0) throw new ArithmeticException("Modulus by Zero is Not allowed!\n");
		System.out.println("Result : " + (nums[0] % nums[1]) + "\n");
	}

	private static void division() {
		double nums[] = getTwoNums();
		if(nums == null) return;
		if (nums[1] == 0) throw new ArithmeticException("Division by Zero is Not allowed!\n");
		System.out.println("Result : " + (nums[0] / nums[1]) + "\n");
	}

	private static void multiply() {
		double nums[] = getTwoNums();
		if(nums == null) return;
		System.out.println("Result : " + (nums[0] * nums[1]) + "\n");
	}

	private static void subtract() {
		double nums[] = getTwoNums();
		if(nums == null) return;
		System.out.println("Result : " + (nums[0] - nums[1]) + "\n");
	}

	private static void add() {
		double nums[] = getTwoNums();
		if(nums == null) return;
		System.out.println("Result : " + (nums[0] + nums[1]) + "\n");
	}

	private static double[] getTwoNums() {
		try {
			System.out.print("Enter first number : ");
			double first = scanner.nextDouble();
			System.out.print("Enter second number : ");
			double second = scanner.nextDouble();
			
			return new double[] { first, second };
		}
		catch(InputMismatchException e) {
			System.err.println("Oops! That was not a valid number. Try again\n");
			scanner.nextLine();
			return null;
		}
	}

	private static int getChoice() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			return -1;
		}
	}

	private static void showOperations() {
		System.out.println(" 1. + Addition");
		System.out.println(" 2. - Subtraction");
		System.out.println(" 3. / Division");
		System.out.println(" 4. * Multiplication");
		System.out.println(" 5. % Modulus");
		System.out.println(" 6. ^ Power");
		System.out.println(" 7. √ Square root");
		System.out.println(" 8. ! Factorial");
		System.out.println(" 9. > Exit\n");
		System.out.print("Enter the choice : ");
	}

}
