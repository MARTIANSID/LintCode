class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int si=0;
        int ei=0;
        int n=arr.length;
        int avg=0;
        int count=0;  
        int size=0;
         int sum=0;
          while(ei<n){
         size++;
                sum+=arr[ei];
                avg=sum/size;
                ei++;
                
                  while(size>k){
                          sum-=arr[si];
                          size--;
                          avg=sum/size;
                          si++;
                  }
                  
                  if(size==k&&avg>=threshold)count++;
                  
                  
                  
          }
            return count;
    }
}