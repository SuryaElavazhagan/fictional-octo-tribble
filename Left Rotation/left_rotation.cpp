#include <iostream>
#include <vector>

using namespace std;

/*
    Question : https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
*/

/*
    ************Logic*************
    * Copy (n - k) element(s) from the array and transfer it to the resulting array.
    * From that position, continue to transfer the element(s) from input array from first.
*/

vector<int> array_left_rotation(vector<int> a, int n, int k) {
    vector<int> result(n);
    for(int i = n - 1; i >= k; i--)
        result[i - k] = a[i];
    for(int i = 0; i < k; i++)
        result[i + n - k] = a[i];
    return result;
}

int main(){
    int n;
    int k;
    cin >> n >> k;
    vector<int> a(n);
    for(int a_i = 0;a_i < n;a_i++){
        cin >> a[a_i];
    }
    vector<int> output = array_left_rotation(a, n, k);
    for(int i = 0; i < n;i++)
        cout << output[i] << " ";
    cout << endl;
    return 0;
}
