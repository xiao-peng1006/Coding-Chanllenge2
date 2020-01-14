class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int targetNum = nums[0], k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > targetNum) {
                nums[k++] = nums[i];
                targetNum = nums[i];
            }
        }
        return k;
    }
}