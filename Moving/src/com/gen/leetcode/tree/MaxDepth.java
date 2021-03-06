package com.gen.leetcode.tree;

/**
 * 问题:104
 * @author Genge
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }
}
