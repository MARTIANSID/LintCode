class Solution {

    public int maxOperations(String s) {
        int n = s.length(), zeros = 0, ops = 0, onesWithZero = 0;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '0') {
                zeros++;
            } else {
                ops += onesWithZero;
                if (zeros > 0) {
                    ops += 1;
                    onesWithZero += 1;
                }
                zeros = 0;
            }
        }

        return ops;
    }
}
// 1001101 - > 1001011 - > 1000111 - > 000111
