/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list
 *
 * Easy (32.48%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) { return true; }
        // Count node numbers
        int count = 0;
        ListNode curNode = head;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        if (count == 1) { return true; }
        
        // Get left head
        ListNode leftHead = head;
        int len = count / 2;
        while (len > 1) {
            leftHead = leftHead.next;
            len--;
        }
        
        // Get right head
        ListNode rightHead = count % 2 == 0 ? leftHead.next : leftHead.next.next;
        leftHead.next = null;
        
        // Reverse left half
        leftHead = reverse(head);
        
        // Go through left and right list
        ListNode left = leftHead;
        ListNode right = rightHead;
        while (left != null && right != null) {
            if (left.val != right.val) { return false; }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head;
        while (head.next != null) {
            ListNode second = head.next;
            head.next = second.next;
            second.next = newHead;
            newHead = second;
        }
        return newHead;
    }
}
