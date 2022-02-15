class Solution {
    public int maxRotateFunction(int[] nums) 
    {
        int n=nums.length;
        
        int sum=0,total=0;
        
        for(int i=0;i<n;i++)
        {
            total+=nums[i];
            sum+=(i*nums[i]);
        }
        
        
        int max=sum;
       
        int i=n-1;
        
        while(i>=0)
        {
            sum-=(n-1)*nums[i]; 
            sum+=(total-nums[i]);
            max=Math.max(max,sum);
            i--;
        }
        
        return max;
        
        
        
    }
}