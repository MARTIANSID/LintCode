
public class algo {
    public static void main(String[] args) {

    }

    public static int phi(int n) {
        int res = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                res /= i;
                res *= (i - 1);

                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            res /= n;
            res *= (n - 1);
        }
        return res;
    }
}
