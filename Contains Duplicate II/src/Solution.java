import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0, idx = k;
        for (int i = 0; i < k && i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        while (idx < nums.length) {
            if (set.contains(nums[idx])) {
                return true;
            } else {
                set.add(nums[idx++]);
                set.remove(nums[l++]);
            }
        }

        return false;
    }
}