package caeser;

import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher extends Utils{
	/*
	    Encrypts using caeser cipher
	*/
	private static int[] encrypt(int[] data , int key){
	    for(int i = 0; i < data.length; i++){
	    	data[i] = (data[i] + key) % 26;
	    }
	    return data;
	}
	
	/*
	    Decrypts using caeser cipher
	*/
	private static int[] decrypt(int[] data , int key){
	    for(int i = 0; i < data.length; i++){
	        data[i] = (data[i] - key) % 26;
	    }
	    return data;
	}
	
	public static void main(String args[]){
	    String userInput = "";
	    int key = 0;
	    int[] translatedArray;
	    int[] encryptedData , decryptedData;
	    char[] encryptedText , decryptedText;
	    Scanner scanner = new Scanner(System.in);
	   
	    System.out.println("Enter the text to be encrypted");
	    userInput = scanner.nextLine();
	   
	    System.out.println("Enter the key : ");
	    key = scanner.nextInt();
	   
	    translatedArray = translateToNumbers(userInput);
	    encryptedData = encrypt(translatedArray , key);
	    encryptedText = translateToChars(encryptedData);
		   
	    System.out.println("**************ENCRYPTION********************");
	    
	    System.out.println("Encrypted Data : " + Arrays.toString(encryptedData));
	    System.out.println("Encrypted Text : " + new String(encryptedText));
	    
	    decryptedData = decrypt(encryptedData , key);
	    decryptedText = translateToChars(decryptedData);
	    
	    System.out.println("**************DECRYPTION********************");
	    
	    System.out.println("Decrypted Data : " + Arrays.toString(decryptedData));
	    System.out.println("Decrypted Text : " + new String(decryptedText));
	    scanner.close();
	}
}