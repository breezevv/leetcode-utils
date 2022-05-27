package com.breezevv.leetcode.editor.cn;

import com.breezevv.leetcode.utils.LeetCodeUtils;

@SuppressWarnings("all")
public class _45_JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new _45_JumpGameIi().new Solution();
        System.out.println(solution.jump(LeetCodeUtils.create1dIntArray("[1,2,3,4]")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {
            int ans = 0;
            int end = 0;
            int maxPos = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxPos = Math.max(nums[i] + i, maxPos);
                if (i == end) {
                    end = maxPos;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}