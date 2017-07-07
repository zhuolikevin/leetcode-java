/*
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list
 *
 * Medium (32.42%)
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }
        
        head1.next = dummy2.next;
        head2.next = null;
        
        return dummy1.next;
    }
}
