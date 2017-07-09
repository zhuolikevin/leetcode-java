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
    private char[] alphabet = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'
    };
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        
        Set<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        distQ.offer(1);
        
        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            int distance = distQ.poll();
            if (curWord.equals(endWord)) {
                return distance;
            }
            
            char[] letters = curWord.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                char originLetter = letters[i];
                for (int j = 0; j < alphabet.length; j++) {
                    if (letters[i] == alphabet[j]) {
                        continue;
                    }
                    
                    letters[i] = alphabet[j];
                    String nextWord = new String(letters);
                    if (wordDict.contains(nextWord) && !visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        distQ.offer(distance + 1);
                        visited.add(nextWord);
                    }
                }
                letters[i] = originLetter;
            }
        }
        
        return 0;
    }
}
