import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int a : A) {
            for (int b : B) {
                int target = -a - b;
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
        }
        return res;
    }
}