import java.util.*;

class Crossing_Blocks {

    static class pair {
        int val;
        int index;

        pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        Scanner sys = new Scanner(System.in);
        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while (t-- > 0) {
            int n = sys.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sys.nextInt();
            }
            pair[] rightMax = new pair[n];
            int max = -(int) 1e9, index = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                    index = i;

                }
                rightMax[i] = new pair(max, index);
            }

            long jumps = 0;
            int i = 0;
            while (i < n - 1) {
                if (arr[i] < rightMax[i + 1].val) {
                    System.out.println(-1);
                    return;
                } else {
                    i = rightMax[i + 1].index;
                    jumps++;

                }

            }

            System.out.println(jumps);

        }

    }

}