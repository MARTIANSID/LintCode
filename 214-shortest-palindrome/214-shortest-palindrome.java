class Solution {

    /*
    https://www.youtube.com/watch?v=M0Nwvd-G-tg
    lps concept will be used to find out the longest palindrome from index 0 in o(n)
    
    how lps is used here?
    str=aacecaaa*aaacecaa (string after * is reverse of original string)
    for str if we find out the lps value for the last character then it would give me the longest palindrom starting from the 0th index of the original string.
    */

    public String shortestPalindrome(String s) {
        int n = s.length();
        String str = s + "#" + reverse(s);
        int m = str.length();
        int[] lps = new int[m];
        int i = 1, len = 0;
        while (i < m) {
            if (str.charAt(i) == str.charAt(len)) {
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
        int toInclude = (n - lps[m - 1]);
        StringBuilder sb = new StringBuilder();
        i = n - 1;
        while (toInclude-- > 0) {
            sb.append(s.charAt(i--));
        }
        sb.append(s);
        return new String(sb);
    }

    public String reverse(String s) {
        return new String(new StringBuilder(s).reverse());
    }
}
