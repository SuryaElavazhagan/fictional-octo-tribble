#include<vector>

using namespace std;

class Solution {
public:
    int calPoints(vector<string>& ops) {
        // Maintaining valid rounds as array
    	vector<int> valid_rounds;
        // Output
    	int total_points = 0;
    	int iterator = 0;
    	int valid_rounds_length = 0;
    	int length = ops.size();
    	
    	for (; iterator < length; iterator++) {
            // If C, there should be atleast one valid round
    		if (iterator > 0 && ops[iterator] == "C") {
				total_points -= valid_rounds.back();
				valid_rounds.pop_back();
			}
            // If D, there should be atleast one valid round
            else if (iterator > 0 && ops[iterator] == "D") {
				valid_rounds.push_back(valid_rounds.back() * 2);
				total_points += valid_rounds.back();
			}
            // If +, there should be atlease two valid rounds
            else if (iterator > 1 && ops[iterator] == "+") {
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