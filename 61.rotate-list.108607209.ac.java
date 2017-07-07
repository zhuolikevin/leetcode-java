/*
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list
 *
 * Medium (24.31%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0'
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = 0;
        ListNode curNode = head;
        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
