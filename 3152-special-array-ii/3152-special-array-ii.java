class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0;
        
        int[] left = new int[n];
        
        boolean[] ans = new boolean[queries.length];
        
        
        for(int i = 1; i < n; i++) {
            int currElement = nums[i] % 2 == 0 ? 1 : 0;
            int prevElement = nums[i-1] % 2 == 0 ? 1 : 0;
            
            if((currElement^prevElement) == 0) {
                sum++;
            }
            left[i] = sum;
        }
        
        int index = 0;
        
        for(int[] query  : queries) {
            int l = query[0], r = query[1];
            
            if(left[r]-left[l] == 0) {
                ans[index++] = true;
            } else {
                ans[index++] = false;
            }
        }
        return ans;
        
    }
}