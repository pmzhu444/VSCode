/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        ans.add(l1);
        if (numRows == 1) {
            return ans;
        }
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 1));
        ans.add(l2);
        if (numRows == 2) {
            return ans;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> last = ans.get(i - 2);
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for (int j = 1; j < i - 1; j++) {
                l.add(last.get(j - 1) + last.get(j));
            }
            l.add(1);
            ans.add(l);
        }
        return ans;
    }
}
// @lc code=end

