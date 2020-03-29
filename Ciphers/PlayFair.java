package caeser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayFair {
	
	public static List<List<String>> constructMatrix(String key){
		List<List<String>> constructedMatrix = new ArrayList<List<String>>();
		List<Integer> convertedRow = new ArrayList<Integer>();
		List<String> newRow = new ArrayList<String>();
		int keyIterator = 0;
		int cachedValue = -1;
		boolean isIAndJPresent = false;
		for(int i = 0; i < 26; i++) {
			convertedRow.add(i + 97);
		}

		for(int i = 0; i < key.length(); i++) {
			int value = (int)key.charAt(i);
			if(convertedRow.get(value - 97) == value) {
				convertedRow.set(value - 97, -1);
			}
		}
		
		if(convertedRow.get(8) == 105 && convertedRow.get(9) == 106) {
			isIAndJPresent = true;
		}
		
		Iterator<Integer> rowIterator = convertedRow.iterator();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(key.length() > keyIterator) {
					newRow.add(key.charAt(keyIterator++) + "");
				}
				else {
					cachedValue = rowIterator.next();
					if(cachedValue != -1) {
						if(cachedValue == 105 && isIAndJPresent) {
							newRow.add((char)(int)cachedValue + "/" + (char)(int)rowIterator.next());
						}else {
							newRow.add((char)(int)cachedValue + "");
						}
					}else {
						j--;
					}
				}
			}
		}
		
		for(int i = 0; i < 5; i++) {
			constructedMatrix.add(newRow.subList(i * 5, (i * 5) + 5));
		}
		return constructedMatrix;
	}
	
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String text = "";
        List<List<String>> constructedMatrix = new ArrayList<List<String>>();
        
        System.out.println("Enter the Text");
        text = scanner.nextLine();
       
        System.out.println("Enter the Key");
        key = scanner.nextLine();
        
        constructedMatrix = constructMatrix(key);
        
        scanner.close();
    }
}
