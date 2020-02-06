import java.util.HashSet;

class Solution {
    HashSet<Integer> set;
    public boolean isHappy(int n) {
        set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n%10;
            n = n/10;
            sum += d*d;
        }
        return sum;
    }
}