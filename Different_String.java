import java.util.*;
import java.lang.*;
import java.io.*;

class Different_String {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sys = new Scanner(System.in);
        int t = sys.nextInt();

        while (t-- > 0) {
            int n = sys.nextInt();
            String[] arr = new String[n];
            int j = 0;
            int s=n;
            while (s-- > 0) {
                arr[j] = sys.next();
                j++;
            }
            boolean[] visited = new boolean[n];
            StringBuilder sb = new StringBuilder();
            int count = 0, index = 0;
            while (count < n) {
                int countOfZero = 0, countOfOne = 0;
                for (int i = 0; i < n; i++) {
                    if (visited[i])
                        continue;
                    char ch = arr[i].charAt(index);
                    if (ch == '0')
                        countOfZero++;
                    else
                        countOfOne++;
                }
                if (countOfZero >= countOfOne)
                    sb.append("1");
                else
                    sb.append("0");

                for (int i = 0; i < n; i++) {
                    if (visited[i])
                        continue;
                    char ch = arr[i].charAt(index);
                    if (countOfZero >= countOfOne && ch == '0') {
                        visited[i] = true;
                        count++;
                    }
                    if (countOfOne > countOfZero && ch == '1') {
                        visited[i] = true;
                        count++;
                    }
                }
                index++;
            }

            // int size = sb.length();
            while (sb.length() < n) {
                sb.append("0");
            }

            String ans = new String(sb);
            System.out.println(ans);

        }

    }
}