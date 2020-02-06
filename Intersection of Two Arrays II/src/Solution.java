import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (int num:list) res[idx++] = num;
        return res;
    }
}