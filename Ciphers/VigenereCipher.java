package caeser;

import java.util.Scanner;

public class VigenereCipher {
	
	private static String encrypt(String key, String text) {
		int textLength = text.length();
		int keyLength = key.length();
		
		char encryptedText[] = new char[textLength];
		final int ASCII_OF_A = 97;
		
		int keyRow = 0;
		int keyColumn = 0;
		int keyElement = 0;
		
		for(int i = 0, j = 0; i < textLength; i++ , j++) {
			if(j == keyLength) { j = 0; }
			
			keyRow = (int)key.charAt(j) - ASCII_OF_A;
			keyColumn = (int)text.charAt(i) - ASCII_OF_A;
			keyElement = (keyRow + keyColumn) % 26;
			encryptedText[i] = (char)(keyElement + ASCII_OF_A);
		}
		
		return new String(encryptedText);
	}
	
	private static String decrypt(String key, String text) {
		int textLength = text.length();
		int keyLength = key.length();
		
		char decryptedText[] = new char[textLength];
		final int ASCII_OF_A = 97;
		final int ASCII_OF_Z = 122;
		
		int keyRow = 0;
		int keyColumn = 0;
		int keyElement = 0;
		
		for(int i = 0, j = 0; i < textLength; i++ , j++) {
			if(j == keyLength) { j = 0; }
			
			keyRow = ASCII_OF_Z - (int)key.charAt(j);
			keyColumn = (int)text.charAt(i) - ASCII_OF_A;
			keyElement = ((keyColumn + keyRow) % 26) + 1;
			keyElement = keyElement == 26 ? 0 : keyElement;
			decryptedText[i] = (char)(keyElement + ASCII_OF_A);
		}
		
		return new String(decryptedText);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
	    String userInput = "";
	    String key = "";
	    String encryptedText = "";
	    String decryptedText = "";
	    
	    System.out.println("Enter the text to be encrypted");
	    userInput = scanner.nextLine();
	   
	    System.out.println("Enter the key : ");
	    key = scanner.nextLine();
	    
	    encryptedText = encrypt(key, userInput);
	    System.out.println("Encrypted text : " + encryptedText);
	    decryptedText = decrypt(key, encryptedText);
	    System.out.println("Decrypted text : " + decryptedText);
	    
	    scanner.close();
	}
}
