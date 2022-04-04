class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        
        
        return solve(0,nums,0);
    }
    
    public int solve(int index,int[] nums,int xor){
        
        if(index == nums.length){
            return xor;
        }
        
        int count=0;
        
        count+=solve(index+1,nums,xor^nums[index]);
        count+=solve(index+1,nums,xor);
        
        return count;
        
    }
}