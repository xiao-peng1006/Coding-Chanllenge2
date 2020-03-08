import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            } else {
                for (int pos:map.get(nums[i])) {
                    if (Math.abs(i - pos) <= k) {
                        return true;
                    }
                }
            }
            map.get(nums[i]).add(i);
        }
        return false;
    }
}