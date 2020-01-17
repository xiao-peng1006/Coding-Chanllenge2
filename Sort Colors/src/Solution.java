class Solution {
    public void sortColors(int[] nums) {
        // Three way sorting
        int zero = -1, two = nums.length, i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i);
            } else if (nums[i] == 2) {
                swap(nums, --two, i--);
            }
            i++;
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}