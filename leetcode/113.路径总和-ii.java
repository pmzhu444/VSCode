import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, ans, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(TreeNode node, int targetSum, List<List<Integer>> ans, int current, List<Integer> tmp) {
        current += node.val;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (current == targetSum) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < tmp.size(); i++) {
                    l.add(tmp.get(i));
                }
                ans.add(l);
            }
        }
        if (node.left != null) {
            dfs(node.left, targetSum, ans, current, tmp);
        }
        if (node.right != null) {
            dfs(node.right, targetSum, ans, current, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
// @lc code=end

