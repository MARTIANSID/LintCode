class Solution {

    public int findSubstringInWraproundString(String s) {
        int n = s.length();

        int si = 0, ei = 0;

        int[] freq = new int[26];

        while (ei < n) {
            if (si == ei) { // first character
                freq[s.charAt(ei) - 'a'] = 1;
            } else {
                // we need to compare ei with ei-1

                if ((s.charAt(ei) - s.charAt(ei - 1) == 1) || (s.charAt(ei) == 'a') && s.charAt(ei - 1) == 'z') {
                    freq[s.charAt(ei) - 'a'] = Math.max(freq[s.charAt(ei) - 'a'], ei - si + 1);
                } else {
                    si = ei;
                    freq[s.charAt(ei) - 'a'] = Math.max(freq[s.charAt(ei) - 'a'], 1);
                }
            }
            ei++;
        }

        int cnt = 0;

        for (int ele : freq) {
            cnt += ele;
        }

        return cnt;
    }
}

// si = a
// ei = c
// "abc"
// c
// bc
// abc

// base = "abcd...z" + "abcd...z" ...
//     si = 0
//     ei = 1
// s = "abc"
// a
// ab
// b
// abc
// bc
// c
