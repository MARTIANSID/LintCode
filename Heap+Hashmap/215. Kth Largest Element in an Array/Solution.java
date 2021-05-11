class Solution {
    public int findKthLargest(int[] nums, int k) {
      
            for(int i=nums.length-1;i>=0;i--){
                    downHeapify(i,nums);
            }
            int x=-1;
            while(k-->0){
                 x= remove(nums);  
            }
            return x;
            
    }
        public int remove(int[] nums) {
        int ele = nums[0];
        int n = nums.length;
        swap(0, n - 1,nums);
        nums[n-1]=-(int)1e9;
        downHeapify(0,nums);
        return ele;

    }
        
        
        
       public void swap(int index1, int index2,int[]  nums) {
        int temp = nums[index1];
        // arr.set(index1, nums[index2]);
               nums[index1]=nums[index2];
        // arr.set(index2, temp);
               nums[index2]=temp;
    }

   public void downHeapify(int parent,int[] nums){
       int maxIndex=parent;
       int rightChild=2*parent+2;
       int leftChild=2*parent+1;

       if(rightChild<nums.length&&nums[rightChild]>nums[maxIndex]){
           maxIndex=rightChild;
       }

       if(leftChild<nums.length&&nums[leftChild]>nums[maxIndex]){
        maxIndex=leftChild;
    }

    if(maxIndex!=parent){
        swap(maxIndex,parent,nums);
        downHeapify(maxIndex,nums);
    }
   }

}