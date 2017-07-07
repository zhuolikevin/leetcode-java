/*
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list
 *
 * Medium (25.38%)
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = slow.next;
        slow.next = null;
        
        ListNode tail = right;
        while (tail.next != null) {
            ListNode target = tail.next;
            tail.next = target.next;
            target.next = right;
            right = target;
        }
        
        ListNode left = head;
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while (left != null && right != null) {
            curNode.next = left;
            left = left.next;
            curNode = curNode.next;
            curNode.next = right;
            right = right.next;
            curNode = curNode.next;
        }
        
        if (left != null) {
            curNode.next = left;
        }
    }
}
