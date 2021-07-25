class Solution {
    public int maxAscendingSum(int[] arr) {
        int global=-(int)1e9,currSum=0;
        
        currSum=arr[0];
        global=arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            currSum+=arr[i];
            if(arr[i]<=arr[i-1])currSum=arr[i];
            currSum=Math.max(currSum,arr[i]);
            global=Math.max(global,currSum);
            
        }
        return global;
        
    }
}