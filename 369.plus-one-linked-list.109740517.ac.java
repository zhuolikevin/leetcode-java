/*
 * [369] Plus One Linked List
 *
 * https://leetcode.com/problems/plus-one-linked-list
 *
 * Medium (54.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
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
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode newHead = reverseList(head);
        ListNode plusedOneHead = helper(newHead);
        return reverseList(plusedOneHead);
    }
    
    private ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        
        ListNode newHead = head;
        ListNode tail = head;
        while (tail.next != null) {
            ListNode temp = tail.next;
            tail.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        
        return newHead;
    }
    
    private ListNode helper(ListNode head) {
        ListNode curNode = head;
        int carry = 1;
        while (curNode.next != null) {
            int sum = curNode.val + carry;
            curNode.val = sum % 10;
            carry = sum / 10;
            curNode = curNode.next;
        }
        int sum = curNode.val + carry;
        curNode.val = sum % 10;
        carry = sum / 10;
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        
        return head;
    }
}
