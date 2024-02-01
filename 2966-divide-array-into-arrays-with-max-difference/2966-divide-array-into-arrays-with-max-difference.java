class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        
        int firstIndex = 0,currLength=0,index=0;
        
        int[][] ans=new int[n/3][3];
        
        if(n%3!=0) return new int[][]{};

        
        for(int i=0;i<n;i++){
            if(nums[i]-nums[firstIndex]<=k){
                currLength++;
            }else{
                if(currLength < 3)return new int[][]{};
                }
            if(currLength == 3){
                ans[index++]=Arrays.copyOfRange(nums,firstIndex,i+1);
                currLength=0;
                firstIndex=i+1;
            }
        }
        return ans;
    }
}