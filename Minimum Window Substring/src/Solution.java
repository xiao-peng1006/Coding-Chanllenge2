import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int required = tCount.size();
        int left = 0, right = 0;
        int formed = 0;
        HashMap<Character, Integer> sCount = new HashMap<>();

        int minLength = s.length();
        String res = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && tCount.get(c).intValue() == sCount.get(c).intValue()) {
                formed++;
            }
//            System.out.println("(" + left + ", " + right + "), " + formed);
            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (right - left < minLength) {
//                    System.out.println("Got: " + s.substring(left, right + 1));
                    minLength = right - left;
                    res = s.substring(left, right + 1);
                }

                if (tCount.containsKey(c) && sCount.get(c).intValue() == tCount.get(c).intValue()) {
                    formed--;
                }

                if (sCount.get(c) == 1) {
                    sCount.remove(c);
                } else {
                    sCount.put(c, sCount.get(c) - 1);
                }

                left++;
            }
            right++;
        }
        return res;
    }
}