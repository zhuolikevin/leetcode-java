/*
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle
 *
 * Easy (35.39%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\nno cycle'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) { return false; }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}
