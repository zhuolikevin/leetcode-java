/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * Medium (27.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        int carry = 0;
        
        while (curL1 != null || curL2 != null) {
            int num1 = curL1 == null ? 0 : curL1.val;
            int num2 = curL2 == null ? 0 : curL2.val;
            int sum = num1 + num2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            if (curL1 != null) {
                curL1 = curL1.next;
            }
            if (curL2 != null) {
                curL2 = curL2.next;
            }
        }
        
        while (curL1 != null) {
            int sum = curL1.val + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            curL1 = curL1.next;
        }
        while (curL2 != null) {
            int sum = curL2.val + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            curL2 = curL2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        
        return fakeHead.next;
    }
}
