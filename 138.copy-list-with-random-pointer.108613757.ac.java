/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer
 *
 * Medium (26.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '{}'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, newHead);
        RandomListNode curOrigin = head;
        RandomListNode curNew = newHead;
        
        while (curOrigin.next != null) {
            RandomListNode newNode = new RandomListNode(curOrigin.next.label);
            curNew.next = newNode;
            map.put(curOrigin.next, newNode);
            
            curOrigin = curOrigin.next;
            curNew = curNew.next;
        }
        
        curOrigin = head;
        curNew = newHead;
        while (curNew != null) {
            curNew.random = map.get(curOrigin.random);
            
            curNew = curNew.next;
            curOrigin = curOrigin.next;
        }
        
        return newHead;
    }
}
