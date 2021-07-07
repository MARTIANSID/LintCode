class Solution {
    public void sortColors(int[] nums) {
        
            
        int indexOfZero=0,indexOfTwo=nums.length-1;
            
          for(int i=0;i<nums.length;i++){
                  if(nums[i]!=0){
                          indexOfZero=i;
                          break;
                  }
          }
            
            
            for(int i=nums.length-1;i>=0;i--){
                    if(nums[i]!=2){
                            indexOfTwo=i;
                            break;
                    }
            }
            // System.out.println(indexOfTwo);
            
            
            for(int i=0;i<nums.length&&indexOfZero<=indexOfTwo;i++){
                    while(indexOfTwo>=0&&nums[indexOfTwo]==2){
                                indexOfTwo--;

                    }
                    
                    while(indexOfZero<nums.length&&nums[indexOfZero]==0){
                            indexOfZero++;
                    }
                    
                    if(nums[i]==2&&i<=indexOfTwo){
                            swap(nums,i,indexOfTwo);
                            indexOfTwo--;
                    }
                    
                    if(nums[i]==0&&i>=indexOfZero){
                            swap(nums,i,indexOfZero);
                            indexOfZero++;
                    }
            }
           
    }
        private void swap(int[] nums,int i,int j){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
        }
}