#include<vector>

using namespace std;

class Solution {
public:
    int calPoints(vector<string>& ops) {
    	vector<int> valid_rounds;
    	int total_points = 0;
    	int iterator = 0;
    	int valid_rounds_length = 0;
    	int length = ops.size();
    	
    	for (; iterator < length; iterator++) {
    		if (iterator > 0 && ops[iterator] == "C") {
				total_points -= valid_rounds.back();
				valid_rounds.pop_back();
			} else if (iterator > 0 && ops[iterator] == "D") {
				valid_rounds.push_back(valid_rounds.back() * 2);
				total_points += valid_rounds.back();
			} else if (iterator > 1 && ops[iterator] == "+") {
				valid_rounds_length = valid_rounds.size();
				valid_rounds.push_back(valid_rounds[valid_rounds_length - 1] + valid_rounds[valid_rounds_length - 2]);
				total_points += valid_rounds.back();
			} else {
				valid_rounds.push_back(stoi(ops[iterator]));
    			total_points += valid_rounds.back();
			}
    	}

    	return total_points;
    }
};