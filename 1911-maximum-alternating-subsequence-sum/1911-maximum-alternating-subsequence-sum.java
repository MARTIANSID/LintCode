class Solution {
    long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[2][n+1];

        for (int index = n - 1; index >= 0; index--) {
            for (int operator = 0; operator <= 1; operator++) {
                long x = 0, y = 0;
                 x = dp[operator == 1 ? 0 : 1][index + 1] + (operator == 1 ? nums[index] : -nums[index]);

                 y = dp[operator][index + 1];

                dp[operator][index] = Math.max(x, y);
            }
        }

        // for(long[] row:dp){
        //     System.out.println(Arrays.toString(row));
        // }

        return dp[1][0];
    }
    //      public long solve(int[] nums,int operator,int index){

    //          if(index==nums.length)return 0;

    //          if(dp[operator][index]!=null)return dp[operator][index];

    //          long x=solve(nums,operator==1?0:1,index+1) + (operator==1?nums[index]:-nums[index]);

    //         long y=solve(nums,operator,index+1);

    //          return dp[operator][index]= Math.max(x,y);

    //      }

}
