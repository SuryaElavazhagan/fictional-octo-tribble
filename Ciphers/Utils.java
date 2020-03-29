package caeser;

public class Utils {
	/*
		Translates characters to numbers
		a:0, b:1 , ......, z:25
	*/
	protected static int[] translateToNumbers(String data){
	    int[] translatedArray = new int[data.length()];
	   
	    for(int i = 0; i < data.length(); i++){
	        translatedArray[i] = ((int) data.charAt(i)) - 97;
	    }
	   
	    return translatedArray;
	}
	/*
	    Translates numbers to characters
	    0:a, 1:b , ......
	*/   
	protected static char[] translateToChars(int[] data){
	    char[] translatedArray = new char[data.length];
	   
	    for(int i = 0; i < data.length; i++){
	        translatedArray[i] = (char) (data[i] + 97);
	    }       
	   
	    return translatedArray;
	}
}
