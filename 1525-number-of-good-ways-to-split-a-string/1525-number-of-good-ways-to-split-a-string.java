class Solution {

    public int numSplits(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int[] left = new int[n];
        int[] right = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (freq[ch]++ == 0) {
                sum++;
            }
            left[i] = sum;
        }
        sum = 0;
        freq = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            if (freq[ch]++ == 0) {
                sum++;
            }
            right[i] = sum;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1]) count++;
        }
  

        return count;
    }
}
