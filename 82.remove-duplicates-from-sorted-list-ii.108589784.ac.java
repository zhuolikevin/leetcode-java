/*
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 *
 * Medium (29.30%)
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
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode lastNode = dummyNode;
        
        while (lastNode != null && lastNode.next != null) {
            ListNode curNode = lastNode.next;
            int count = 1;
            while (curNode.next != null && curNode.val == curNode.next.val) {
                count++;
                curNode = curNode.next;
            }
            if (count > 1) {
                lastNode.next = curNode.next; 
            } else {
                lastNode = curNode;
            }
        }
        
        return dummyNode.next;
    }
}
