package com.breezevv.leetcode.editor.cn;

import com.breezevv.leetcode.domain.TreeNode;
import com.breezevv.leetcode.utils.LeetCodeUtils;

@SuppressWarnings("all")
public class _965_UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new _965_UnivaluedBinaryTree().new Solution();
        TreeNode root = LeetCodeUtils.createTree("[2,2,2,5,2]");
        System.out.println(solution.isUnivalTree(root));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (pre != null && pre.val != root.val) {
                ans = false;
                return;
            }
            pre = root;

            dfs(root.left);
            dfs(root.right);
        }

        TreeNode pre = null;
        boolean ans = true;
    }
//leetcode submit region end(Prohibit modification and deletion)

}