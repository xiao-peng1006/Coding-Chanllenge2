class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int start = 0, end = -1, sum = 0;
        int minSize = nums.length + 1;
        while (start < nums.length) {
            if (end + 1 < nums.length && sum < s) {
                sum += nums[++end];
            } else {
                sum -= nums[start++];
            }

            if (sum >= s) {
                minSize = Math.min(minSize, end - start + 1);
            }
        }
        return minSize == nums.length + 1 ? 0 : minSize;
    }
}