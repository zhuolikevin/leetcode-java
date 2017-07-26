/*
 * [269] Alien Dictionary
 *
 * https://leetcode.com/problems/alien-dictionary
 *
 * Hard (23.64%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["wrt","wrf","er","ett","rftt"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> nodes = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                nodes.put(c, new HashSet<>());
                indegree.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String curWord = words[i];
            String nextWord = words[i + 1];
            for (int j = 0; j < Math.min(curWord.length(), nextWord.length()); j++) {
                char curChar = curWord.charAt(j);
                char nextChar = nextWord.charAt(j);
                if (curChar != nextChar) {
                    Set<Character> children = nodes.get(curChar);
                    if (!children.contains(nextChar)) {
                        children.add(nextChar);
                        nodes.put(curChar, children);
                        indegree.put(nextChar, indegree.get(nextChar) + 1);    
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
                
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char child : nodes.get(c)) {
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        
        return sb.length() == nodes.keySet().size() ? sb.toString() : "";
    }
}
