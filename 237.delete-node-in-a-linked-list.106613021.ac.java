/*
 * [237] Delete Node in a Linked List
 *
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 *
 * Easy (46.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1]\nnode at index 0 (node.val = 0)'
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
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) node.next = null;
            else node = node.next;
        }
    }
}
