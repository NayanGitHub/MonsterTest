package com.monster.main;

import java.math.BigInteger;
import java.util.*;

public class DecodeEncodeOctal {
	public static void main(String args[]) {

		System.out.print("Enter Octal Number : ");
		try (Scanner scan = new Scanner(System.in);) {
			String octalStr = scan.nextLine();
			String binary = octalToBinary(octalStr);
			// System.out.println("Binary is: "+binary);

			byte[] byteArray = getByteByString(binary);
			if (byteArray != null) {
				System.out.println(Arrays.toString(byteArray));

				System.out.println("Encoding ByteArray to Octal = "
						+ encodeOctal(byteArray));

				System.out.println("Encoding ByteArray to Hexadecimal = "
						+ encodeHexadecimal(byteArray));

				System.out.println("Encoding ByteArray to  Base64= "
						+ encodeBase64(byteArray));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Get encoded Base64 String from byte array
	 * @param byte array representing the Octal number
	 * @return Base64 encoded String
	 */
	public static String encodeBase64(byte[] bArr) {
		byte[] encoded = Base64.getEncoder().encode(bArr);
		return new String(encoded);
	}

	/**
	 * Get encoded Hexadecimal String from byte array
	 * @param byte array representing the Octal number
	 * @return Hexadecimal encoded String
	 */
	public static String encodeHexadecimal(byte[] bArr) {
		BigInteger one;
		one = new BigInteger(bArr);
		String strResult = one.toString(16);
		return strResult;
	}

	/**
	 * Get encoded Octal String from byte array
	 * @param byte array representing the Octal number
	 * @return Octal encoded String
	 */
	public static String encodeOctal(byte[] bArr) {
		BigInteger one;
		one = new BigInteger(bArr);
		String strResult = one.toString(8);
		return strResult;
	}

	/**
	 * Get binary string from a octal string
	 * @param octalString
	 *            the string representing Octal number
	 * @return an String
	 */
	static String octalToBinary(String octnum) {
		long i = 0;

		String binary = "";

		while (i < octnum.length()) {

			char c = octnum.charAt((int) i);
			switch (c) {
			case '0':
				binary += "000";
				break;
			case '1':
				binary += "001";
				break;
			case '2':
				binary += "010";
				break;
			case '3':
				binary += "011";
				break;
			case '4':
				binary += "100";
				break;
			case '5':
				binary += "101";
				break;
			case '6':
				binary += "110";
				break;
			case '7':
				binary += "111";
				break;
			default:
				throw new NumberFormatException("Invalid octal number "
						+ octnum.charAt((int) i));
			}
			i++;
		}
		return binary;
	}

	/**
	 * Get an byte array by binary string
	 * @param binaryString
	 *            the string representing a byte
	 * @return an byte array
	 */
	public static byte[] getByteByString(String binaryString) {
		int splitSize = 8;

		if (binaryString.length() % splitSize == 0) {
			int index = 0;
			int position = 0;

			byte[] resultByteArray = new byte[binaryString.length() / splitSize];
			StringBuilder text = new StringBuilder(binaryString);

			while (index < text.length()) {
				String binaryStringChunk = text.substring(index,
						Math.min(index + splitSize, text.length()));
				Integer byteAsInt = Integer.parseInt(binaryStringChunk, 2);
				resultByteArray[position] = byteAsInt.byteValue();
				index += splitSize;
				position++;
			}
			return resultByteArray;
		} else {
			System.out
					.println("Cannot convert binary string to byte[], because of the input length. '"
							+ binaryString + "' % 8 != 0");
			return null;
		}
	}
}
