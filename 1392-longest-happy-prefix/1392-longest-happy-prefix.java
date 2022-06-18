class Solution {

    /*
    Concept used here is lps
    */

    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, len = 0, max = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                if (len > max) {
                    max = len;
                }
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }

        if (lps[n - 1] == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < lps[n - 1]; i++) {
            sb.append(s.charAt(i));
        }
        return new String(sb);
    }
}
