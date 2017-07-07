/*
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list
 *
 * Medium (43.28%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4,5,6,7,8]'
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode headO = head;
        ListNode headE = head.next;
        ListNode curO = headO;
        ListNode curE = headE;
        while (curE != null && curE.next != null) {
            curO.next = curE.next;
            curO = curO.next;
            curE.next = curO.next;
            curE = curE.next;
        }
        curO.next = headE;
        return headO;
    }
}
