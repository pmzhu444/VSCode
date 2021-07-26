/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        char c = s.charAt(0);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == c) {
                if (s.length() == 1) {
                    return true;
                } else if (t.length() == i + 1) {
                    return false;
                } else {
                    return isSubsequence(s.substring(1, s.length()), t.substring(i + 1, t.length()));
                }
            }
        }
        return false;
    }
}
// @lc code=end

