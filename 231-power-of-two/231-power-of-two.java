class Solution {

    public boolean isPowerOfTwo(int n) {
        //there is only one set bit in power of 2 numbers

        int cnt = 0;

        while (n > 0) {
            if ((n & 1)!=0) cnt++;
            n = n >> 1;
        }
        return cnt == 1 ? true : false;
    }
}
