public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0, x = 32;
        while (x-- > 0) {
            if ((n & 1) != 0) cnt++;
            n = (n >> 1);
        }

        return cnt;
    }
}
