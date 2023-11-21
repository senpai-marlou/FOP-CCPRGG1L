
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;

	JComboBox Choices;

	private JTextField textInput;
	private JLabel lblOutputDecimal;
	private JLabel lblDecimal;
	private JLabel lblBinary;
	private JLabel lblHexadecimal;
	private JLabel lblOctal;
	private JLabel lblASCII;
	private JLabel lblOutputBinary;
	private JLabel lblOutputHexa;
	private JLabel lblOutputOctal;
	private JLabel lblOutputASCII;
	private JButton btnConvert;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// -----------------------------------------------------------------------------------------------------

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

	// -----------------------------------------------------------------------------------------------------

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

	// ------------------------------------------------------------------------------------------------------
	/**
	 * Create the frame.
	 */

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 374);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		String[] contents = { "Select...", "Decimal", "Binary", "Hexadecimal", "Octal", "ASCII" };
		contentPane.setLayout(null);

		// -------------------------------------------------------------------------------------------

		JLabel lblTitle = new JLabel("Number Conversion Calculator");
		lblTitle.setBounds(18, 300, 218, 35);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle);

		Choices = new JComboBox<Object>(contents);
		Choices.setBounds(104, 57, 132, 31);
		Choices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(Choices);

		JLabel lblSubTitle1 = new JLabel("Type:");
		lblSubTitle1.setBounds(18, 55, 87, 35);
		lblSubTitle1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSubTitle1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSubTitle1);

		textInput = new JTextField();
		textInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textInput.setBounds(7, 7, 241, 42);
		contentPane.add(textInput);
		textInput.setColumns(10);

		lblOutputDecimal = new JLabel("---");
		lblOutputDecimal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutputDecimal.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputDecimal.setBounds(123, 104, 113, 31);
		contentPane.add(lblOutputDecimal);

		lblDecimal = new JLabel("Decimal:");
		lblDecimal.setHorizontalAlignment(SwingConstants.LEFT);
		lblDecimal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDecimal.setBounds(18, 101, 87, 35);
		contentPane.add(lblDecimal);

		lblBinary = new JLabel("Binary:");
		lblBinary.setHorizontalAlignment(SwingConstants.LEFT);
		lblBinary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBinary.setBounds(18, 132, 87, 35);
		contentPane.add(lblBinary);

		lblHexadecimal = new JLabel("Hexadecimal:");
		lblHexadecimal.setHorizontalAlignment(SwingConstants.LEFT);
		lblHexadecimal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHexadecimal.setBounds(18, 163, 107, 35);
		contentPane.add(lblHexadecimal);

		lblOctal = new JLabel("Octal:");
		lblOctal.setHorizontalAlignment(SwingConstants.LEFT);
		lblOctal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOctal.setBounds(18, 194, 87, 35);
		contentPane.add(lblOctal);

		lblASCII = new JLabel("ASCII:");
		lblASCII.setHorizontalAlignment(SwingConstants.LEFT);
		lblASCII.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblASCII.setBounds(18, 225, 87, 35);
		contentPane.add(lblASCII);

		lblOutputBinary = new JLabel("---");
		lblOutputBinary.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputBinary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutputBinary.setBounds(123, 135, 113, 31);
		contentPane.add(lblOutputBinary);

		lblOutputHexa = new JLabel("---");
		lblOutputHexa.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputHexa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutputHexa.setBounds(123, 166, 113, 31);
		contentPane.add(lblOutputHexa);

		lblOutputOctal = new JLabel("---");
		lblOutputOctal.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputOctal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutputOctal.setBounds(123, 197, 113, 31);
		contentPane.add(lblOutputOctal);

		lblOutputASCII = new JLabel("---");
		lblOutputASCII.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputASCII.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutputASCII.setBounds(123, 228, 113, 31);
		contentPane.add(lblOutputASCII);

		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Choices.getSelectedItem().equals("Decimal")) {

					double input = Double.parseDouble(textInput.getText());

					int number = (int) input;
					String holdDeci = Integer.toString(number);
					String binary = toBinaryString(number);
					binary = recursive(number);

					String hexadecimal = toHexString(number);
					hexadecimal = recursiveDecHex(number);

					int octal = convertDecimalToOctal(number);
					String holdOcta = Integer.toString(octal);

					if (number >= 32) {
						char ch = (char) number;
						String holdChar = Character.toString(ch);

						lblOutputASCII.setText(holdChar);
					} else {
						lblOutputASCII.setText("No Value");
					}

					lblOutputDecimal.setText(holdDeci);
					lblOutputBinary.setText(binary);
					lblOutputHexa.setText(hexadecimal);
					lblOutputOctal.setText(holdOcta);
				} else if (Choices.getSelectedItem().equals("Binary")) {

					double input = Double.parseDouble(textInput.getText());

					int holdB = (int) input;
					String binary2 = Integer.toString(holdB);

					int decimal = toDecimalUsingParseInt(binary2);
					decimal = recursiveBin(binary2);
					String convertD = Integer.toString(decimal);

					String hexadecimal = toHexString(decimal);

					int octal = convertDecimalToOctal(decimal);
					String holdOcta = Integer.toString(octal);

					if (decimal >= 32) {
						char ch = (char) decimal;
						String holdChar = Character.toString(ch);
						lblOutputASCII.setText(holdChar);
					} else {
						lblOutputASCII.setText("No Value");
					}

					lblOutputDecimal.setText(convertD);
					lblOutputBinary.setText(binary2);
					lblOutputHexa.setText(hexadecimal);
					lblOutputOctal.setText(holdOcta);
				} else if (Choices.getSelectedItem().equals("Hexadecimal")) {

					String inputForString = textInput.getText();

					String hex = inputForString;
					int decimal = toHexUsingParseInt(hex);
					decimal = recursiveHexDec(hex);
					String convertD = Integer.toString(decimal);

					String binary = toBinaryString(decimal);
					binary = recursive(decimal);

					int octal = convertDecimalToOctal(decimal);
					String holdOcta = Integer.toString(octal);

					if (decimal >= 32) {
						char ch = (char) decimal;
						String holdChar = Character.toString(ch);
						lblOutputASCII.setText(holdChar);
					} else {
						lblOutputASCII.setText("No Value");
					}

					lblOutputHexa.setText(hex);
					lblOutputDecimal.setText(convertD);
					lblOutputBinary.setText(binary);
					lblOutputOctal.setText(holdOcta);
				} else if (Choices.getSelectedItem().equals("Octal")) {

					double input = Double.parseDouble(textInput.getText());

					int octal = (int) input;
					String holdOcta = Integer.toString(octal);
					long binary = convertOctalToBinary(octal);
					binary = convertOctalToBinary(octal);
					String holdB = String.valueOf(binary);

					int decimal = convertOctalToDecimal(octal);
					String convertD = Integer.toString(decimal);

					String hexadecimal = toHexString(decimal);
					hexadecimal = recursiveDecHex(decimal);

					if (decimal >= 32) {
						char ch = (char) decimal;
						String holdChar = Character.toString(ch);
						lblOutputASCII.setText(holdChar);
					} else {
						lblOutputASCII.setText("No Value");
					}

					lblOutputOctal.setText(holdOcta);
					lblOutputBinary.setText(holdB);
					lblOutputDecimal.setText(convertD);
					lblOutputHexa.setText(hexadecimal);
				} else if (Choices.getSelectedItem().equals("ASCII")) {

					String inputForString = textInput.getText();
					char text = inputForString.charAt(0);
					String hold = Character.toString(text);

					int decimal = text;
					String convertD = Integer.toString(decimal);

					String binary = toBinaryString(decimal);
					binary = recursive(decimal);

					String hexadecimal = toHexString(decimal);
					hexadecimal = recursiveDecHex(decimal);

					int octal = convertDecimalToOctal(decimal);
					String holdOcta = Integer.toString(octal);

					lblOutputASCII.setText(hold);
					lblOutputDecimal.setText(convertD);
					lblOutputBinary.setText(binary);
					lblOutputHexa.setText(hexadecimal);
					lblOutputOctal.setText(holdOcta);
				}

			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConvert.setBounds(19, 266, 98, 33);
		contentPane.add(btnConvert);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textInput.setText(null);
				Choices.setSelectedIndex(0);

				lblOutputDecimal.setText("---");
				lblOutputBinary.setText("---");
				lblOutputHexa.setText("---");
				lblOutputOctal.setText("---");
				lblOutputASCII.setText("---");

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(133, 266, 98, 33);
		contentPane.add(btnReset);
	}

}
