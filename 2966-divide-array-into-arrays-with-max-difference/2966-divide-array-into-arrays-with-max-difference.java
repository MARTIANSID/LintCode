class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        int n=nums.length;
        Arrays.sort(nums);
        
        int[][] ans=new int[n/3][3];
        
        int start=0,end=2,index=0;
        
        while(end<n){
            if(nums[end]-nums[start]<=k){
                ans[index++]=Arrays.copyOfRange(nums, start, end+1);
            
            }else{
                return new int[][]{};
            }
            start=end+1;
            end+=3;
        }
        
         return ans;
    }
}