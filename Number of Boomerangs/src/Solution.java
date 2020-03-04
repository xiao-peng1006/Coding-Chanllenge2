import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        HashMap<Double, Integer> map = new HashMap<>();

        for (int[] point : points) {
            int j;
            for (j = 0; j < points.length; j++) {

                int[] pointB = points[j];

                double dis = Math.sqrt(Math.pow((point[0] - pointB[0]), 2) + Math.pow((point[1] - pointB[1]), 2));

                if (map.containsKey(dis)) {
                    res += 2 * map.get(dis);
                    map.put(dis, map.get(dis) + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            map.clear();
        }
        return res;
    }
}