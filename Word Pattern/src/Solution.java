import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(strArray[i])) {
                    return false;
                }
                map.put(c, strArray[i]);
            } else {
                if (!map.get(c).equals(strArray[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}