/*
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list
 *
 * Medium (28.44%)
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {        
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curNode.next = head1;
                head1 = head1.next;
            } else {
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }
        
        if (head1 != null) {
            curNode.next = head1;
        }
        if (head2 != null) {
            curNode.next = head2;
        }
        
        return dummy.next;
    }
}
