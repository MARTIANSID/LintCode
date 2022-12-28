import java.util.*;
import java.util.HashMap;

class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length,m=1;
        
        HashMap<String,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            int max=0;
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i], p2 = points[j];
                int y = p2[1] - p1[1];
                int x = p2[0] - p1[0];
                int hcf = gcd(y, x);
                y = y / hcf;
                x = x / hcf;
                String key = y + "," + x;
                map.put(key,map.getOrDefault(key,0)+1);
                max=Math.max(max,map.get(key));
                
            }
            map=new HashMap<>();
            m=Math.max(m,max+1);
        }
        return m;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
