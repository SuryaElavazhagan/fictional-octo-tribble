#include<iostream>
#include<unordered_map>
#include<vector>
#include<string>

// Question : https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem

using namespace std;

int main()
{
    int len_a = 0, len_b = 0, flag = 0;

    unordered_map<string, int> note;

    //cout<<note.at("Hey")<<endl;
    cin>>len_a>>len_b;

    vector<string> input_one(len_a);
    vector<string> input_two(len_b);

    for(int i = 0; i < len_a; i++)
    {
        cin>>input_one[i];
        if(note.find(input_one[i]) == note.end())
        {
            pair<string, int> temp(input_one[i], 1);
            note.insert(temp);
        }
        else
        {
            note.at(input_one[i]) += 1;
        }
    }

    for(int i = 0; i < len_b; i++)
    {
        cin>>input_two[i];
        
        // Check whether the string is present in the magazine

        if(note.find(input_two[i]) == note.end())
        {
            flag = 1;
            break;
        }
        else if(note.at(input_two[i]) == 0)
        {
            /*
                * Checks whether the string in the magazine is already been used.
                * This condition is not merged with the above if condition, because =>
                    * If it were merged it would look like,
                        if(note.find(input_two[i]) == note.end() || note.at(input_two[i]) == 0)
                        So it checks both the conditions. (Consider input_two[i] = "Hat")
                        If at any point, note is empty i.e., newly created (or) There is no "Hat",
                        note.at("Hat") function searches and produces index out of bound exception.
                        To avoid this error, the if condition is separated.
            */
            flag = 1;
            break;
        }
        else
        {
            note.at(input_two[i]) -= 1;
        }
    }

    if(flag == 1)
        cout<<"No"<<endl;
    else
        cout<<"Yes"<<endl;
    return 0;
}