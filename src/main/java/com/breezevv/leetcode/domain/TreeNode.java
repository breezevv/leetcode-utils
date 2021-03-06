package com.breezevv.leetcode.domain;

public class TreeNode {

    /**
     * 值
     */
    public int val;

    /**
     * 左节点
     */
    public TreeNode left;

    /**
     * 右节点
     */
    public TreeNode right;


    public TreeNode() {
        this(0);
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
