/*
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii
 *
 * Medium (46.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode nextNode = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int num1 = s1.isEmpty() ? 0 : s1.pop();
            int num2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            ListNode curNode = new ListNode(sum % 10);
            curNode.next = nextNode;
            nextNode = curNode;
        }
        if (carry > 0) {
            ListNode head = new ListNode(carry);
            head.next = nextNode;
            return head;
        } else {
            return nextNode;
        }
    }
}
