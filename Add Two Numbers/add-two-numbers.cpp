#include<iostream.h>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int remainder = 0;
		struct ListNode *result = new struct ListNode(0);
        struct ListNode *head = result;
		do {
			int firstValue = (l1 == NULL) ? 0 : l1->val;
			int secondValue = (l2 == NULL) ? 0 : l2->val;
			int sum = firstValue + secondValue + remainder;
			remainder = (sum >= 10) ? 1 : 0;
			result->val = (sum % 10);
			
			l1 = (l1 == NULL) ? NULL : l1->next;
			l2 = (l2 == NULL) ? NULL : l2->next;
			
			if (l1 != NULL || l2 != NULL) {
				result->next = new struct ListNode(0);
				result = result->next;
			}
		} while (l1 != NULL || l2 != NULL);
		
		if (remainder > 0) {
			result->next = new struct ListNode(remainder);
			result = result->next;
		}
		
		return head;
    }
};