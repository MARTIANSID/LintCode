import java.util.Scanner;

class K_th_Maximum {

    public static void main(String[] args) {

        Scanner sys = new Scanner(System.in);
        int t = 0;
        if (sys.hasNext()) {
            t = sys.nextInt();
        }

        while (t-- > 0) {
            int n = sys.nextInt();
            int k = sys.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sys.nextInt();
            }
            int ei = 0, si = 0;

            int max = -(int) 1e9;
            for (int ele : arr) {
                max = Math.max(max, ele);
            }

            int count = 0;
            while (ei < n) {
                while (ei - si < k - 1) {
                    ei++;
                }

                int index = si + k - 1;
                // System.out.println(arr[index]);
                if (arr[index] >= max) {
                    count += n - ei;

                }

                ei++;

                si++;

            }
            System.out.println(count);
        }

    }

}