package caeser;

import java.util.Arrays;
import java.util.Scanner;

public class HillCipher extends Utils{
	
	private static int[] matrixMultiplication(int[][] keyMatrix , int[] dataMatrix ,int keyMatrixSize) {
		int[] resultantMatrix = new int[3];
		
		for(int i = 0; i < keyMatrixSize; i++) {
			for(int j = 0; j < 3; j++) {
				resultantMatrix[i] += dataMatrix[j] * keyMatrix[i][j]; 
			}
			resultantMatrix[i] = resultantMatrix[i] % 26;
		}
		
		return resultantMatrix;
	}
	
	
	private static String encrypt(int[] dataNumbers , int[][] keyMatrix , int keyMatrixSize) {
		String encryptedText = "";
		
		for(int i = 0; i < dataNumbers.length; i = i + 3) {
			int[] tempArray = Arrays.copyOfRange(dataNumbers, i, i + 3);
			tempArray = matrixMultiplication(keyMatrix, tempArray, keyMatrixSize);
			encryptedText += new String(translateToChars(tempArray));
		}
		
		return encryptedText;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int matrixSize = 0;
		String data = "";
		String encryptedString = "";
		System.out.println("Enter the text to be encrypted (If the length of the string is not a multiple of 3, pad with x)");
		data = scanner.nextLine();
		System.out.println("Enter the matrix size : ");
		matrixSize = scanner.nextInt();
		
		int translatedMatrix[] = translateToNumbers(data);
		int keyMatrix[][] = new int[matrixSize][matrixSize];
		
		System.out.println("Key matrix : ");
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				keyMatrix[i][j] = scanner.nextInt();
			}
		}
		
		encryptedString = encrypt(translatedMatrix, keyMatrix, matrixSize);
		
		System.out.println("Encrypted text :" + encryptedString);
		scanner.close();
	}

}
