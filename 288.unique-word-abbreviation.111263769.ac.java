/*
 * [288] Unique Word Abbreviation
 *
 * https://leetcode.com/problems/unique-word-abbreviation
 *
 * Medium (16.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]\n[[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"]]'
 *
 * Can you solve this problem? 🤔
 */
public class ValidWordAbbr {
    private Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<>());
            }
            Set<String> set = map.get(abbr);
            set.add(word);
            map.put(abbr, set);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr)) {
            return true;
        }
        Set<String> set = map.get(abbr);
        return set.size() == 1 && set.contains(word);
    }
    
    private String getAbbr(String word) {
        int len = word.length();
        if (len <= 2) {
            return word;
        }
        return String.valueOf(word.charAt(0)) + String.valueOf(len - 2) + String.valueOf(word.charAt(len - 1));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
