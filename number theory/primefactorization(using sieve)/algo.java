

public class algo {
    public static void main(String[] args) {
        int maxN = (int) 1e6;
        int[] arr = new int[(int) 1e6 + 1];
        for (int i = 1; i <= maxN; i++)
            arr[i] = -1;
        for (int i = 2; i <= maxN; i++) {
            if (arr[i] == -1) {
                for (int j = i; j <= maxN; j += i) {
                    if (arr[j] == -1)
                        arr[j] = i;
                }
            }
        }

        int i = 110; // find prime factorization of this numhber

        while (arr[i] != -1) {
            System.out.println(arr[i]);
            i = i / arr[i];
        }

    }
}
