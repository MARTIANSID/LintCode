class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        int xor1 = 0, xor2 = 0;

        for (int ele : nums1) {
            xor1 ^= ele;
        }
        for (int ele : nums2) {
            xor2 ^= ele;
        }

        int xor = 0;

        if (n2 % 2 != 0) {
            xor = (xor ^ xor1);
        }

        if (n1 % 2 != 0) {
            xor = (xor ^ xor2);
        }

        return xor;
    }
}
/*

    

*/
