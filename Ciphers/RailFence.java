package caeser;

import java.util.Scanner;

public class RailFence {

	private static String decrypt(String text , int key) {
		int textLength = text.length();
		char decryptedText[] = new char[textLength];
		int incrementValue = 0, index = 0;
		for(int j = 0; j < key; j++) {
			if(j == key - 1) {
				incrementValue = (key - 1) + (key - 2) + 1;
			}else {
				incrementValue = (key - 1 - j) + (key - 2 - j) + 1;
			}
			for(int i = j;i < textLength; i = i + incrementValue) {
				decryptedText[i] = text.charAt(index++);
			}
		}
		return new String(decryptedText);
	}
	
	private static String encrypt(String text , int key) {
		String encryptedText = "";
		int textLength = text.length();
		int incrementValue = 0;
		for(int j = 0; j < key; j++) {
			if(j == key - 1) {
				incrementValue = (key - 1) + (key - 2) + 1;
			}else {
				incrementValue = (key - 1 - j) + (key - 2 - j) + 1;
			}
			for(int i = j;i < textLength; i = i + incrementValue) {
				encryptedText += text.charAt(i);
			}
		}
		
		/*
		 * *****Use this to get the rail-fence matrix******
		 * boolean isGoingDown = true;
		 * char encryptionMatrix[][] = new char[key][textLength];
		 * while(j < textLength) {
			if(i == key) {
				isGoingDown = false;
				i = i - 2;
			}
			if(i == -1) {
				i = 1;
				isGoingDown = true;
			}
			******Filling down*****
			if(isGoingDown) {
				encryptionMatrix[i][j] = text.charAt(j);
				i++;
			}
			*****Filling up*******
			else {
				encryptionMatrix[i][j] = text.charAt(j);
				i--;
			}
			j++;
		}
		for(i = 0; i < key; i++) {
			for(j = 0; j < textLength; j++) {
				if(encryptionMatrix[i][j] != '\0') {
					encryptedText += encryptionMatrix[i][j] + "";
				}
			}
		}*/
		return encryptedText;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int key = 0;
		String text = "";
		String encryptedText = "";
		String decryptedText = "";
		
		System.out.println("Give text : ");
		text = scanner.nextLine();
		System.out.println("Give key : ");
		key = scanner.nextInt();
		
		encryptedText = encrypt(text, key);
		decryptedText = decrypt(encryptedText, key);
		System.out.println("Encrypted String : " + encryptedText);
		System.out.println("Decrypted String : " + decryptedText);
		scanner.close();
	}

}
