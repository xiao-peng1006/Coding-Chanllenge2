import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sub;
        for (int i = 0; i < nums.length; i++) {
            sub = target - nums[i];
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}