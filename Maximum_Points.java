import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.*;

public class Maximum_Points {

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);
        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while (t-- > 0) {

            int a1 = sys.nextInt();
            int b1 = sys.nextInt();
            int c1 = sys.nextInt();

            int x = sys.nextInt();
            int y = sys.nextInt();
            int z = sys.nextInt();

            List<int[]> arr = new ArrayList<>();

            arr.add(new int[] { a1, x });
            arr.add(new int[] { b1, y });
            arr.add(new int[] { c1, z });

            int time = 240;
            boolean[] visited = new boolean[3];

            System.out.println(solve(arr, time, visited));
        }

    }

    public static long solve(List<int[]> arr, int time, boolean[] visited) {

        long max = 0;
        for (int i = 0; i < 3; i++) {
            if (visited[i])
                continue;
            long points = 0;
            int[] val = arr.get(i);
            long maxt = val[0] * 20;
            
            if (maxt <= time) {
                time -= maxt;
                points = points + (long) (val[1] * 20);
            } else {
                int count = time / val[0];
                time -= count * val[0];
                points = points + (long) (count * val[1]);
            }
            visited[i] = true;
            max = Math.max(max, solve(arr, time, visited) + points);
            visited[i] = false;

        }

        return max;

    }
}