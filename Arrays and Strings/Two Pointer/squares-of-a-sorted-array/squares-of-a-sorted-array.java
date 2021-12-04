class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        int i=-0,j=n-1;
        
        int[] ans=new int[n];
        
        int o=n-1;
        while(j>=i){
            if(nums[i]>nums[j]){
              ans[o--]=nums[i];  
            i++;
            }else{
                ans[o--]=nums[j];
                j--;
            }
        }
        
        return ans;
    }
    
   
}
