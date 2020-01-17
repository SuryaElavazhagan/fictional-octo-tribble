#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* root, int k) {
      int length = 0;
      int index = 0;
      int iterator = 0;
      struct ListNode* copy = root;
      struct ListNode* temp;
      vector<struct ListNode*> result(k, NULL);

      while (copy != NULL) {
        length++;
        copy = copy->next;
      }

      copy = root;

      if (length < k) {
        while (copy != NULL) {
          result[index] = copy;
          temp = copy->next;
          copy->next = NULL;
          copy = temp;
          index++;
        }
      } else {
        int parts = floor(length / k);
        int remainder = length - (parts * k);
        while (copy != NULL) {
          if (result[index] == NULL) {
            result[index] = copy;
          }
          iterator++;

          if (iterator == ((index + 1) * parts)) {
            if (remainder > 0) {
              remainder--;
              copy = copy->next;
            }
            temp = copy->next;
            copy->next = NULL;
            copy = temp;
            index++;
            continue;
          }
          copy = copy->next;
        }
      }

      return result;
    }
};
