/*
 * [281] Zigzag Iterator
 *
 * https://leetcode.com/problems/zigzag-iterator
 *
 * Medium (50.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2]\n[3,4,5,6]'
 *
 * Can you solve this problem? 🤔
 */
public class ZigzagIterator {
    private int count;
    private int total;
    private List<List<Integer>> vs;
    private int row;
    private int col;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.count = 0;
        this.total = v1.size() + v2.size();
        this.vs = new ArrayList<>();
        this.vs.add(v1);
        this.vs.add(v2);
        this.row = -1;
        this.col = 0;
    }

    public int next() {
        if (hasNext()) {
            do {
                row++;
                if (row == vs.size()) {
                    col++;
                    row = 0;
                }
            } while (vs.get(row).size() <= col);
            count++;
            return vs.get(row).get(col);
        } else {
            return -1;
        }
    }

    public boolean hasNext() {
        return count < total;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
