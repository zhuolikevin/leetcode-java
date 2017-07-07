/*
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group
 *
 * Hard (30.51%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n1'
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = dummy;
        while (curNode.next != null) {
            int count = 0;
            ListNode testNode = curNode;
            while (count < k && testNode != null) {
                testNode = testNode.next;
                count++;
            }
            if (testNode == null) {
                return dummy.next;
            } else {
                ListNode remain = testNode.next;
                
                head = curNode.next;
                ListNode tail = head;
                while (tail.next != remain) {
                    ListNode target = tail.next;
                    tail.next = target.next;
                    target.next = head;
                    head = target;
                }
                curNode.next = head;
                curNode = tail;
            }
        }
        
        return dummy.next;
    }
}
