class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        
        int maxXorSub=maxXor(nums,0,0);
        
       
        return countSub(nums,0,0,maxXorSub);
        
    }
    
    
    public int countSub(int[] nums,int index,int xor,int mXor){
        
        
        if(index == nums.length){
            if(xor == mXor){
                return 1;
            }
            return 0;
        } 
        
        
        int count=0;
        
        count+=countSub(nums,index+1,xor | nums[index],mXor);
        
        count+=countSub(nums,index+1,xor,mXor);
        
        return count;
    }

    
    public int maxXor(int[] nums,int index,int xor){
        
        if(index == nums.length){
            return xor;
        }
        
        
       int val1= maxXor(nums,index+1,xor | nums[index]);
       int val2=  maxXor(nums,index+1,xor);
        
        return Math.max(val1,val2);
        
    }
}