import java.util.Arrays;

public class KClosestPointsToOrigin {
    
    public static class Info {
        public int index;
        public int dist;
        
        public Info(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
    
    public static int squareDist(int x, int y) {
        return (x * x) + (y * y);
    }
    
    public static void swap(Info[] info, int a, int b) {
        Info temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }
    
    public static int partition(Info[] info, int low, int high) {
        int pivot = info[high].dist;
        int i = low - 1; // Final pivot location
        for (int j = low; j < high; j++) {
            // Swap element if its smaller than pivot
            if (pivot >= info[j].dist) {
                i++; // Increment pivot location 
                swap(info, i, j);
            }
        }
        // Swap the pivot with the final pivot location
        swap(info, i + 1, high);
        return i + 1;
    }
    
    public static int quickSelect(Info[] info, int low, int high, int k) {
        if (low <= high && k > 0 && k <= (high - low + 1)) {
            int position = partition(info, low, high);
            // Number of terms from start to position = (position - low + 1)
            if (position - low + 1 == k) {
                return position;
                // If number of terms greater than k, search left else right
            } else if (position - low + 1 > k) {
                return quickSelect(info, low, position - 1, k);
            } else {
                // The number of terms on the right would be k - (number of terms from left to position)
                return quickSelect(info, position + 1, high, (k - (position - low + 1)));
            }
        }
        return  -1;
    }
    
    public static int[][] kClosest(int[][] points, int k) {
        Info[] info = new Info[points.length];
        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            info[i] = new Info(i, squareDist(points[i][0], points[i][1]));
        }
        quickSelect(info, 0, points.length - 1, k);
        for (int j = 0; j < k; j++) {
            ans[j] = points[info[j].index];
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] points = {{-2, 2}, {-2, 2}};
        int k = 2;
        // To print out nested arrays, use deepToString() from Arrays
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }
    
    /*
     * Learning points:
     * 
     * The solution uses quickSelect algorithm to achieve O(n) time complexity.
     * -> use sum of geometric series -> O(n) = n + n/2 + n/4 + ...
     * However, the time complexity degrades to O(n**2) during the partition phase
     * if the greatest/smallest element is always being picked as the pivot. 
     * 
     */
}
