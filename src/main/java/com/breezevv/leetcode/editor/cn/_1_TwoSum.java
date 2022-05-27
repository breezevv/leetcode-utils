package com.breezevv.leetcode.editor.cn;

import com.breezevv.leetcode.utils.LeetCodeUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class _1_TwoSum{
    public static void main(String[] args) {
        Solution solution = new _1_TwoSum().new Solution();
        int[] nums = LeetCodeUtils.create1dIntArray("[2,7,11,15]");
        LeetCodeUtils.printArray(solution.twoSum(nums, 9));
    }
      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}