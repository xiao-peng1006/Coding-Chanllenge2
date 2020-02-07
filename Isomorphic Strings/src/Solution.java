import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (!map.containsKey(sChar)) {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
            } else {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            }
        }
        return true;
    }
}