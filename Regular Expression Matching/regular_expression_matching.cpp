#include<iostream>
#include<string>

using namespace std;

class Solution {
public:
    bool isMatch(string input, string pattern) {
      int inputLength = input.size();
      int patternLength = pattern.size();
      int iterator = inputLength - 1;
      int patternIterator = patternLength - 1;
      while (iterator > 0) {
          if (pattern[patternIterator] == '*') {
            while (
              (pattern[patternIterator - 1] == '.' || pattern[patternIterator - 1] == input[iterator]) &&
              (iterator > 0)
            ) {
              iterator--;
            }
            patternIterator -= 2;
          } else if(
            pattern[patternIterator] == input[iterator] ||
            pattern[patternIterator] == '.'
          ) {
            patternIterator--;
            iterator--;
          } else {
            return false;
          }
      }

      return true;
    }
};
