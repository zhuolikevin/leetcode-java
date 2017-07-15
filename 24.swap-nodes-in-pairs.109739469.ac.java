/*
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs
 *
 * Medium (38.14%)
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curNode = dummy;
        while (curNode != null) {
            ListNode testNode = curNode;
            int count = 0;
            while (testNode != null && count < 2) {
                testNode = testNode.next;
                count++;
            }
            if (testNode == null) {
                return dummy.next;
            } else {
                ListNode temp = curNode.next;
                temp.next = testNode.next;
                curNode.next = testNode;
                testNode.next = temp;
                curNode = temp;
            }
        }
        
        return dummy.next;
    }
}
