/*
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design
 *
 * Medium (22.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Can you solve this problem? 🤔
 */
class TrieNode {
    char c;
    boolean isEnd;
    Map<Character, TrieNode> children;
    public TrieNode(char c, boolean isEnd) {
        this.c = c;
        this.isEnd = isEnd;
        this.children = new HashMap<>();
    }
}
public class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ', false);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                curNode.children.put(letter, new TrieNode(' ', false));
            }
            curNode = curNode.children.get(letter);
        }
        curNode.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    
    private boolean dfs(TrieNode curNode, String word, int index) {
        if (index == word.length()) {
            return curNode.isEnd;
        }
        
        char letter = word.charAt(index);
        if (letter != '.') {
            if (!curNode.children.containsKey(letter)) {
                return false;
            } else {
                return dfs(curNode.children.get(letter), word, index + 1);
            }
        } else {
            for (char c : curNode.children.keySet()) {
                if (dfs(curNode.children.get(c), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
