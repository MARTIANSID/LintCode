class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        List<Integer> sortNums=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            sortNums.add(nums[i]);
        }
        Collections.sort(sortNums);
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
        }
        
        int swaps=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=sortNums.get(i)){
              int index=  map.get(sortNums.get(i));
              
              map.put(nums[i],index);
              map.put(sortNums.get(i),i);
              swap(index,i,nums);
              swaps++;
            }
        }
        
        return swaps;
        
    }
    
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}