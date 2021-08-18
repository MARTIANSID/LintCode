class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
       
        
        int count=0;
        
        int[] req=new int[n];
        int chunks=0;
        
        for(int i=0;i<arr.length;i++){
                if(arr[i]!=i){
                    req[i]++;
                    req[arr[i]]--; 
                    if(req[i]!=0)count++;
                    else count--;
                    if(req[arr[i]]!=0)count++;
                    else count--;
                    
                }
            if(count==0)chunks++;
        }
        
        return chunks;
        

    }
}

