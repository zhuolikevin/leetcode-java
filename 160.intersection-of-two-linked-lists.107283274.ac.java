/*
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 * Easy (30.49%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  'No intersection: []\n[]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;
        while (curNodeA != null) {
            countA++;
            curNodeA = curNodeA.next;
        }
        while (curNodeB != null) {
            countB++;
            curNodeB = curNodeB.next;
        }
        
        curNodeA = headA;
        curNodeB = headB;
        while (countA > countB) {
            curNodeA = curNodeA.next;
            countA--;
        }
        while (countB > countA) {
            curNodeB = curNodeB.next;
            countB--;
        }
        
        while (curNodeA != null && curNodeB != null && curNodeA != curNodeB) {
            curNodeA = curNodeA.next;
            curNodeB = curNodeB.next;
        }
        
        return curNodeA != null ? curNodeA : null;
    }
}
