
import java.util.*;

public class algo {
    public static void main(String[] args) {
        // lets say the gcd of a and b is g
        // then we can say a=g*X and b=g*Y where X and Y are some numbers

        // Codechef GCDQ
        Scanner sys = new Scanner(System.in);
        int t = sys.nextInt();
        while (t-- > 0) {
            int n = sys.nextInt();
            int q = sys.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sys.nextInt();
            int[] left = new int[n];
            int[] right = new int[n];

            int x = arr[0];
            int y = arr[n - 1];
            for (int i = 0; i < n; i++) {
                x = gcdIterative(x, arr[i]);
                left[i] = x;
                y = gcdIterative(y, arr[n - 1 - i]);
                right[i] = y;

            }

            for (int i = 0; i < q; i++) {
                int l = sys.nextInt();
                int r = sys.nextInt();

                if (l == 1 && r == n) {
                    System.out.println(1);
                } else if (l == 1) {
                    System.out.println(right[r]);
                } else if (r == n) {
                    System.out.println(left[l - 2]);
                } else {
                    System.out.println(gcdIterative(left[l - 2], right[r]));
                }

            }
        }

    }

    // faster for some reason
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static int gcdIterative(int a, int b) {
        while (a > 0 && b > 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return a == 0 ? b : a;
    }
}
