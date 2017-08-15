/*
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 *
 * Hard (28.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["RandomizedCollection","insert","insert","insert","getRandom","remove","getRandom"]\n[[],[1],[1],[2],[],[1],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class RandomizedCollection {
    private Random rand;
    private List<Integer> vals;
    private Map<Integer, Set<Integer>> map;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.rand = new Random();
        this.vals = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(vals.size());
            vals.add(val);
            return false;
        }
        map.put(val, new HashSet<>());
        map.get(val).add(vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        
        if (index < vals.size() - 1) {
            int lastNum = vals.get(vals.size() - 1);
            map.get(lastNum).remove(vals.size() - 1);
            vals.set(index, lastNum);
            map.get(lastNum).add(index);            
        }
        
        vals.remove(vals.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
