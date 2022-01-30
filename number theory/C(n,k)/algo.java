
public class algo {

    public static long power(long a, int n, int mod) {
        long res = 1;

        while (n > 0) {
            if (n % 2 == 0) {
                a = (a * a) % mod;
                n /= 2;
            } else {
                res = (res * a) % mod;
                n--;
            }
        }
        return res;
    }

    static int mod = (int) 1e9 + 7;
    public static long[] F = new long[1000001];

    // c(n,k)%mod
    long c(int n, int k) {
        if (k > n)
            return 0;
        long res = F[n];

        res = (res * power(F[k], mod - 2, mod)) % mod;
        res = (res * power(F[n - k], mod - 2, mod)) % mod;

        return res;
    }

    public static void main(String[] args) {
        F[0] = 1;
        F[1] = 1;
        for (int i = 0; i <= 100000; i++) {
            F[i] = (i * F[i - 1]) % mod;
        }
    }
}
