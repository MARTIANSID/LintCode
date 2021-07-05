class Solution {
    public int firstMissingPositive(int[] nums) {
      //nice q!
            
            // You must implement an algorithm that runs in O(n) time and uses constant extra space.
    //put the elements at thier right indexes
     //ignore numbers greater than n+1 also negetive numbers
        
       //dry run to find the edge case
      
            
            int n=nums.length;
         for(int i=0;i<n;i++){
          
                while(nums[i]!=i+1&&nums[i]<n&&nums[i]>0){
                        if(nums[nums[i]-1]==nums[i])break;
                        
                        swap(nums,i,nums[i]-1);
                }
               
                 
                
         }
             for(int i=0;i<nums.length;i++){
                         if(nums[i]!=i+1)return i+1;
                 } 
            
             return n+1;
                 
         
         
    }
        
           private void swap(int[] nums,int i,int j){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
            }
            
}
