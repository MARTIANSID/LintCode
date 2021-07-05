class Solution {
public int threeSumClosest(int[] nums, int target) {
   
    Arrays.sort(nums);
    
        int ans=1;
        int diff=(int)1e9;
 for(int i=0;i<nums.length;i++){
         
        int j=i+1;
        int k=nums.length-1;
         
         while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
        
                 if(Math.abs(sum-target)<=diff||Math.abs(sum-target)==0){
                       
                         diff=Math.abs(sum-target);
                if(diff==0)return sum;
                         ans=sum;
                         
                         if(sum>target){
                                 k--;
                         }else{
                                 j++;
                         }
                         
                 }else if(sum>target){ 
                         k--;
                 }else if(sum<target){
                         j++;
                 }
                 
                 
         }
 }       
        
      return ans;  
}
        
}