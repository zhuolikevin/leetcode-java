/*
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii
 *
 * Hard (14.01%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Can you solve this problem? 🤔
 */
class Node {
    String word;
    int distance;
    List<String> path;
    Node(String word, int distance, List<String> path) {
        this.word = word;
        this.distance = distance;
        this.path = path;
    }
}
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        
        Set<String> wordDict = new HashSet<>();
        for (String word : wordList) {
            wordDict.add(word);
        }
        
        Set<String> visited = new HashSet<>();
        
        Queue<Node> queue = new LinkedList<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        Node beginNode = new Node(beginWord, 1, temp);
        queue.offer(beginNode);
        
        Integer shortestDist = null;
        
        while (!queue.isEmpty()) {
            Set<String> thisLevelVisited = new HashSet<>();
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Node curNode = queue.poll();
                if (shortestDist != null && curNode.distance > shortestDist) {
                    continue;
                }
                if (curNode.word.equals(endWord)) {
                    if (shortestDist == null) {
                        shortestDist = curNode.distance;
                    }
                    res.add(curNode.path);
                    continue;
                }
                
                List<String> nextWords = findNextWords(curNode.word, wordDict, visited);
                for (String nextWord : nextWords) {
                    List<String> newPath = new ArrayList<>(curNode.path);
                    newPath.add(nextWord);
                    queue.offer(new Node(nextWord, curNode.distance + 1, newPath));
                    thisLevelVisited.add(nextWord); 
                }
            }
            visited.addAll(thisLevelVisited);
        }
        
        return res;
    }
    
    private List<String> findNextWords(String curWord, Set<String> wordDict, Set<String> visited) {
        List<String> res = new ArrayList<>();
        
        char[] letters = curWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char originLetter = letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originLetter) {
                    continue;
                }

                letters[i] = c;
                String nextWord = new String(letters);
                if (wordDict.contains(nextWord) && !visited.contains(nextWord)) {
                    res.add(nextWord);
                }
            }
            letters[i] = originLetter;
        }
        
        return res;
    }
}
