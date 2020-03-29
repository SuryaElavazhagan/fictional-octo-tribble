#include<iostream>
#include<vector>

using namespace std;

// Question : https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem

int main()
{
    long long no_of_queries = 0;
    int query_no = 0;
    long long temp = 0;
    int start_index = 0;
    vector<long long> queue;
    vector<long long> result;

    cin>>no_of_queries;

    for(long long i = 0; i < no_of_queries; i++)
    {
        cin>>query_no;
        switch(query_no)
        {
            case 1:
                cin>>temp;
                queue.push_back(temp);
                break;
            case 2:
                start_index++;
                break;
            case 3:
                if(start_index < queue.size())
                    result.push_back(queue[start_index]);
                break;
        }
    }

    for(int i = 0; i < result.size(); i++)
    {
        cout<<result[i]<<endl;
    }
    return 0;
}