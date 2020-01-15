class Solution {
    public void sortColors(int[] nums) {
        // Using two pointers
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[l++] = 0;
            } else if (nums[i] == 2) {
                r--;
            }
        }

        for (int i = l; i <= r; i++) {
            nums[i] = 1;
        }

        for (int i = r + 1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}