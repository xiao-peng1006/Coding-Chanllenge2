class Solution {
    char[] charArray;
    public String reverseVowels(String s) {
        this.charArray = s.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            while (left < charArray.length && !isVowel(charArray[left])) {
                left++;
            }

            while (right >= 0 && !isVowel(charArray[right])) {
                right--;
            }

            if (left > right) continue;
            swap(left++, right--);
        }
        return new String(charArray);
    }

    public void swap(int a, int b) {
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
    }

    public boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}