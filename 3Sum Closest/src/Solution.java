import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDistance = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int dis = Math.abs(sum - target);
                if ( dis < minDistance) {
                    minDistance = dis;
                    res = sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}