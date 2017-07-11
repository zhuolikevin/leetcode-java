/*
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii
 *
 * Hard (23.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["oaan","etae","ihkr","iflv"]\n["oath","pea","eat","rain"]'
 *
 * Can you solve this problem? 🤔
 */
class ReturnType {
    boolean hasPrefix;
    boolean hasWord;
    public ReturnType(boolean hasPrefix, boolean hasWord) {
        this.hasPrefix = hasPrefix;
        this.hasWord = hasWord;
    }
}
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
    
    public Trie() {
        root = new TrieNode(' ', false);
    }
    
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
    public ReturnType search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curNode.children.containsKey(letter)) {
                return new ReturnType(false, false);
            }
            curNode = curNode.children.get(letter);
        }
        return new ReturnType(true, curNode.isEnd);
    }
}
public class Solution {
    private Set<String> res;
    private char[][] board;
    private Trie trie;
    
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        this.board = board;
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>(res);
        }
        
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;
                List<Character> path = new ArrayList<>();
                path.add(board[i][j]);
                dfs(visited, i, j, path);
            }
        }
        
        return new ArrayList<>(res);
    }
    
    private void dfs(boolean[][] visited, int i, int j, List<Character> path) {
        String curStr = getString(path);
        ReturnType flag = trie.search(curStr);
        if (!flag.hasPrefix) {
            return;
        }
        if (flag.hasWord) {
            res.add(curStr);
        }
        
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = board.length;
        int n = board[0].length;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                continue;
            }
            
            visited[x][y] = true;
            List<Character> newPath = new ArrayList<>(path);
            newPath.add(board[x][y]);
            dfs(visited, x, y, newPath);
            visited[x][y] = false;
        }
    }
    
    private String getString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
