
import java.util.Scanner;

public class NumberConversionSystem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Number Conversion Systems \n");

		// Display the menu
		System.out.println("[1] Decimal to All");
		System.out.println("[2] Binary to All");
		System.out.println("[3] Hexadecimal to All");
		System.out.println("[4] Octal to All");
		System.out.println("[5] Char(ASCII) to All");
		System.out.println("");
		System.out.print("Your choice? ");

		// Get user's choice
		int choice = -1;
		while (choice < 0) {
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter Decimal Number: ");
				break;
			case 2:
				System.out.print("Enter Binary: ");
				break;
			case 3:
				System.out.print("Enter Hexadecimal: ");
				break;
			case 4:
				System.out.print("Enter Octal: ");
				break;
			case 5:
				System.out.print("Enter Any Character: ");
				break;
			default:
				System.out.println("Invalid choice. Please choose a number between 1 and 5.");
				choice = scan.nextInt();
				break;
			}
		}

		if (choice == 1) {

			int number = scan.nextInt();
			String binary = toBinaryString(number);
			binary = recursive(number);
			System.out.println("");
			System.out.printf("Decimal to Binary (%d) = %s", number, binary);
			System.out.println("");

			String hexadecimal = toHexString(number);
			hexadecimal = recursiveDecHex(number);
			System.out.printf("Decimal to Hexadecimal (%d) = %s ", number, hexadecimal);
			System.out.println("");

			int octal = convertDecimalToOctal(number);
			System.out.printf("%d in decimal = %d in octal", number, octal);
			System.out.println("");

			if (number >= 32) {
				char ch = (char) number;
				System.out.println(number + " in decimal is = " + ch + " in Char(ASCII)");
			} else {
				System.out.println("No Char(ASCII) Value");
			}
		} else if (choice == 2) {

			String binary2 = scan.next();
			int decimal = toDecimalUsingParseInt(binary2);
			decimal = recursiveBin(binary2);
			System.out.println("");
			System.out.printf("Binary to decimal (%s) = %d ", binary2, decimal);
			System.out.println("");

			String hexadecimal = toHexString(decimal);
			hexadecimal = recursiveDecHex(decimal);
			System.out.printf("Decimal to Hexadecimal (%d) = %s ", decimal, hexadecimal);
			System.out.println("");

			int octal = convertDecimalToOctal(decimal);
			System.out.printf("%d in decimal = %d in octal", decimal, octal);
			System.out.println("");

			if (decimal == 32) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = space" + "(" + ch + ")" + " in ASCII");
			} else if (decimal >= 32 && decimal <= 126) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = " + ch + " in Char(ASCII)");
			} else {
				System.out.println("No Char(ASCII) Value");
			}

		} else if (choice == 3) {

			String hex = scan.next();
			int decimal = toHexUsingParseInt(hex);
			decimal = recursiveHexDec(hex);
			System.out.println("");
			System.out.printf("Hexadecimal to Decimal (%s) = %d ", hex, decimal);
			System.out.println("");

			String binary = toBinaryString(decimal);
			binary = recursive(decimal);
			System.out.printf("Decimal to Binary (%d) = %s", decimal, binary);
			System.out.println("");

			int octal = convertDecimalToOctal(decimal);
			System.out.printf("%d in decimal = %d in octal", decimal, octal);
			System.out.println("");

			if (decimal == 32) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = space" + "(" + ch + ")" + " in ASCII");
			} else if (decimal >= 32 && decimal <= 126) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = " + ch + " in Char(ASCII)");
			} else {
				System.out.println("No Char(ASCII) Value");
			}

		} else if (choice == 4) {

			int octal = scan.nextInt();
			long binary = convertOctalToBinary(octal);
			binary = convertOctalToBinary(octal);
			System.out.println("");
			System.out.printf("%d in octal = %d in binary", octal, binary);
			System.out.println("");

			int decimal = convertOctalToDecimal(octal);
			System.out.printf("%d in octal = %d in decimal", octal, decimal);
			System.out.println("");

			String hexadecimal = toHexString(decimal);
			hexadecimal = recursiveDecHex(decimal);
			System.out.printf("Decimal to Hexadecimal (%d) = %s ", decimal, hexadecimal);
			System.out.println("");

			if (decimal == 32) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = space" + "(" + ch + ")" + " in ASCII");
			} else if (decimal >= 32 && decimal <= 126) {
				char ch = (char) decimal;
				System.out.println(decimal + " in decimal is = " + ch + " in Char(ASCII)");
			} else {
				System.out.println("No Char(ASCII) Value");
			}
		} else {
			char text;
			text = scan.next().charAt(0);

			int decimal = text;
			System.out.println("");
			System.out.println("ASCII value of " + text + " is " + decimal);

			String binary = toBinaryString(decimal);
			binary = recursive(decimal);
			System.out.printf("Decimal to Binary (%d) = %s", decimal, binary);
			System.out.println("");

			String hexadecimal = toHexString(decimal);
			hexadecimal = recursiveDecHex(decimal);
			System.out.printf("Decimal to Hexadecimal (%d) = %s ", decimal, hexadecimal);
			System.out.println("");

			int octal = convertDecimalToOctal(decimal);
			System.out.printf("%d in decimal = %d in octal", decimal, octal);
		}

		scan.close();
	}

// ================================================================================	

	private static String toBinaryString(int number) {
		return Integer.toBinaryString(number);
	}

	private static String toHexString(int number) {
		return Integer.toHexString(number);
	}

	private static int toDecimalUsingParseInt(String binaryNumber) {
		return Integer.parseInt(binaryNumber, 2);
	}

	private static int toHexUsingParseInt(String number) {
		return Integer.parseInt(number, 16);
	}

// ================================================================================	

	private static String recursive(int number) {
		StringBuilder builder = new StringBuilder();

		if (number > 0) {
			String binaryNumber = recursive(number / 2);
			int digit = number % 2;
			builder.append(binaryNumber + digit);
		}
		return builder.toString();
	}

	private static String recursiveDecHex(int number) {
		StringBuilder builder = new StringBuilder();
		if (number > 0) {
			String hexNumber = recursiveDecHex(number / 16);
			String hexCode = "0123456789ABCDEF";
			int hexDigit = number % 16;
			builder.append(hexNumber + hexCode.charAt(hexDigit));
		}
		return builder.toString();
	}

	private static int recursiveBin(String binaryNumber) {
		int decimal = 0;
		int length = binaryNumber.length();
		if (length > 0) {
			String substring = binaryNumber.substring(1);
			int digit = Character.getNumericValue(binaryNumber.charAt(0));
			decimal = digit * (int) Math.pow(2, length - 1) + recursiveBin(substring);
		}
		return decimal;

	}

	private static int recursiveHexDec(String hexNumber) {
		int decimal = 0;
		String hexCode = "0123456789ABCDEF";
		hexNumber = hexNumber.toUpperCase();
		int length = hexNumber.length();
		if (length > 0) {
			char ch = hexNumber.charAt(0);
			int digit = hexCode.indexOf(ch);
			String substring = hexNumber.substring(1);
			decimal = digit * (int) Math.pow(16, length - 1) + recursiveHexDec(substring);
		}
		return decimal;

	}

	public static long convertOctalToBinary(int octalNumber) {
		int decimalNumber = 0, i = 0;
		long binaryNumber = 0;

		while (octalNumber != 0) {
			decimalNumber += (octalNumber % 10) * Math.pow(8, i);
			++i;
			octalNumber /= 10;
		}

		i = 1;

		while (decimalNumber != 0) {
			binaryNumber += (decimalNumber % 2) * i;
			decimalNumber /= 2;
			i *= 10;
		}

		return binaryNumber;
	}

	public static int convertDecimalToOctal(int decimal) {
		int octalNumber = 0, i = 1;

		while (decimal != 0) {
			octalNumber += (decimal % 8) * i;
			decimal /= 8;
			i *= 10;
		}

		return octalNumber;
	}

	public static int convertOctalToDecimal(int octal) {
		int decimalNumber = 0, i = 0;

		while (octal != 0) {
			decimalNumber += (octal % 10) * Math.pow(8, i);
			++i;
			octal /= 10;
		}

		return decimalNumber;
	}

}
