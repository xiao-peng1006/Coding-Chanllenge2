import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int left, int right, int k_smallest) {
        if (left == right) {
            return nums[left];
        }

        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left);

        pivot_index = partition(nums, left, right, pivot_index);

        if (k_smallest == pivot_index) {
            return nums[k_smallest];
        } else if (k_smallest < pivot_index) {
            return quickSelect(nums, left, pivot_index - 1, k_smallest);
        } else {
            return quickSelect(nums, pivot_index + 1, right, k_smallest);
        }
    }

    public int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];

        swap(nums, pivot_index, right);
        int store_index = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, store_index++);
            }
        }

        swap(nums, right, store_index);

        return store_index;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}