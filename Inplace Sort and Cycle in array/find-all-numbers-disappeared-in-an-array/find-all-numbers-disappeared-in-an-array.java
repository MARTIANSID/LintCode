class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i+1&&nums[nums[i]-1]!=nums[i]){
                swap(i,nums[i]-1,nums);
            
            
            }
        }
                List<Integer> ans=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]-1!=i)ans.add(i+1);
            }
                
                return ans;
        
        
    }
    
        
       public void swap(int i,int j,int[] nums){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
}