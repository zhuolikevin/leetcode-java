/*
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list
 *
 * Easy (45.10%)
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            ListNode newHead = tail.next;
            ListNode next = newHead.next;
            newHead.next = head;
            tail.next = next;
            head = newHead;
        }
        return head;
    }
}
