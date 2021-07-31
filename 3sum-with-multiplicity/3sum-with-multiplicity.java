class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int mod=(int)1e9+7;
        long ans=0;
        for(int i=0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            // System.out.println(ans);
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];

                if(sum==target){
                  if(arr[j]!=arr[k]){
                      
                      long cl=1;
                      int cr=1;
                    int p=j+1;
                    int val=arr[j];
                    while(p<k&&arr[p]==val){
                        cl=(cl+1)%mod;
                        p++;
                    }
                    
                    int l=k-1;
                    int v=arr[k];
                    while(l>j&&arr[l]==v){
                        cr=(cr+1)%mod;
                        l--;
                    }
                      
                      ans=(ans+(cl*cr))%mod;
                    k=l;
                    j=p;
                  }else{
                      
                    int elements=k-j+1;
                     ans=(ans+((elements)*(elements-1))/2)%mod;
                     break;
                      

                  }
                    
                }else if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        return (int)(ans%mod);
    }
}