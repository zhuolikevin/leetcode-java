/*
 * [382] Linked List Random Node
 *
 * https://leetcode.com/problems/linked-list-random-node
 *
 * Medium (46.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Solution","getRandom"]\n[[[1,2,3]],[]]'
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
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        ListNode reservoirNode = head;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
            count++;
            if (rand.nextInt(count + 1) == count) {
                reservoirNode = curNode;
            }
        }
        return reservoirNode.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
