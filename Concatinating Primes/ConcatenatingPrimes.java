import java.util.Scanner;
import java.util.List;
import java.util.*;

public class ConcatenatingPrimes
{
    public static int checkPrime(int num)
        {
            /*
                USUAL PRIME OR NOT ALGORITHM
            */
            int flag = 1;
            for(int i=2;i<=(num/2);i++)
            {
                if( (i!=num) && (num%i == 0) )
                {
                    flag = 0;
                    break;
                }
            }
            if(flag == 0)
                return 0;
            else
                return num;
        }

    public static List<Integer> concate(List<Integer> primes)
        {
            /*
                COMPUTING THE COMBINATIONS OF ALL THE PRIME NUMBERS
                AND ADDING TO THE LIST IF THE COMBINATION IS ALSO 
                A PRIME NUMBER
            */
            List <Integer> prime = new ArrayList<Integer>();
            for(int i = 0; i < primes.size(); i++)
            {
                for(int j = 0; j < primes.size(); j++)
                {
                    String temp = "" + primes.get(i) + primes.get(j);
                    int concat = Integer.parseInt(temp);
                    if(checkPrime(concat) != 0)
                    prime.add(concat);
                }
            }
            return prime;
        }

    public static void main(String args[])
        {
            int n;
            Scanner scanner = new Scanner(System.in);
            /*
                GET INPUT
            */
            System.out.println("Input:");
            n = scanner.nextInt();
            List<Integer> primes = new ArrayList<Integer>();
            /*
                ADDING 2,3 TO PRIME LIST
            */
            primes.add(2);
            primes.add(3);
            /*
                ADDING THE REMAINING PRIMES TO THE LIST
            */
            for(int i = 5;i <= n; i++)
            {
                if(checkPrime(i) != 0)
                primes.add(i);
            }
            primes = concate(primes);
            System.out.print("\nOUTPUT:\n" + primes.size());
            scanner.close();
        }
}