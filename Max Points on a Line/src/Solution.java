import javafx.util.Pair;
import java.util.HashMap;

class Solution {
    int[][] points;
    HashMap<Double, Integer> lines = new HashMap<>();
    int verticalLines, n;
    public Pair<Integer, Integer> addLines(int i, int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        if ((x1 == x2) && (y1 == y2)) {
            duplicates++;
        } else if (y1 == y2) {
            verticalLines++;
            count = Math.max(count, verticalLines);
        } else {
            double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(count, lines.get(slope));
        }
        return new Pair(count, duplicates);
    }

    public int maxPointsOnALine(int i) {
        lines.clear();
        verticalLines = 1;
        int count = 1, duplicates = 0;

        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = addLines(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    public int maxPoints(int[][] points) {
        this.points = points;
        this.n = points.length;

        if (n < 3) {
            return n;
        }

        int maxCount = 1;

        for (int i = 0; i < n - 1; i++) {
            maxCount = Math.max(maxPointsOnALine(i), maxCount);
        }
        return maxCount;
    }
}