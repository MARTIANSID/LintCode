class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) { 
        int n=arr.length;
        int m=queries.length;
        
        int[] left=new int[n];
        int[] right=new int[n];
        
        int xor=0;
        
        for(int i=0;i<n;i++){
            xor^=arr[i];
            left[i]=xor;
        }
        
        xor=0;
        
        for(int i=n-1;i>=0;i--){
            xor^=arr[i];
            right[i]=xor;
        }
        
        int[] ans=new int[m];
        
        int index=0;
        
        for(int[] q:queries){
            int l=q[0],r=q[1];
            
            if(l==0&&r==n-1){
                ans[index++]=right[0];
            }else if(l==0){
                ans[index++]=right[l]^right[r+1];
            }else if(r==n-1){
                ans[index++]=left[r]^left[l-1];
            }else{
                ans[index++]=((right[0]^left[l-1])^right[r+1]);
            }
        }
        return ans;
    }
}