class Solution {

    public int balancedString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int allowed = n / 4;

        int count = 0, min = (int) 1e9;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            if (freq[ch - 'A'] > allowed) count++;
        }
        int ei = 0, si = 0;

        if (count == 0) return 0;

        while (ei < n) {
            char ch = s.charAt(ei++);
            if (freq[ch - 'A']-- > allowed) count--;

            while (count == 0) {
                min = Math.min(min, ei - si);
                ch = s.charAt(si++);
                freq[ch - 'A']++;
                if (freq[ch - 'A'] > allowed) count++;
            }
        }
        return min == (int) 1e9 ? 0 : min;
    }
}
