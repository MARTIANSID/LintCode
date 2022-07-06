class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        int index = n - lps[n - 1] - 1;
        StringBuilder sb = new StringBuilder();

        String sub = "";

        for (i = 0; i <= index; i++) sub += s.charAt(i);
        if (sub.equals(s)) return false;

        while (sb.length() < n) {
            sb.append(sub);
        }

        if (new String(sb).equals(s)) return true; else return false;
    }
}
