class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
         int n=nums.length,max=-(int)1e9;
        
        
        for(int ele:nums){
           
           max=Math.max(max,ele);        
        }
        int[] arr=new int[max+1];
        for(int ele:nums){
            arr[ele]=1;
        }
        
        int cnt=0;
        for(int i=1;i<=max;i++){
            int prev=-1;
            for(int j=i;j<=max;j+=i){
                
                if(arr[j]!=0){
                    if(prev!=-1)
                   prev=gcd(j,prev);
                    else
                        prev=j;
                    
                    if(prev==i)break;
                }
            }
        
            if(prev==i)cnt++;
        }
        
        return cnt;
            
    }
    
    public int gcd(int a,int b){
        if(b==0)return a;  
        return gcd(b,a%b);
    }
}