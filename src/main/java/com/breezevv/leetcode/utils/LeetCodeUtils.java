package com.breezevv.leetcode.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONNull;
import cn.hutool.json.JSONUtil;
import com.breezevv.leetcode.domain.TreeNode;
import com.breezevv.leetcode.domain.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeUtils {

    public static TreeNode createTree(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        int cnt = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (cnt < nums.length && poll != null) {
                    if (nums[cnt] == null) {
                        poll.left = null;
                    } else {
                        poll.left = new TreeNode(nums[cnt]);
                        queue.add(poll.left);
                    }
                    cnt++;
                }
                if (cnt < nums.length && poll != null) {
                    if (nums[cnt] == null) {
                        poll.right = null;
                    } else {
                        poll.right = new TreeNode(nums[cnt]);
                        queue.add(poll.right);
                    }
                    cnt++;
                }

            }
        }
        return root;
    }

    public static TreeNode createTree(String str) {
        Integer[] array = create1dIntegerArray(str);
        return createTree(array);
    }

//    private static TreeNode createTree(Integer[] arr, int i) {
//        if (i > arr.length - 1) {
//            return null;
//        }
//        if (arr[i] == null) {
//            return null;
//        }
//        TreeNode root = new TreeNode(arr[i]);
//        root.left = createTree(arr, 2 * i + 1);
//        root.right = createTree(arr, 2 * i + 2);
//        return root;
//    }

    public static void printListNode(ListNode listNode) {
        System.out.print("[");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static ListNode createListNode(int[] nums) {
        ListNode root = new ListNode(nums[0]);
        ListNode t = root;
        for (int i = 1; i < nums.length; i++) {
            t.next = new ListNode(nums[i]);
            t = t.next;
        }
        return root;
    }

    public static ListNode createListNode(String str) {
        int[] array = create1dIntArray(str);
        return createListNode(array);
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static <T> void printArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t.toString() + " ");
        }
        System.out.println();
    }

    private static Integer[] create1dIntegerArray(String str) {
        JSONArray jsonArray = JSONUtil.parseArray(str);
        Integer[] result = new Integer[jsonArray.size()];
        for (int i = 0; i < result.length; i++) {
            if (JSONNull.NULL.equals( jsonArray.get(i))) {
                result[i] = null;
            } else {
                result[i] = (Integer) jsonArray.get(i);
            }
        }
        return result;
    }

    public static int[] create1dIntArray(String str) {
        JSONArray jsonArray = JSONUtil.parseArray(str);
        int[] result = new int[jsonArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) jsonArray.get(i);
        }
        return result;
    }

    public static char[] createChar1Array(String str) {
        JSONArray jsonArray = JSONUtil.parseArray(str);
        char[] result = new char[jsonArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((String) jsonArray.get(i)).charAt(0);
        }
        return result;
    }

    public static char[][] create2dCharArray(String str) {
        JSONArray objects = JSONUtil.parseArray(str);
        JSONArray o =(JSONArray) objects.get(0);
        char[][] res = new char[objects.size()][o.size()];
        for (int i = 0; i < objects.size(); i++) {
            res[i] = createChar1Array(String.valueOf(objects.get(i)));
        }
        return res;
    }

//    public static <T> T[] createArrayWithType(String str, T t) {
//        JSONArray jsonArray = JSONUtil.parseArray(str);
//        T[] result = Array.newInstance(T, jsonArray.size());
//        for (int i = 0; i < result.length; i++) {
//            result[i] = (T) jsonArray.get(i);
//        }
//        return result;
//    }

    public static int[][] create2dIntArray(String str) {
        JSONArray objects = JSONUtil.parseArray(str);
        JSONArray o =(JSONArray) objects.get(0);
        int[][] res = new int[objects.size()][o.size()];
        for (int i = 0; i < objects.size(); i++) {
            res[i] = create1dIntArray(String.valueOf(objects.get(i)));
        }
        return res;
    }

    public static List<String> createStrList(String str) {
        JSONArray jsonArray = JSONUtil.parseArray(str);
        return jsonArray.toList(String.class);
    }

    public static String[] createStrArray(String str) {
        return createStrList(str).toArray(new String[0]);
    }
}
