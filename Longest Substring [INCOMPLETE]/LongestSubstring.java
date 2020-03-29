import java.util.Scanner;
import java.util.List;
import java.util.ArrayList; 

// BRUTE FORCE
// NOT TIME EFFICIENT

public class LongestSubstring
{
    /*
        * This res variable will store all the possible substring with non-repeating characters
    */
    static List<String> res = new ArrayList<String>();
 
    public static void main(String args[])
    {
        /*
            * result will store the output of the program
            * input will store the input string
        */
        int result = 0;
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String:");
        // Getting input
        input = scanner.nextLine();
        /*
            * This temp variable acts as an intermediate variable
            to store all the substring to the res variable
            * The size of temp array is the length of input string
            because the whole input string may be a non-repeating set of
            characters 
            * Eg. input: "abcdefgh"
                  output: "abcdefgh"
            * Thus lengthOf(temp) <= lengthOf(input String) 
        */
        char temp[] = new char[input.length()];
        temp[0] = input.charAt(0);
        storeToList(input, temp);
        flushTemp(temp);
        for(int i = 1; i < input.length() - 1; i++)
            {
                temp[0] = input.charAt(i);
                storeToList(input, temp, i + 1, 0);
                flushTemp(temp);
            }
        result = res.get(0).length();
        /*
            Calculating the largest substring length
        */
        for(String str : res)
        {
         if(str.length() >= result)
             result = str.length();
        }
        System.out.println(result);
        scanner.close();
    }

    /*
        * This storeToList() function stores all the substring with
        non-repeating characters
    */

    public static void storeToList(String input, char temp[], int inputIndex, int tempIndex)
    {
        int flag = 1;
        for(;inputIndex < input.length();)
        {
            if(compareStrings(temp, input.charAt(inputIndex)))
            {
                res.add(String.valueOf(temp).trim());
                flushTemp(temp);
                tempIndex = 0;
                flag = 0;
                return;
            }
            else
            {
                temp[++tempIndex] = input.charAt(inputIndex++);
            }
        }
        if(flag == 1)
            {
                res.add(String.valueOf(temp).trim());
            }
    }

    public static void storeToList(String input, char temp[])
        {
            int inputIndex;
            int tempIndex = 0;
            for(inputIndex = 1;inputIndex < input.length(); inputIndex++)
            {
                if(compareStrings(temp, input.charAt(inputIndex)))
                {
                    res.add(String.valueOf(temp).trim());
                    /*
                        * Since temp array is initialized with the size of input
                        String, the substring with length less than input length
                        will have some empty spaces or null characters.
                        They will be removed by trim() function.
                    */
                    flushTemp(temp);
                    tempIndex = 0;
                    temp[tempIndex] = input.charAt(inputIndex);
                }
                else
                {
                    temp[++tempIndex] = input.charAt(inputIndex);
                }
            }
            res.add(String.valueOf(temp).trim());
        }

        /*
            * compareStrings() function is used to compare all the 
            characters in the temp array with the character in input array
        */
    public static boolean compareStrings(char temp[], char c)
        {
            boolean flag = false;
            for(int i = 0; i < temp.length ; i++)
            {
                if(temp[i] == c)
                {
                    flag = true;
                    break;
                }
            }
            return flag;
        }

        /*
            * This function flush temp inorder to read another substring from 
            the input string
        */

    public static void flushTemp(char temp[])
        {
            for(int i = 0; i < temp.length; i++)
                temp[i] = '\0';
        }
}