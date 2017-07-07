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
        ListNode curNode = dummy;
        for (int i = 0; i < m - 1; i++) {
            curNode = curNode.next;
        }
        
        head = curNode.next;
        ListNode tail = head;
        int count = n - m;
        while (count > 0) {
            ListNode target = tail.next;
            tail.next = target.next;
            target.next = head;
            head = target;
            count--;
        }
        
        curNode.next = head;
        return dummy.next;
    }
}
