/*
 * [244] Shortest Word Distance II
 *
 * https://leetcode.com/problems/shortest-word-distance-ii
 *
 * Medium (37.49%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["WordDistance","shortest","shortest"]\n[[["practice","makes","perfect","coding","makes"]],["coding","practice"],["makes","coding"]]'
 *
 * Can you solve this problem? 🤔
 */
public class WordDistance {
    private Map<String, List<Integer>> dict;

    public WordDistance(String[] words) {
        dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!dict.containsKey(words[i])) {
                dict.put(words[i], new ArrayList<>());
            }
            List<Integer> list = dict.get(words[i]);
            list.add(i);
            dict.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = dict.get(word1);
        List<Integer> list2 = dict.get(word2);
        int shortest = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            shortest = Math.min(shortest, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
