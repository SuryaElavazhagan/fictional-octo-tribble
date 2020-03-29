#include<iostream>
#include<cstring>
#include<vector>

using namespace std;

// Question : https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

int number_of_deletion(string a, string b)
{
    // Array containing values for each alphabets.
    vector<int> frequency(26, 0);
    int len_a = a.size();
    int len_b = b.size();
    int sum = 0;

    /*
        For each character in the array increase its frequency.
        i.e., if the first character in the string is 'b'
        ASCII value of 'b' is 94
        ASCII VALUE OF 'a' is 93

        a[i] = 'b' = 94
        a[i] - 'a' = 1
        then, frequency[1]++ ===>>>> frequency['b']++
    */
    for(int i = 0; i < len_a; i++)
        frequency[a[i] - 'a']++;

    // If the character is already present in the first string, then it is decremented.
    for(int i = 0; i < len_b; i++)
        frequency[b[i] - 'a']--;
    
    // Absolute values of frequency is summed up.
    for(int i = 0; i < 26; i++)
    {
        if(frequency[i] < 0)
            frequency[i] = frequency[i] * -1;
        sum += frequency[i];
    }
    return sum;
}

int main()
{
    string a, b;
    cin>>a>>b;

    cout<<number_of_deletion(a, b)<<endl;
    return 0;
}