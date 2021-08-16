import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to find the largest number after k swaps.
    static String max;
    static String ans;

    public static String findMaximumNum(String str, int k) {
        max = str;
        ans = str;
        findMax(k, 0);
        return ans;
    }

    public static void findMax(int k, int index) {

        if (k == 0 || index == max.length() - 1) {

            long x = Long.parseLong(max);
            long y = Long.parseLong(ans);

            if (x > y) {
                ans = max;
            }

            return;

        }

        for (int i = index; i < ans.length(); i++) {
            if (Character.getNumericValue(max.charAt(i)) >= Character.getNumericValue(max.charAt(index))) {
                max = swap(index, i);
                findMax(max.charAt(i) != max.charAt(index) ? k - 1 : k, index + 1);
                max = swap(index, i);
            }
        }

    }

    public static String swap(int i, int j) {
        char[] c = max.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        String ans = new String(c);
        return ans;

    }

}