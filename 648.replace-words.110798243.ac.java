/*
 * [648] Replace Words
 *
 * https://leetcode.com/problems/replace-words
 *
 * Medium (48.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["cat", "bat", "rat"]\n"the cattle was rattled by the battery"'
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
class Trie {
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
    public String search(String word) {
        TrieNode curNode = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                return curNode.isEnd ? sb.toString() : "";
            }
            curNode = curNode.children.get(letter);
            sb.append(letter);
            if (curNode.isEnd) {
                return sb.toString();
            }
        }
        return curNode.isEnd ? sb.toString() : "";
    }
}
public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return "";
        }
        Collections.sort(dict);
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        
        String[] words = sentence.split(" ");
        String[] res = new String[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String prefix = trie.search(words[i]);
            if (prefix == "") {
                res[i] = words[i];
            } else {
                res[i] = prefix;
            }
        }
        
        return String.join(" ", res);
    }
}
