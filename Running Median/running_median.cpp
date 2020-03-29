#include<iostream>
#include<iomanip>
#include<vector>

using namespace std;


int main()
{
    long n = 0;
    cin>>n;
    vector<double> list(n);

    for(long i = 0; i < n; i++)
    {
        cin>>list[i];
    }

    cout<<fixed<<setprecision(1);
    cout<<list[0]<<endl;
    for(long i = 1; i < n; i++)
    {
        
        if((i + 1) % 2 == 0)
            cout<<(list[i / 2] + list[(i / 2) + 1])/2<<endl;
        else
            cout<<list[i / 2]<<endl;
    }
    return 0;
}