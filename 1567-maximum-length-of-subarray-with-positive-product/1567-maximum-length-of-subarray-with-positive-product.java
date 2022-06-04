class Solution {

    public int getMaxLen(int[] nums) {
        int n = nums.length;

        int leftMostNegetive = -1, neg = 0, ans = 0,zero=0;

        for (int i = 0; i < n; i++) {
            int ele = nums[i];
            if (ele == 0) {
                leftMostNegetive = -1;
                neg = 0;
                zero=i+1;
            } else if (ele < 0) {
                neg++;
                if (leftMostNegetive == -1)leftMostNegetive=i;
                
            }
            if (neg % 2 == 0) {
                ans=Math.max(ans,i+1-zero);
            } else {
                if (leftMostNegetive != -1) {
                    ans = Math.max(ans, i - leftMostNegetive);
                } 
            }
        }
        return ans;
    }
}
