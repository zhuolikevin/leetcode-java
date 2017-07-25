/*
 * [251] Flatten 2D Vector
 *
 * https://leetcode.com/problems/flatten-2d-vector
 *
 * Medium (40.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2],[3],[4,5,6]]'
 *
 * Can you solve this problem? 🤔
 */
public class Vector2D implements Iterator<Integer> {
    private int col;
    private int row;
    private Integer cur;
    private List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        this.row = 0;
        this.col = 0;
        this.cur = null;
        this.vec2d = vec2d;
        findNext();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int next = cur;
            col++;
            cur = null;
            findNext();
            
            return next;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }
    
    private void findNext() {
        while (row < vec2d.size()) {
            if (col < vec2d.get(row).size()) {
                cur = vec2d.get(row).get(col);
                break;
            } else {
                col = 0;
                row++;
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
