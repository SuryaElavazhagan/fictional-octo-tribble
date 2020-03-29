import java.util.Scanner;

/*
    QUESTION WILL BE AVAILABLE IN THE BELOW LINK

    https://leetcode.com/problems/two-sum/description/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j = 0;
        int flag = 0;
        int res[] = new int[2];
        for(i = 0; i < nums.length && flag == 0; i++)
        {
            for(j = i+1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    res[0] = i;
                    res[1] = j;
                    flag = 1;
                    break;
                }
            }
        }
        return res;
    }
}
public class TwoSum
{
    public static void main(String args[])
    {
        int n;
        int target;
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the limit:");
        n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        System.out.println("Enter the target:");
        target = scanner.nextInt();
        int res[] = solution.twoSum(nums, target);
        System.out.println("Output:\n" + res[0] + " " + res[1]);
    }
}

/*
    ****************OPTIMUM SOLUTION************************

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
*/