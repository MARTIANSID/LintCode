import java.util.*;

class Meet_In_The_Median {

    public static void main(String[] args) {
        int t = 0;
        Scanner sys = new Scanner(System.in);
        if (sys.hasNext())
            t = sys.nextInt();

        while (t-- > 0) {
            int n = sys.nextInt();
            int k = sys.nextInt();
            int[] a = new int[n];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sys.nextInt();
                arr[i] = a[i];
            }

            Arrays.sort(arr);
            int ei = 0, si = 0;
            int gei = 0, gsi = 0, max = -(int) 1e9;
            ;
            while (ei < n) {
                while (ei - si < k - 1) {
                    ei++;
                }
                ei++;
                int index = 0;
                if (k % 2 == 0) {
                    index = si + k / 2 - 1;
                } else {
                    index = si + k / 2;
                }
                if (arr[index] > max) {
                    gei = ei - 1;
                    gsi = si;
                    max = arr[index];
                }
                si++;

            }
            System.out.println(max);
            int lesserThanMax = 0, greaterThanMax = 0;
            List<Integer> ans = new ArrayList<>();
            if (k % 2 == 0) {
                lesserThanMax = k / 2 - 1;
                greaterThanMax = k - lesserThanMax - 1;
            } else {
                lesserThanMax = k / 2;
                greaterThanMax = k - lesserThanMax - 1;
            }
            // System.out.println(lesserThanMax);

            for (int ele : a) {
                if (ele < max && lesserThanMax > 0) {
                    ans.add(ele);
                    lesserThanMax--;
                }
                if (ele > max && greaterThanMax > 0) {
                    ans.add(ele);
                    greaterThanMax--;
                }
                if (ele == max) {
                    ans.add(ele);
                }
            }

            for (int ele : ans) {
                System.out.print(ele + " ");
            }

        }

    }
}