/*
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 *
 * Easy (39.68%)
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode node = head;
        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
}
