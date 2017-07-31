/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii
 *
 * Medium (30.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5]\n1\n1'
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        
        ListNode tail = prev.next;
        ListNode newHead = prev.next;
        for (int i = 0; i < n - m; i++) {
            if (tail.next == null) {
                break;
            }
            ListNode cur = tail.next;
            ListNode nextIter = cur.next;
            cur.next = newHead;
            tail.next = nextIter;
            newHead = cur;
        }
        prev.next = newHead;
        
        return dummy.next;
    }
}
