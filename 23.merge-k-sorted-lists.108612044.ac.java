/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists
 *
 * Hard (26.97%)
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        
        return mergeK(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeK(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeK(lists, start, mid);
        ListNode right = mergeK(lists, mid + 1, end);
        return merge2(left, right);
    }
    
    private ListNode merge2(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                curNode.next = n1;
                n1 = n1.next;
            } else {
                curNode.next = n2;
                n2 = n2.next;
            }
            curNode = curNode.next;
        }
        
        if (n1 != null) {
            curNode.next = n1;
        }
        if (n2 != null) {
            curNode.next = n2;
        }
        
        return dummy.next;
    }
}
