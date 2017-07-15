/*
 * [147] Insertion Sort List
 *
 * https://leetcode.com/problems/insertion-sort-list
 *
 * Medium (32.89%)
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curNode = head;
        while (curNode.next != null) {
            ListNode temp = curNode.next;
            curNode.next = temp.next;
            
            boolean move = false;
            ListNode search = dummy;
            while (search.next != curNode.next && search.next.val < temp.val) {
                search = search.next;
            }
            
            if (search.next == curNode.next) {
                move = true;
            }
            
            ListNode temp2 = search.next;
            search.next = temp;
            temp.next = temp2;
            
            if (move) {
                curNode = curNode.next;
            }
        }
        
        return dummy.next;
    }
}
