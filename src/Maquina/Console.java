package Maquina;

import java.util.Scanner;

public class Console {
	private static Scanner readerInt = new Scanner(System.in);
	private static Scanner readerString = new Scanner(System.in);
	private static Scanner readerFloat = new Scanner(System.in);

	public static int readNumber(String message) {
		System.out.println(message);
		return Integer.parseInt(readerInt.nextLine());
	}

	public static String readText(String message) {
		System.out.println(message);
		return readerString.nextLine();
	}
	
	public static int readFloat(String message) {
		System.out.println(message);
		return Integer.parseInt(readerFloat.nextLine());
	}

	public static int readNumber() {
		return Integer.parseInt(readerInt.nextLine());
	}
	
	public static Float readFloat() {
		return Float.parseFloat(readerFloat.nextLine());
	}

	public static String readText() {
		return readerString.nextLine();
	}
}
