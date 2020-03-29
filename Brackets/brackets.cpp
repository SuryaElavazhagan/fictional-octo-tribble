#include<iostream>
#include<vector>
#include<cstring>

// Question : https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

using namespace std;

bool checkBrackets(string input)
{
    int size = input.size();
    int top = -1;
    int flag = 0;
    vector<char> stack(size);

    for(int i = 0; i < input.size(); i++)
    {
        switch(input[i])
        {
            case '(' : 
            case '[' :
            case '{' : stack[++top] = input[i];
                       break;
            case ')' : 
                    if(stack[top] == '(')
                        top--;
                    else
                        flag = 1;
                    break;
            case ']' :
                    if(stack[top] == '[')
                        top--;
                    else
                        flag = 1;
                    break;
            case '}' : 
                    if(stack[top] == '{')
                        top--;
                    else
                        flag = 1;
                    break;
        }
        if(flag == 1)
            return false;
    }
    if(top == -1)
        return true;
    return false;
}

int main()
{
    int n = 0;
    cin>>n;

    vector<char> stack;
    vector<string> inputs(n);

    for(int i = 0; i < n; i++)
    {
        cin>>inputs[i];
    }

    for(int i = 0; i < n; i++)
    {
        if(checkBrackets(inputs[i]))
            cout<<"YES"<<endl;
        else
            cout<<"NO"<<endl;
    }
    return 0;
}