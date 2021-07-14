class Solution {
    public int removeDuplicates(int[] nums) {
                  int count=1;
            int index=1;
            int uniqueValue=1;
           
        for(int i=1;i<nums.length;i++){
              
                if(nums[i]==nums[i-1]&&uniqueValue>=2){ //duplicate value condtion
                        
                }else{ //unique value conditon
                        if(nums[i]!=nums[i-1]){
                                nums[index]=nums[i];
                                count++;
                                index++;
                                uniqueValue=1;
                        }else{
                        nums[index]=nums[i];
                        count++;
                        index++;
                        uniqueValue++;
                        }
                }
                      
        }
            
           
       
            return count;
    }
}


// [1,1,1,2,2,3]
// [1,1