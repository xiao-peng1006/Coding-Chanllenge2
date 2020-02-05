import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();
        for (char c:p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            if (i >= len) {
                c = s.charAt(i - len);
                if (sCount.get(c) == 1) {
                    sCount.remove(c);
                } else {
                    sCount.put(c, sCount.get(c) - 1);
                }
            }

            if (pCount.equals(sCount)) {
                res.add(i - len + 1);
            }
        }

        return res;
    }
}