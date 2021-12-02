class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        
        if(n==1)return 1;
        
        int i=0;
        
        while(i+1<n&&arr[i]==arr[i+1]){
            i++;
        }
        
        if(i+1>=n)return 1;
        
        int k= arr[i]>arr[i+1]?1:0;
        
        int ans=2;
        int max=2;
        
        for(i=i+1;i<n-1;i++){
            if(k==1&&arr[i]<arr[i+1]){
                ans++;
                max=Math.max(ans,max);
                k=0;
            }else if(k==0&&arr[i]>arr[i+1]){
                ans++;
                max=Math.max(ans,max);

                k=1;
                
            }else{
               
        while(i+1<n&&arr[i]==arr[i+1]){
            i++;
        }
                
                 ans=2;
                if(i+1>=n)return max;
                k= arr[i]>arr[i+1]?1:0;
                
                
            }
        }
        
        return max;
        
    }
    

}