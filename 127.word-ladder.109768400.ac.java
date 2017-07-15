/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder
 *
 * Medium (19.33%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            Set<String> thisLevelVisited = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                
                if (curWord.equals(endWord)) {
                    return level;
                }
                
                List<String> nextWords = getNextWords(curWord, dict, visited);
                for (String nextWord : nextWords) {
                    queue.offer(nextWord);
                    thisLevelVisited.add(nextWord);
                }
            }
            visited.addAll(thisLevelVisited);
            level++;
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String curWord, Set<String> dict, Set<String> visited) {
        List<String> res = new ArrayList<>();
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (chars[i] == c) {
                    continue;
                }
                
                chars[i] = c;
                String newWord = new String(chars);
                if (dict.contains(newWord) && !visited.contains(newWord)) {
                    res.add(newWord);
                }
            }
            chars[i] = letter;
        }
        
        return res;
    }
}
