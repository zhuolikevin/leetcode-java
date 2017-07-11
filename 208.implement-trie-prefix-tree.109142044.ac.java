/*
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree
 *
 * Medium (27.69%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Trie","search"]\n[[],["a"]]'
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
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ', false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                curNode.children.put(letter, new TrieNode(letter, false));
            }
            curNode = curNode.children.get(letter);
        }
        curNode.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                return false;
            }
            curNode = curNode.children.get(letter);
        }
        return curNode.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                return false;
            }
            curNode = curNode.children.get(letter);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
