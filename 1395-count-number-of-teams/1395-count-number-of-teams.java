class Solution {
    public int numTeams(int[] arr) {
        int n=arr.length;
        
        
        int[] dpInc=new int[n];
        
        int[] dpDec=new int[n];
               
         int ans=0;
        

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    ans+=dpInc[j];
                     dpInc[i]++;
                }
                   
            }
            
            
        }
        
        
        
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
              if(arr[i]>arr[j]){
                  ans+=dpDec[j];
                    dpDec[i]++;
              }
                        
                
                
            }
            

        }
        

        
        return ans;
        
        
    }
}