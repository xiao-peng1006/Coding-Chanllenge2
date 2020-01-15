class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0, k = 0;
        int targetNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != targetNum) {
                targetNum = nums[i];
                count = 0;
            }
            count++;
            if (count <= 2) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}